package maxProfit;

/**
 * @ClassName: MaxProfit
 * @Author: jiaoxian
 * @Date: 2021/11/8 17:58
 * @Description:
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 默认最小收益为 prices[0]
        int minProfit = prices[0];
        // 默认最大收益为 0
        int maxProfit = 0;
        for (int i = 1; i <prices.length; i++) {
            // 如果在第 i 天卖出,则更新最大收益
            maxProfit = Math.max(maxProfit, prices[i] - minProfit);
            // 如果在第 i 天买入,则更新最小收益
            minProfit = Math.min(minProfit, prices[i]);
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] prices = new int[]{1, 2, 3, 4, 6, 5, 7, 10};
        int result = maxProfit(prices);
        System.out.println(result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
