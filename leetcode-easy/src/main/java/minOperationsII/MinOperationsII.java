package minOperationsII;

/**
 * @author jiaoxian
 * @name minOperationsII
 * @date 2022/12/2 15:46
 * @description leetCode-1758: 生成交替二进制字符串的最少操作数
 */
public class MinOperationsII {

    /**
     * @description
     * @author jiaoxian
     * @date 2022/12/2 15:47
     * @param s 原字符串
     * @return int
     */

    // 变成这两种不同的交替二进制字符串所需要的最少操作数加起来等于 s 的长度
    // 假设字符串 s 的长度为 10, 变成 "0101...." 的形式总共需要 6 步
    // 则变成 "1010...." 的形式总共需要 4 步

    public int minOperations(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar != (char) ('0' + i % 2)) {
                result++;
            }
        }
        return Math.min(result, s.length() - result);
    }

    public static void main(String[] args) {
        String s = "0001100110011110";
        System.out.println(new MinOperationsII().minOperations(s));
    }

}
