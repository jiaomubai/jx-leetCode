package finalPrices;

/**
 * @ClassName: FinalPrices
 * @Description: leetCode-1475: 商品折扣后的最终价格
 * @Author: jiaoxian
 * @Date: 2022/9/1 16:40
 **/
public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        out:
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= price) {
                    result[i] = price - prices[j];
                    continue out;
                }
            }
            result[i] = price;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8,4,6,2,3};
        int[] result = new FinalPrices().finalPrices(prices);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%4d", result[i]);
        }
        System.out.println();

    }


}
