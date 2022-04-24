package removeDuplicates;

/**
 * @ClassName: RemoveDuplicates
 * @Author: jiaomubai
 * @Date: 2021/9/13 10:39
 * @Description: 删除有序数组中的重复项, LeetCode 题库第26题
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i ++;
                nums[i] = nums[j];
                j ++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        int result = removeDuplicates(nums);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
