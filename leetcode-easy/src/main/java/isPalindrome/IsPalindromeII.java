package isPalindrome;

/**
 * @ClassName: IsPalindromeII
 * @Author: jiaoxian
 * @Date: 2021/11/17 16:01
 * @Description: 验证回文串
 */
public class IsPalindromeII {

    public static boolean isPalindrome(String s) {
        // 过滤,保留字母和数字,并全部转换为小写
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(s);
        int length = s.length();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        boolean result = isPalindrome("0P");
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
