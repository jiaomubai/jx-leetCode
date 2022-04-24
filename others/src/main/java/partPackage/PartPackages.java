package partPackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: PartPackages
 * @Author: jiaoxian
 * @Date: 2021/10/26 13:59
 * @Description: 部分背包问题
 */
public class PartPackages {

    public static BigDecimal getHighestValue(int capacity, int[] weights,int[] values) {

        // 创建物品列表并按照性价比倒序
        List<Item> itemList = new ArrayList<>();
        for(int i=0; i < weights.length; i++) {
            itemList.add(new Item(weights[i], values[i]));
        }
        itemList = itemList.stream().sorted(Comparator.comparing(Item::getRatio).reversed()).collect(Collectors.toList());

        // 背包剩余容量
        int restCapacity = capacity;
        // 当前背包物品的最大价值
        BigDecimal highestValue = BigDecimal.ZERO;

        // 按照性价比从高到低选择物品
        for (Item item : itemList) {
            if (item.weight <= restCapacity) {
                highestValue = highestValue.add(new BigDecimal(item.value));
                restCapacity -= item.weight;
            } else {
                // 背包装不下完整物品时，选择该件物品的一部分
                BigDecimal partCapacity = new BigDecimal(restCapacity).divide(new BigDecimal(item.weight), 2, BigDecimal.ROUND_HALF_UP)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);
                highestValue = highestValue.add(partCapacity.multiply(new BigDecimal(item.value)));
                break;
            }
        }
        return highestValue;
    }

    // 静态内部类 Item
    static class Item {
        private int weight;
        private int value;
        //物品的性价比
        private BigDecimal ratio;

        public Item (int weight, int value) {
            this.weight = weight;
            this.value = value;
            // 性价比 = 价值 / 重量
            this.ratio = new BigDecimal(value).divide(new BigDecimal(weight), 2, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        public BigDecimal getRatio() {
            return ratio;
        }
    }

    public static void main(String[] args) {
        int capacity = 20;
        int[] weights = {4, 8, 3, 6, 5, 4};
        int[] values = {8, 2, 4, 6, 4, 3};
        System.out.println("背包最大价值：" + getHighestValue(capacity, weights, values));
    }

}
