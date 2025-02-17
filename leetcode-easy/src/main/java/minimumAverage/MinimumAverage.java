package minimumAverage;

import java.util.Arrays;

/**
 * @ClassName: MinimumAverage
 * @Description: leetCode-3194:最小元素和最大元素的最小平均值
 * @Author: jiaoxian
 * @Date: 2025-01-10 15:50:25
 * @Version: 1.0
 **/

public class MinimumAverage {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int size = length / 2;
        double result = nums[length - 1];
        for (int i = 0; i < size; i++) {
            double temp = (nums[i] + nums[length - 1 - i]) / 2.0;
            if (temp < result) {
                result = temp;
            }
            nums[i] = 0;
            nums[length - 1 - i] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,3,4,15,13,4,1};
        System.out.println(new MinimumAverage().minimumAverage(nums));
    }

}
