package missingNumber;

import java.util.Arrays;

/**
 * @ClassName: MissingNumber
 * @Author: jiaoxian
 * @Date: 2022/4/28 17:01
 * @Description: leetCode-268:丢失的数字、leetCode-面试题 17.04: 小时的数字
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int i = 0;
        Arrays.sort(nums);
        while (i < nums.length) {
            if (i != nums[i]) {
                return i;
            }
            i++;
        }
        return nums.length;
    }

    public static int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int total = nums.length * (nums.length + 1) / 2;
        return total - sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,4,2};
        System.out.println(missingNumber2(nums));

    }

}
