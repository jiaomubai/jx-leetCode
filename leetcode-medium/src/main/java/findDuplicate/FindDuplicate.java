package findDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: FindDuplicate
 * @Description: leetCode-287: 寻找重复数
 * @Author: jiaoxian
 * @Date: 2022/10/8 8:57
 **/
public class FindDuplicate {

    // 借助 HashSet
    public int findDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return num;
            }
        }
        return 0;
    }

    // 交换数组中的元素, 使数字位于其正确的下标处
    // 因为数组的取值范围是 [1, n], 数组长度是 n + 1, 数组下标是 [0, n]
    // 如果没有重复的数字, 那么对于数字 n 来说, 它在数组中的下标就应该是 n - 1
    // 以此作为切入点, 将每个值都通过交换放在正确的位置上, 重复的值必然会因为下标冲突被找出来
    public int findDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int x = nums[i];
            int idx = x - 1;
            // 如果 x 位于正确的下标 x - 1 处
            if (nums[idx] == x) {
                // 重复值
                if (idx != i) {
                    return x;
                }
                i++;
            } else {
                // 如果 x 没有位于正确的下标 x - 1 处, 则交换
                swap(nums, idx, i);
            }
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4};
        System.out.println(new FindDuplicate().findDuplicate2(nums));
    }

}
