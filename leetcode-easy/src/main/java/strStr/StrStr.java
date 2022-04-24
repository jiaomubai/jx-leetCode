package strStr;

/**
 * @ClassName: StrStr
 * @Author: jiaomubai
 * @Date: 2021/9/13 15:42
 * @Description: 实现 strStr, LeetCode 题库第28题
 */
public class StrStr {

    public static int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        for (int i = 0; i <= haystackArray.length - needleArray.length; i++) {
            int j;
            for (j = 0; j < needleArray.length; j++) {
                if (haystackArray[i + j] != needleArray[j]) {
                    break;
                }
            }
            if (j == needleArray.length) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int left = 0, right = 0, index = 0;
        while (right < haystack.length() && index < needle.length()) {
            if (haystack.charAt(right) != needle.charAt(index)) {
                left++;
                right++;
                index = 0;
            } else {
                right++;
                index++;
            }
        }
        return index == needle.length() ? left : -1;
    }

    public static int strStr3(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String hayStack = "hello";
        String needle = "ll";
        int result = strStr3(hayStack, needle);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
