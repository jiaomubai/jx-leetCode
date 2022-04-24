package reverse;

/**
 * @ClassName: Reverse
 * @Author: jiaomubai
 * @Date: 2021/9/13 08:58
 * @Description: 整数反转, LeetCode 题库第7题
 */
public class Reverse {

    public static int MAX_INT_VALUE = 2147483647;

    public static int MIN_INT_VALUE = -2147483648;

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > MAX_INT_VALUE || result < MIN_INT_VALUE) {
            return 0;
        } else {
            return (int)result;
        }
    }

    public static int reverse2(int x) {
        String s = String.valueOf(x);
        // 判断是否为负数
        boolean isNegative = false;
        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }
        // 数字反转
        s = new StringBuilder(s).reverse().toString();
        s = isNegative ? "-" + s : s;
        try {
            // 数字转换
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int result = reverse(123456);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
