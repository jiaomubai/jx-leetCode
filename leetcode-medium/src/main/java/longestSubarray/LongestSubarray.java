package longestSubarray;

/**
 * @ClassName: LongestSubarray
 * @Description: leetCode-6189: 按位与最大的最长子数组
 * @Author: jiaoxian
 * @Date: 2022/9/26 11:31
 **/
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        // 按位与最大的结果一定是数组中的最大元素
        // 如果数组元素为 {1, 3, 4, 5, 5, 2, 6}, 那么任意子数组执行按位与运算的结果最大的就是 5
        // 要求按位与最大的最长子数组的数量, 即求数组中最大元素连续出现的个数

        // 最大子数组的按位与结果
        int maxBitAndResult = nums[0];
        // 最大子数组的长度
        int maxLength = 0;
        // 当前最大子数组的长度
        int currentLenght = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maxBitAndResult) {
                ++currentLenght;
            } else if (nums[i] > maxBitAndResult) {
                // 如果当前元素大于最大子数组的按位与结果
                maxBitAndResult = nums[i];
                maxLength = 0;
                currentLenght = 1;
            } else {
                if (currentLenght > maxLength) {
                    maxLength = currentLenght;
                }
                currentLenght = 0;
            }
        }
        return maxLength > currentLenght ? maxLength : currentLenght;
    }

    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        System.out.println(longestSubarray.longestSubarray(new int[]{1, 2, 3, 4}));
    }

}
