package twoSum;

import java.util.HashMap;

/**
 * @ClassName: TwoSum
 * @Author: jiaomubai
 * @Date: 2021/9/10 15:25
 * @Description: 两数之和, LeetCode 题库第1题
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(length);
        for (int i = 0; i < length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void display(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(nums[nums.length - 1] + "}");
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = new int[]{2, 7, 11, 15, 16, 17, 20};
        System.out.print("nums[] = {");
        display(nums);
        int target = 37;
        int[] result = twoSum2(nums, target);
        System.out.print("result[] = {");
        display(result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
