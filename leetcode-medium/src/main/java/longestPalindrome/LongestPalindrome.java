package longestPalindrome;

/**
 * @ClassName: LongestPalindrome
 * @Author: jiaoxian
 * @Date: 2022/5/21 17:59
 * @Description: leetCode-5: 最长回文子串
 */
public class LongestPalindrome {

    /**
     * 暴力求解
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 记录最长回文串的长度
        int maxLength = 0;
        // 记录最长回文串的开始下标
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // 当前子串的长度
                int currentLength = j - i + 1;
                // 如果当前区间的长度比最大回文串长度小, 则直接 continue
                if (currentLength <= maxLength) {
                    continue;
                }
                // 判断当前 [i, j] 区间内的子串是不是回文
                if (isPalindrome(s, i, j)) {
                    // 可将回文串输出
                    // System.out.println(s.substring(i, j + 1));
                    // 如果为回文子串且 则更新 maxLength
                    startIndex = i;
                    maxLength = currentLength;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 记录最长回文串的长度
        int maxLength = 0;
        // 记录最长回文串的开始下标
        int startIndex = 0;
        for (int i = 0; i < s.length();) {
            int left = i;
            int right = i;
            // 如果当前字符后面的几个字符都是相同的, 那么看做一个整体进行扩散
            while (right < s.length() - 1 && s.charAt(i) == s.charAt(right + 1)) {
                right++;
            }
            // 更新循环变量 i, 下次循环直接从 i = right + 1 开始
            i = right + 1;
            // 向左右扩散, 寻找最长回文串
            while (left > 0 && right < s.length() - 1 && s.charAt(right + 1) == s.charAt(left - 1)) {
                right++;
                left--;
            }
            // 当前子串的长度
            int currentLength = right -left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    /**
     * 动态规划法
     * @param s
     * @return
     */
    public static String longestPalindrome3(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 记录最长回文串的长度
        int maxLength = 0;
        // 记录最长回文串的开始下标
        int startIndex = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = false;
                    continue;
                } else {
                    if (right - left <= 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if (dp[left][right]) {
                    if (right - left + 1 > maxLength) {
                        maxLength = right - left + 1;
                        startIndex = left;
                    }
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                int number = 0;
//                if (dp[i][j]) {
//                    number = 1;
//                }
//                System.out.printf("%2d", number);
//            }
//            System.out.println();
//        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String palindrome = longestPalindrome1(s1);
        //System.out.println(palindrome);
        String s2 = "bcabbbacd";
        String palindrome2 = longestPalindrome2(s2);
        //System.out.println(palindrome2);
        String s3 = "acbeaebc";
        String palindrome3 = longestPalindrome3(s3);
        System.out.println(palindrome3);
    }

}
