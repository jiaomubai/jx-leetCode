package longestContinuousSubstring;

/**
 * @ClassName: LongestContinuousSubstring
 * @Description: leetCode-2414: 最长的字母序连续子字符串的长度
 * @Author: jiaoxian
 * @Date: 2022/9/19 10:32
 **/
public class LongestContinuousSubstring {

    // 定义 maxLength 为最长的连续字母序的长度, currentLength 为当前最长连续字母序的长度, 初始值为 1, 即当前字符, 最终返回 maxLength 和 currentLength 中较大值即可
    // 遍历字符串, 如果下一个字符串与当前字符串为连续字母序(即两个字符连续), 则 currentLength 自增 1
    // 如果两个字符不连续, 更新 maxLength 并恢复 currentLength
    // 循环结束后, 再更新 maxLength, 考虑到最后一个字符与倒数第二个字符为字母序的情况

    public int longestContinuousSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) - s.charAt(i) == 1) {
                currentLength += 1;
            } else {
                maxLength = Math.max(currentLength, maxLength);
                currentLength = 1;
            }
        }
        return Math.max(currentLength, maxLength);
    }

    // 借助 StringBuilder 来存放符合字母序的子字符串, 基本处理逻辑与 longestContinuousSubstring() 方法相同

    public int longestContinuousSubstring2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = 0;
        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                stringBuilder.append(s.charAt(i));
            } else {
                maxLength = Math.max(maxLength, stringBuilder.toString().length());
                stringBuilder = new StringBuilder();
                stringBuilder.append(s.charAt(i));
            }
        }
        return Math.max(maxLength, stringBuilder.toString().length());
    }

    public static void main(String[] args) {
        LongestContinuousSubstring longestContinuousSubstring = new LongestContinuousSubstring();
        String s = "abcdeghijklmn";
        System.out.println("result1 = " + longestContinuousSubstring.longestContinuousSubstring(s));
        System.out.println("result2 = " + longestContinuousSubstring.longestContinuousSubstring2(s));
    }

}
