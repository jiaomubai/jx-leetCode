package sortArrayByParity;

/**
 * @ClassName: SortArrayByParity
 * @Author: jiaoxian
 * @Date: 2022/4/28 14:51
 * @Description: leetCode-905：按奇偶排序数组
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 0) {
                // 偶数,不处理,直接向后移动
                i++;
                continue;
            }
            if (nums[j] % 2 == 1) {
                // 奇数,不处理,直接向前移动
                j--;
                continue;
            }
            if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 1, 3};
        int[] result = sortArrayByParity(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }

}
