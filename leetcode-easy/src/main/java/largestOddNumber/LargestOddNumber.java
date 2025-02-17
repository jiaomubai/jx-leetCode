package largestOddNumber;

/**
 * @ClassName: LargestOddNumber
 * @Description: leetCode-1903:字符串中的最大奇数
 * @Author: jiaoxian
 * @Date: 2025-01-10 14:54:47
 * @Version: 1.0
 **/

public class LargestOddNumber {

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "12598769";
        System.out.println(new LargestOddNumber().largestOddNumber(num));
    }

}
