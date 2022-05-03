package containsNearbyDuplicate;

import java.util.HashMap;

/**
 * @ClassName: ContainsNearbyDuplicate
 * @Author: jiaoxian
 * @Date: 2022/5/1 11:27
 * @Description: leetCode-219: 存在重复元素 II
 */
public class ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            if (hashMap.containsKey(key)) {
                if (i - hashMap.get(key) <= k) {
                    return true;
                } else {
                    // 很重要
                    hashMap.put(key, i);
                }
            } else {
                hashMap.put(key, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

}
