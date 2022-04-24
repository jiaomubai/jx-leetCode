package addBinary;

import java.math.BigInteger;

/**
 * @ClassName: AddBinary
 * @Author: jiaoxian
 * @Date: 2021/9/24 14:04
 * @Description:
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        char[] charArray1 = a.toCharArray();
        char[] charArray2 = b.toCharArray();
        int[] resultArray = new int[Math.max(charArray1.length, charArray2.length) + 1];
        int i = charArray1.length - 1;
        int j = charArray2.length - 1;
        int index = resultArray.length - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            if (resultArray[index] == 1) {
                if (charArray1[i] == '1' && charArray2[j] == '1') {
                    // 进位产生 1 1 的情况
                    resultArray[index] = 1;
                    resultArray[index - 1] = 1;
                } else if (charArray1[i] == '1' || charArray2[j] == '1') {
                    // 进位产生 1 0 的情况
                    resultArray[index] = 0;
                    resultArray[index - 1] = 1;
                } else {
                    resultArray[index] = 1;
                    resultArray[index - 1] = 0;
                }
            } else {
                if (charArray1[i] == '1' && charArray2[j] == '1') {
                    // 进位产生 1 0 的情况
                    resultArray[index] = 0;
                    resultArray[index - 1] = 1;
                } else if (charArray1[i] == '1' || charArray2[j] == '1') {
                    resultArray[index] = 1;
                    resultArray[index - 1] = 0;
                } else {
                    resultArray[index] = 0;
                    resultArray[index - 1] = 0;
                }
            }
            index--;
        }
        // 如果 a 比 b 长
        if (i >= 0) {
            for (; i >= 0; i--) {
                if (charArray1[i] == '1' && resultArray[index] == 1) {
                    resultArray[index] = 0;
                    resultArray[index - 1] = 1;
                } else {
                    resultArray[index] = Integer.parseInt(String.valueOf(charArray1[i])) + Integer.parseInt(String.valueOf(resultArray[index]));
                }
                index--;
            }
        }
        // 如果 b 比 a 长
        if (j >= 0) {
            for (; j >= 0; j--) {
                if (charArray2[j] == '1' && resultArray[index] == 1) {
                    resultArray[index] = 0;
                    resultArray[index - 1] = 1;
                } else {
                    resultArray[index] = Integer.parseInt(String.valueOf(charArray2[j])) + Integer.parseInt(String.valueOf(resultArray[index]));
                }
                index--;
            }
        }
        String result = "";
        for (int r = 1; r < resultArray.length; r++) {
            result += resultArray[r];
        }
        if (resultArray[0] != 0) {
            result = "1" + result;
        }
        return result;
    }

    public static String addBinary2(String a, String b) {
        BigInteger n1 = new BigInteger(a,2);
        BigInteger n2 = new BigInteger(b,2);
        BigInteger add = n1.add(n2);
        return add.toString(2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String a = "101111";
        String b = "10";
        String result = addBinary2(a, b);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
