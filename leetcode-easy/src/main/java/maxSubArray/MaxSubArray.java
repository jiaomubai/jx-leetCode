package maxSubArray;

/**
 * @ClassName: MaxSubArray
 * @Author: jiaomubai
 * @Date: 2021/9/14 16:47
 * @Description: 最大子序和, LeetCode 题库第53题
 */
public class MaxSubArray {

    public static int MIN_INT_VALUE = -2147483648;

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        // result 始终记录最大子序和
        int result = MIN_INT_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    public static int maxSubArray1(int[] nums) {
        int sum = 0;
        // result 始终记录最大子序和
        int result = MIN_INT_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            sum= 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = sum > result ? sum : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray1(nums);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
