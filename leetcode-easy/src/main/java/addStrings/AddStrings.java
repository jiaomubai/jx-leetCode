package addStrings;

import java.util.Arrays;

/**
 * @author jiaoxian
 * @name addStrings
 * @date 2022/12/26 15:19
 * @description leetCode-415: 字符串相加
 */
public class AddStrings {

    // 较短的一个字符串作为 num1, 并且前补 0 使其与较长的字符串 num2 长度相等, 所以前补 0 的字符串一定是 num1
    // 使用数组存储各位相加的结果, 考虑到有进位的情况产生, 数组的大小为最长的字符串长度加一
    // 逆序遍历两个字符串, 逐位相加, 并设置临时变量 temp 记录是否产生进位
    // 每位的加法结果可表示为 num1[i] + num2[i] + temp
    // 将每位的相加结果顺序存储到数组中, 最后逆序遍历数组即可得到最终结果

    public String addStrings(String num1, String num2) {
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println();
        int length1 = num1.length();
        int length2 = num2.length();
        int newLength = Math.max(length1, length2);
        int[] result = new int[ newLength+ 1];
        Arrays.fill(result, -1);
        // 遍历数组的变量
        int index = 0;
        // 记录进位
        int temp = 0;
        if (length1 > length2) {
            // 如果 num1 比 num2 长, 则给 num2 前补 0
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = length2; i < length1; i++) {
                stringBuilder.append(0);
            }
            stringBuilder.append(num2);
            // 交换 num1 和 num2, num1 一定是前补 0 的字符串
            num2 = num1;
            num1 = stringBuilder.toString();
        }
        if (length1 < length2) {
            // 如果 num1 比 num2 短, 则给 num1 前补 0
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = length1; i < length2; i++) {
                stringBuilder.append(0);
            }
            stringBuilder.append(num1);
            num1 = stringBuilder.toString();
        }
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        for (int i = newLength - 1; i >= 0; i--) {
            int a = num1.charAt(i) - 48;
            int b = num2.charAt(i) - 48;
            // 相加
            int currentSum = a + b + temp;
            // 如果产生进位, 则设置进位为 1
            if (currentSum > 9) {
                temp = 1;
                currentSum = currentSum % 10;
            } else {
                temp = 0;
            }
            result[index++] = currentSum;
        }
        // 逆序遍历数组, 去掉前导 0
        StringBuilder tempStringBuilder = new StringBuilder();
        for (int i = newLength; i >= 0; i--) {
            if (i == newLength) {
                if (temp > 0) {
                    tempStringBuilder.append(1);
                }
            } else {
                tempStringBuilder.append(result[i]);
            }
        }
        return tempStringBuilder.toString();
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings(num1, num2));
    }

}
