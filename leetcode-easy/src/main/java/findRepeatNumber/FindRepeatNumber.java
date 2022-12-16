package findRepeatNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name findRepeatNumber
 * @date 2022/12/14 14:22
 * @description leetCode-剑指 Offer 03: 数组中重复的数字
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        // 使用 map 去存储每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) == 2) {
                return i;
            }
        }
        return 0;
    }

}
