package intersection;

import util.ArrayDisplayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Intersection
 * @Author: jiaoxian
 * @Date: 2022/5/2 15:58
 * @Description: leetCode-349: 两个数组的交集
 */
public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : nums1) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, 1);
            }
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int value : nums2) {
            if (hashMap.containsKey(value)) {
                resultSet.add(value);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int i : resultSet) {
            result[index++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {4, 3, 2, 1, 5};
        int[] result = intersection(nums1, nums2);
        ArrayDisplayUtil.arrayDisplay(result);
    }

}
