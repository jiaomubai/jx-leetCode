package findSubarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: FindSubarrays
 * @Description: leetCode-2395: 和相等的子数组
 * @Author: jiaoxian
 * @Date: 2022/9/19 17:40
 **/
public class FindSubarrays {

    // 根据题目要求, 必须得是两个连续的数字之和, 所以一次遍历即可
    public boolean findSubarrays(int[] nums) {
        // 使用 Set 来存储两个数的和, 如果 add 失败, 则证明是有和相等的子数组的
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!sumSet.add(nums[i] + nums[i - 1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindSubarrays findSubarrays = new FindSubarrays();
        System.out.println(findSubarrays.findSubarrays(new int[]{4,2,4}));
    }

}
