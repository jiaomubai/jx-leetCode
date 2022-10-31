package searchInsert;

/**
 * @ClassName: SearchInsert
 * @Author: jiaomubai
 * @Date: 2021/9/14 15:35
 * @Description: LeetCode-35: 搜索插入位置
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        // 如果 target 大于所有元素，或者数组为空，直接返回数组大小
        return nums.length;
    }

    public static int searchInsert2(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        // 定义 target 在左闭右闭的区间里,[left, right]
        int right = size - 1;
        // 当 left == right 时,区间 [left, right] 依然有效
        while (left <= right) {
            // 防止溢出,等同于(left + right) / 2
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                // target 在左区间, 所以[left, middle - 1]
                right = middle - 1;
            } else if (nums[middle] < target) {
                // target 在右区间，所以[middle + 1, right]
                left = middle + 1;
            } else {
                // nums[middle] == target
                return middle;
            }
        }
        return right + 1;
    }

    public static int searchInsert3(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        // 定义 target 在左闭右闭的区间里,[left, right)
        int right = size;
        // 当 left == right 时，在[left, right)区间无效
        while (left < right) {
            // 防止溢出,等同于(left + right) / 2,也等同于 left + ((right - left) / 2)
            int middle = left + ((right - left) >> 1);
            // target 在左区间，在[left, middle)中
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                // target 在右区间，在 [middle+1, right)中
                left = middle + 1;
            } else {
                // nums[middle] == target
                return middle;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        int result = searchInsert3(nums, 4);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
