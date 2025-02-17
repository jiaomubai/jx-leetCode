package productExceptSelf;

/**
 * @ClassName: ProductExceptSelf
 * @Description: leetCode-238:除自身以外数组的乘积
 * @Author: jiaoxian
 * @Date: 2025-02-10 14:47:34
 * @Version: 1.0
 **/

public class ProductExceptSelf {

    // 先让 dp[] 反向遍历 nums[], 取得 nums[] 中当前下标之后的所有值的积
    // 然后正向遍历dp[], 使上一步得到的值与 nums[] 中当前下标之前的所有值相乘
    // 若 nums[] = {2, 4, 6, 8, 10}
    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[] = {0, 0, 0, 0, 1}
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // dp[] = {1920, 480, 80, 10, 1}
            dp[i] = dp[i + 1] * nums[i +1];
        }
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i] * dp1;
            dp1 = dp1 * nums[i];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(new ProductExceptSelf().productExceptSelf(nums));
    }

}
