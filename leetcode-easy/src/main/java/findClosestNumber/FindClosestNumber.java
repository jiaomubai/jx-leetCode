package findClosestNumber;

import java.util.Arrays;

/**
 * @ClassName: FindClosestNumber
 * @Description: leetCode-2239: 找到最接近 0 的数字
 * @Author: jiaoxian
 * @Date: 2025-01-20 17:45:05
 * @Version: 1.0
 **/

public class FindClosestNumber {

    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int numsSize = nums.length;
        int result = nums[numsSize - 1];
        for (int i = 0; i < numsSize; i++) {
//            if ((nums[i] - 0))
        }
        return 0;

    }

}
