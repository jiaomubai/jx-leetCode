package arrangeCoins;

/**
 * @ClassName: ArrangeCoins
 * @Author: jiaoxian
 * @Date: 2022/4/29 18:22
 * @Description: leetCode-441: 排列硬币
 */
public class ArrangeCoins {

    public static int arrangeCoins(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if (n < i + 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(2147483647));
    }

}
