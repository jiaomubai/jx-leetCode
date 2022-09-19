package mostFrequentEven;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MostFrequentEven
 * @Description: leetCode-2404: 出现最频繁的偶数元素
 * @Author: jiaoxian
 * @Date: 2022/9/14 15:25
 **/
public class MostFrequentEven {

    // 暴力法
    // 创建一个 map 来存储数组中每个偶数元素出现的次数, key 为偶数元素, value 为该偶数元素出现的次数
    // 遍历 map 的 value, 找到出现的最多次数
    // 遍历 map 的 key, 找到出现次数最多的元素
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (tempMap.containsKey(nums[i])) {
                    int value = tempMap.get(nums[i]);
                    tempMap.put(nums[i], ++value);
                } else {
                    tempMap.put(nums[i], 1);
                }
            }
        }
        int frequen = 0;
        int frequenElement = 2147483647;
        // 遍历 map 的 value, 找到出现最多的次数
        for (Integer value : tempMap.values()) {
            if (value > frequen) {
                // 找到最多的次数
                frequen = Math.max(frequen, value);
            }
        }
        if (frequen == 0) {
            // 如果最多的次数等于0, 则给结果赋值为 -1
            frequenElement = -1;
        } else {
            // 遍历 map 的 key, 找到出现最多次数且数值较小的元素
            for (Integer key : tempMap.keySet()) {
                if (tempMap.get(key) == frequen) {
                    frequenElement = Math.min(frequenElement, key);
                }
            }
        }
        return frequenElement;
    }

    public static void main(String[] args) {
        MostFrequentEven mostFrequentEven = new MostFrequentEven();
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        System.out.println(mostFrequentEven.mostFrequentEven(nums));
    }

}
