package commonFactors;

/**
 * @ClassName: CommonFactors
 * @Description: leetCode-2427: 公因子的数目
 * @Author: jiaoxian
 * @Date: 2022/10/9 14:56
 **/
public class CommonFactors {

    // 先确保 b 为  两个数中较小的一个
    // 从 1 开始遍历, 到 b 结束, 一次判断当前数能否整除 a 和 b, 如果可以, 则公因子的数目加 1
    public int commonFactors(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int result = 0;
        for (int i = 1; i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonFactors commonFactors = new CommonFactors();
        System.out.println(commonFactors.commonFactors(12, 20));
    }

}
