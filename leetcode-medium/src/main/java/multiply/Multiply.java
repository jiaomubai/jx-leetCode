package multiply;

/**
 * @ClassName: Multiply
 * @Description: leetCode-43:字符串相乘
 * @Author: jiaoxian
 * @Date: 2025-02-10 09:34:07
 * @Version: 1.0
 **/

public class Multiply {

    // 两个长度为n和m的数相乘,长度不会超过n+m, 所以创建一个n+m的数组来存储结果, 最后忽略前导0
    // 基本思路:逐位相乘,注意进位
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] result = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int r = a * b;
                r = r + result[i + j + 1];
                // 存储个位
                result[i + j + 1] = r % 10;
                // 存储进位
                result[i + j] += r / 10;
                // 示例：a = 5, b = 7, r = 35, 则 result[0] = 3, result[1] = 5
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            if (stringBuilder.length() == 0 && result[i] == 0) {
                continue;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {

    }

}
