package singleNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SingleNumber
 * @Author: jiaomubai
 * @Date: 2022/1/29 15:42
 * @Description: 139.只出现一次的数字
 */
public class SingleNumber {

    public static Integer singleNumber(Integer[] nums) {
        Map<Integer, Integer> singleNumberMap = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if (singleNumberMap.containsKey(nums[i])) {
                singleNumberMap.remove(nums[i]);
            } else {
                singleNumberMap.put(nums[i], 1);
            }
        }
        for (Integer key : singleNumberMap.keySet()) {
            return key;
        }
        return -1;
    }

    public static Integer singleNumber2(Integer[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i< nums.length; i += 2) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if (!nums[i].equals(nums[i+1])) {
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 1, 2, 4};
        Integer result = singleNumber(nums);
        System.out.println("result = " + result);
    }

}
