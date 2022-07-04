package findLUSlength;

/**
 * @ClassName: FindLUSlength
 * @Author: jiaoxian
 * @Date: 2022/6/27 11:21
 * @Description:
 */
public class FindLUSlength {

    // 给出一个字符串数组，在里面找出字符串满足当前字符串不是字符串数组中其他字符串的子序列，返回满足条件的字符串中最长的字符串的长度

    // 官方题解：对于给定的某个字符串 str[i]，如果它的一个子序列 sub 是「特殊序列」，那么 str[i] 本身也是一个「特殊序列」。
    // 这是因为 sub 如果没有在除了 str[i] 之外的字符串中以子序列的形式出现过，那么给 sub 不断地添加字符，它也不会出现。而 str[i] 就是 sub 添加若干个（可以为零个）字符得到的结果。
    // 因此我们只需要使用一个双重循环
    // 1.外层枚举每一个字符串 str[i] 作为特殊序列
    // 2.内层枚举每一个字符串 str[j] (i≠j)，判断 str[i] 是否不为 str[j] 的子序列即可。
    // 要想判断 str[i] 是否为 str[j] 的子序列，我们可以使用贪心 + 双指针的方法
    // 即初始时指针 pti 和 ptj\ 分别指向两个字符串的首字符。
    // 如果两个字符相同，那么两个指针都往右移动一个位置，表示匹配成功；
    // 否则只往右移动指针 ptj，表示匹配失败。
    // 如果 pti 遍历完了整个字符串，就说明 str[i] 是 str[j] 的子序列。
    // 在所有满足要求的 str[i] 中，我们选出最长的那个，返回其长度作为答案。
    // 如果不存在满足要求的字符串，那么返回 −1。

    public int findLUSlength(String[] strs) {
        int length = strs.length;
        int result = -1;
        for (int i = 0; i < length; ++i) {
            boolean check = true;
            for (int j = 0; j < length; ++j) {
                if (i != j && isSubstr(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            // 如果 check 为 true, 表示 str[i] 不是其他串的子序列, 即 str[i] 为特殊序列
            if (check) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    /**
     * 判断 s 是否为 t 的子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubstr(String s, String t) {
        int pts = 0, ptt = 0;
        while (pts < s.length() && ptt < t.length()) {
            if (s.charAt(pts) == t.charAt(ptt)) {
                ++pts;
            }
            ++ptt;
        }
        return pts == s.length();
    }

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "aaa";
        String str3 = "aa";
        String[] strs = {str1, str2, str3};
        System.out.println(new FindLUSlength().findLUSlength(strs));

    }

}
