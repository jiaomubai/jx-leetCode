package removeDuplicates;

/**
 * @ClassName: RemoveDuplicates
 * @Description: leetCode-80: 删除有序数组中的重复项
 * @Author: jiaoxian
 * @Date: 2022/9/27 11:32
 **/
public class RemoveDuplicates {

    // 快慢指针
    public int removeDuplicates(int[] nums) {
        // 最大重复次数两次
        int maxRepeat = 2;
        // 慢指针slow指向索引为1的位置
        int slow = maxRepeat - 1;
        for(int fast = maxRepeat; fast < nums.length; fast++) {
            // 保证在区间[slow - 1, fast]中元素最多不会超过2次
            if (nums[fast] != nums[slow - maxRepeat + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7, 8, 10};
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }

}
