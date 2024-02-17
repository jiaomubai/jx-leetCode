package arrayPairSum;

import java.util.Arrays;

/**
 * @author jiaoxian
 * @name arrayPairSum
 * @date 2023/6/21 16:21
 * @description leetCode-561: Êý×é²ð·Ö
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        int length = nums.length;
        if (length == 0 || length % 2 != 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            result += Math.min(a, b);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(new ArrayPairSum().arrayPairSum(nums));
    }

}
