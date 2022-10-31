package numWaterBottles;

/**
 * @ClassName: NumWaterBottles
 * @Description: leetCode-1518: ��ˮ����
 * @Author: jiaoxian
 * @Date: 2022/10/31 15:50
 **/
public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {

        int bottle = numBottles;
        int result = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            // ÿ numExchange ��ƿ�ӿ��Ի�ȡ 1 ƿˮ
            ++result;
            // numExchange ��ƿ�Ӷһ� 1 ƿˮ֮����һ����ƿ
            ++bottle;
        }
        return result;
    }

}
