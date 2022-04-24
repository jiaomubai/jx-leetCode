package plusOne;

import java.util.Arrays;

/**
 * @ClassName: PlusOne
 * @Author: jiaoxian
 * @Date: 2021/9/24 09:44
 * @Description:
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int size = digits.length;
        int[] result = new int[size + 1];
        if (digits[size - 1] == 9) {
            result[size] = 0;
            result[size - 1] = 1;
        } else {
            result[size] = digits[size - 1] + 1;
            result[size - 1] = 0;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] == 9 && result[i + 1] == 1) {
                // 后一位出现进位情况，且处理进位之后该位也需向上进位
                result[i + 1] = 0;
                result[i] = 1;
            } else {
                // 后一位出现进位情况，处理之后该位不会向上进位
                // 后一位未出现进位情况
                result[i + 1] = digits[i] + result[i + 1];
                result[i] = 0;
            }
        }
        if (result[0] == 0) {
            result = Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

    /**
     * 数组转字符串，字符串转整数，整数加1之后转成数组
     * @param digits
     * @return
     */
//    public static int[] plusOne2(int[] digits) {
//        String s = "";
//        for (int i = 0; i< digits.length; i++) {
//            s += String.valueOf(digits[i]);
//        }
//        String newStr= String.valueOf(Integer.parseInt(s) + 1);
//        char[] charArray = newStr.toCharArray();
//        int[] result = new int[charArray.length];
//        for (int i = 0; i < charArray.length; i++) {
//            result[i] = Integer.parseInt(String.valueOf(charArray[i]));
//        }
//        return result;
//    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int [] digits = new int[]{1,9,7};
        int[] result = plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
