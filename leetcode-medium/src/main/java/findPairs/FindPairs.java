package findPairs;

import java.util.Arrays;

/**
 * @ClassName: FindPairs
 * @Author: jiaoxian
 * @Date: 2022/6/16 09:09
 * @Description: leetCode-532: 数组中的 k-diff 数对
 */
public class FindPairs {

    public int findPairs(int[] nums, int k) {
        int count = 0;
        if (nums.length == 0) {
            return count;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1;
            System.out.println("i = " + i + ", j = " + j);
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (i < j) {
                if (nums[j] - nums[i] != k) {
                    j--;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        System.out.println(new FindPairs().findPairs(nums, 2));
    }

}
