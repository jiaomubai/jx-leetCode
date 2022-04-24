package isPalindrome;

/**
 * @ClassName: IsPalindrome
 * @Author: jiaomubai
 * @Date: 2021/9/13 09:36
 * @Description: 回文数, LeetCode 题库第9题
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        int reverse = 0;
        int temp = x;
        while ( x > 0) {
            // 获取 x 反转后的结果 Reverse
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        if (reverse == temp) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {
        // 若 x 为负数，直接 false 返回
        if (x < 0) {
            return false;
        }
        // 将 x 转换成数组形式
        char[] tempArray = String.valueOf(x).toCharArray();
        int length = tempArray.length;
        for (int i = 0; i < length / 2; i++) {
            if (tempArray[i] != tempArray[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        boolean result = isPalindrome2(123321);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
