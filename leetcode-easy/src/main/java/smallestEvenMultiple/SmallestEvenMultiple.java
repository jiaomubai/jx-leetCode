package smallestEvenMultiple;

/**
 * @ClassName: SmallestEvenMultiple
 * @Description: leetCode-2413: 最小偶倍数
 * @Author: jiaoxian
 * @Date: 2022/9/19 10:19
 **/
public class SmallestEvenMultiple {

    // 给你一个正整数 n, 返回 2 和 n 的最小公倍数(正整数).

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            // 如果 n 是偶数, 则直接返回 n
            return n;
        }
        // 如果 n 是奇数, 返回 n * 2
        return 2 * n;
    }

    public static void main(String[] args) {
        SmallestEvenMultiple smallestEvenMultiple = new SmallestEvenMultiple();
        System.out.println(smallestEvenMultiple.smallestEvenMultiple(5));
    }

}
