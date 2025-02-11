package findNumbers;

/**
 * @ClassName: FindNumbers
 * @Description: leetCode-1295:统计位数为偶数的数字
 * @Author: jiaoxian
 * @Date: 2025-02-10 17:14:06
 * @Version: 1.0
 **/

public class FindNumbers {

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 100000) {
                result++;
            } else if (nums[i] >= 10000) {
                continue;
            } else if (nums[i] >= 1000) {
                result++;
            } else if (nums[i] >= 100) {
                continue;
            } else if (nums[i] >= 10) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,10,100,1000,10000,100000};
        System.out.println(new FindNumbers().findNumbers(nums));
    }

}
