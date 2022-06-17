package triangularSum;

/**
 * @ClassName: TriangularSum
 * @Author: jiaoxian
 * @Date: 2022/6/9 15:46
 * @Description: leetCode-2221: 数组的三角和
 */
public class TriangularSum {

    public int triangularSum(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        dp[0] = nums;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
            }
        }
        display(dp);
        return dp[nums.length - 1][0];
    }

    private void display(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new TriangularSum().triangularSum(nums));
    }

}
