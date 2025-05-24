package searchRange;

/**
 * @ClassName: SearchRange
 * @Description: leetCode-34: 在排序数组中查找元素的第一个和最后一个位置
 * @Author: jiaoxian
 * @Date: 2025-05-24 16:33:52
 * @Version: 1.0
 **/

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (result[0] == -1) {
                    result[0] = i;
                } else if (result[1] == -1) {
                    result[1] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        if (result[0] != -1 && result[1] == -1) {
            result[1] = result[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,9,9,9};
        int target = 9;
        int [] result = new SearchRange().searchRange(nums, target);
        System.out.println(result[0] + ", " + result[1]);
    }

}
