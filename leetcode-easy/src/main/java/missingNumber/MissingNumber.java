package missingNumber;

import java.util.Arrays;

/**
 * @ClassName: MissingNumber
 * @Author: jiaoxian
 * @Date: 2022/4/28 17:01
 * @Description: leetCode-268:丢失的数字
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

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(missingNumber(nums));

    }

}
