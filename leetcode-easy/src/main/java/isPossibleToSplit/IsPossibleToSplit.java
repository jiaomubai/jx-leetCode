package isPossibleToSplit;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: IsPossibleToSplit
 * @Description: leetCode-3046:分割数组
 * @Author: jiaoxian
 * @Date: 2025-01-09 17:56:46
 * @Version: 1.0
 **/

public class IsPossibleToSplit {

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 4, 1, 6};
        System.out.println(new IsPossibleToSplit().isPossibleToSplit(nums));
    }

}
