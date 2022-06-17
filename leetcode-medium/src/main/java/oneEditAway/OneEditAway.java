package oneEditAway;

/**
 * @ClassName: OneEditAway
 * @Author: jiaoxian
 * @Date: 2022/6/14 15:15
 * @Description: leetCode-面试题 01.05: 一次编辑
 */
public class OneEditAway {

    /**
     * 记 m 为 first 字符串的长度, n 为 second 字符串的长度
     * 当 |m - n| > 1, 即两个字符串的长度相差大于等于 2 时, 直接 return false, 因为无法通过一次或更少的编辑使得两个串相等
     * 为了处理方便, 我们需保证 first 字符串为较短的一个, 所以当 second 的长度大于 first 时, 将两字符串交换
     * 使用 i 遍历 first 字符串, j 遍历 second 字符串, count 用来记录操作次数
     * 如果 i 和 j 对应的字符相等, 则同时右移
     * 如果 i 和 j 不相等且 m == n, 这种情况可通过替换操作使两字符相等, 从而保证两字符串相等, 所以 i 和 j 同时右移, 同时 count 自增 1
     * 如果 i 和 j 不相等且 m ≠ n, 因为我们保证了 first 是较短的一个串, 所以此时 m < n, 这种情况可通过添加或删除操作使两字符相等, 从而保证两字符串相等, 此时, i 不变, j 右移, 同时 count 自增 1
     * 遍历进行的条件是 i < m && j < n && count <= 1, 循环结束后将 count 是否小于等于 1 的结果返回即可
     **/

    public boolean oneEditAway(String first, String second) {
        if (first.length() == 0 || second.length() == 0) {
            return true;
        }
        int m = first.length();
        int n = second.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        if (m > n) {
            // 保证 first 是较短的一个
            return oneEditAway(second, first);
        }
        // i 控制 first 的遍历
        int i = 0;
        // j 控制 second 的遍历
        int j = 0;
        // count 记录操作次数
        int count = 0;
        while (i < m && j < n && count <= 1) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(j);
            if (firstChar == secondChar) {
                // 若两个字符相等, 则同时右移
                i++;
                j++;
            } else {
                // 若两个字符不相等
                if (m == n) {
                    // 只能是替换操作
                    count++;
                    i++;
                    j++;
                } else {
                    // m ≠ n, 因为已经确保了 first 为较短的一个串, 所以此时 m < n
                    // 插入或删除操作
                    j++;
                    count++;
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new OneEditAway().oneEditAway("palet", "palt"));
    }

}
