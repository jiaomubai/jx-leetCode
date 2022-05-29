package repeatedNTimes;

import java.util.HashMap;

/**
 * @ClassName: RepeatedNTimes
 * @Author: jiaoxian
 * @Date: 2022/5/21 12:10
 * @Description: leetCode-961: 在长度 2N 的数组中找出重复 N 次的元素
 */
public class RepeatedNTimes {

    public static int repeatedNTimes(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> tempHash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tempHash.containsKey(nums[i])) {
                return nums[i];
            }
            tempHash.put(nums[i], i);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int result = repeatedNTimes(nums);
        System.out.println(result);
    }

}
