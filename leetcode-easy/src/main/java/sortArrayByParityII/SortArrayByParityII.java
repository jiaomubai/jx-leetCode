package sortArrayByParityII;

/**
 * @ClassName: SortArrayByParityII
 * @Description: leetCode-922: 按奇偶排序数组II
 * @Author: jiaoxian
 * @Date: 2022/9/6 16:39
 **/
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        // i 控制循环变量, j 负责查找符合条件的元素进行交换
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // 如果 i 为偶数
                if (nums[i] % 2 == 0) {
                    // 如果 i 为偶数, 且当前位置的元素也为偶数, 则不进行处理
                    continue;
                } else {
                    // 如果 i 为偶数, 但当前位置的元素为奇数, 则从后往前遍历数组, 寻找偶数与之交换
                    // 注意 j -= 2 的意图: 此时 i 为偶数, 但是 nums[i] 为奇数, 就是要寻找奇数位上的偶数与其交换,
                    // 因为数组长度为偶数, 那么其最后一个下标就是奇数, j -= 2 就实现了只寻找奇数位上的偶数
                    for (int j = nums.length - 1; j > i; j -= 2) {
                        if (nums[j] % 2 == 0) {
                            // 如果下标 j 位置的元素为偶数, 则交换
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            } else {
                // 如果 i 为奇数
                if (nums[i] % 2 == 1) {
                    // 如果 i 为奇数, 且当前位置的元素也为奇数, 则不进行处理
                    continue;
                } else {
                    // 如果 i 为奇数, 但当前位置的元素为偶数, 则从后往前遍历数组, 寻找奇数与之交换
                    for (int j = nums.length - 2; j > i; j -= 2) {
                        if (nums[j] % 2 == 1) {
                            // 如果下标 j 位置的元素为奇数, 则交换
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] nums = {2, 4, 5, 7};
        nums = sortArrayByParityII.sortArrayByParityII(nums);
        for (int i : nums) {
            System.out.printf("%4d", i);
        }
        System.out.println();
    }

}
