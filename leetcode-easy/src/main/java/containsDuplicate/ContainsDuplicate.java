package containsDuplicate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ContainsDuplicate
 * @Author: jiaoxian
 * @Date: 2022/5/1 10:58
 * @Description: leetCode-218: 存在重复元素
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer key : nums) {
            if (hashMap.containsKey(key)) {
                Integer value = hashMap.get(key);
                hashMap.put(key, value + 1);
            } else {
                hashMap.put(key, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer key : nums) {
            if (hashMap.containsKey(key)) {
                return true;
            } else {
                hashMap.put(key, 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate2(nums));
    }

}
