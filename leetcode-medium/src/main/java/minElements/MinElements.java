package minElements;

/**
 * @author jiaoxian
 * @name minElements
 * @date 2022/12/16 10:43
 * @description leetCode-1785: 构成特定和需要添加的最少元素
 */
public class MinElements {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }

}
