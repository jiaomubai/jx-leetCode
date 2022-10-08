package maxAscendingSum;

/**
 * @ClassName: MaxAscendingSum
 * @Description: leetCode-1800: 最大升序子数组和
 * @Author: jiaoxian
 * @Date: 2022/10/8 16:59
 **/
public class MaxAscendingSum {

    // 遍历
    // 使用两个遍历来记录当前升序子数组的和以及最大升序子数组的和
    // 循环遍历 nums[] 数组, 根据条件更新 sum 和 result

    public int maxAscendingSum(int[] nums) {
        // 最大升序子数组和
        int result = 0;
        // 当前升序子数组和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == nums.length - 1 || nums[i + 1] <= nums[i]) {
                // 非升序子数组
                result = Math.max(result, sum);
                sum = 0;
            }
        }
        return Math.max(result, sum);
    }

    public static void main(String[] args) {
        MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
        int[] nums = new int[]{1, 2, 3, 7, 5};
        System.out.println(maxAscendingSum.maxAscendingSum(nums));
    }

}
