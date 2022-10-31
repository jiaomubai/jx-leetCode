package numWaterBottles;

/**
 * @ClassName: NumWaterBottles
 * @Description: leetCode-1518: 换水问题
 * @Author: jiaoxian
 * @Date: 2022/10/31 15:50
 **/
public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {

        int bottle = numBottles;
        int result = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            // 每 numExchange 个瓶子可以换取 1 瓶水
            ++result;
            // numExchange 个瓶子兑换 1 瓶水之后会多一个空瓶
            ++bottle;
        }
        return result;
    }

}
