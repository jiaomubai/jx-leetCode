package kthGrammar;

import util.ArraysUtil;

/**
 * @ClassName: KthGrammar
 * @Description: leetCode-779: 第 K 个语法符号
 * @Author: jiaoxian
 * @Date: 2022/10/20 16:27
 **/
public class KthGrammar {

    public int kthGrammar(int n, int k) {

        // 0
        // 01
        // 0110
        // 01101001
        // 可以看到, 第 n 行总共有 2 ^ (n - 1) 个数, 除了第一行外每行的数字的数目都是偶数, 同时这些数可以平均分为两部分
        // 前一部分与第 n - 1 行的完全相同; 后一部分是第 n - 1 行的每个数字取反
        // 对于 k 而言, 我们需要考虑 k 与当前行数字总数的一半的关系, 如果 k 小于等于第 n 行数字总数的一半, 即 k < n - 1 行的数目总数, 则第 n 行第 k 个数字即为第 n - 1 行的第 k 个数字;
        // 如果 k 小于第 n 行数字总数的一半, 即 k > n - 1 行的数目总数, 那就取第 n - 1 行的第 (k - n) 个数字的相反数
        // 例: 如果要求第 4 行的第 6 个元素: 那第 6 个元素是 0, 它是与上一行(第 3 行)第 2(即(6 - 4)) 个元素相反的元素. 这是 k > n - 1 行数字总数的情况;
        // 即要想知道第 4 行的第 6 个元素是什么, 就需要知道第 3 行第 2 个元素是什么. 当 k = 2, n = 3 时, 这是属于 k < n - 1 行数字总数的情况, 所以应该求上一行(即第 2 行)的第 k 个元素.

        return dfs(n, k);
    }

    private int dfs(int n, int k) {
        // 边界条件
        if (n == 1) {
            return 0;
        }
        // 求上一行数字的总数(当 n == 3 时, 上一行(即第 2 行)有 2 ^ (3 - 2) = 2 个数字)
        int len = (int) Math.pow(2, n - 2);
        if (k - len <= 0) {
            // 如果 k 小于等于 len, 则第 n 行第 k 个数字就等于 第 n - 1 行第 k 个数字
            return dfs(n - 1, k);
        } else {
            // 如果 k 大于 len, 则第 n 行第 k 个数组就等于第 n - 1 行第 (k - len) 个数字的相反数
            return dfs(n - 1, k - len) == 0 ? 1 : 0;
        }

    }

    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();
        System.out.println(kthGrammar.kthGrammar(3,3));
    }

}
