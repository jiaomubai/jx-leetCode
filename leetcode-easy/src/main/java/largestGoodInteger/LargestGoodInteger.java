package largestGoodInteger;

/**
 * @ClassName: LargestGoodInteger
 * @Description: leetCode-2264:字符串中最大的 3 位相同数字
 * @Author: jiaoxian
 * @Date: 2025-01-10 14:03:52
 * @Version: 1.0
 **/

public class LargestGoodInteger {

    public String largestGoodInteger(String num) {
        String result = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String temp = num.substring(i, i + 3);
                if (temp.compareTo(result) > 0) {
                    result = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String num = "000117772345666";
        System.out.println(new LargestGoodInteger().largestGoodInteger(num));
    }

}
