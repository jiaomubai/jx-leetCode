package countHomogenous;

/**
 * @author jiaoxian
 * @name countHomogenous
 * @date 2022/12/26 14:32
 * @description leetCode-1759: 统计同构子字符串的数目
 */
public class CountHomogenous {

    // 同构字符串的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
    // 统计每一段连续相同字符的个数 k, 每有 k 个相同的连续字符，则这一段同构字符串的数量为 1 + 2 +...+ k 个; 当遇到不同字符时, 重置 k 为1

    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        long result = 1L;
        int k = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                k++;
            } else {
                k = 1;
            }
            result += k;
            System.out.println(result);
        }
        return (int) (result % MOD);
    }

    public static void main(String[] args) {
        String s = "zzzzzz";
        System.out.println(new CountHomogenous().countHomogenous(s));
    }

}
