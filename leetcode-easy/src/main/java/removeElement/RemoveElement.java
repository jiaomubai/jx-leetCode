package removeElement;

/**
 * @ClassName: RemoveElement
 * @Author: jiaomubai
 * @Date: 2021/9/13 11:48
 * @Description: 移除元素, LeetCode 题库第27题
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                i--;
                // 此时数组的大小-1
                size--;
            }
        }
        return size;
    }

    public static int removeElement2(int[] nums, int val) {
        // 快指针
        int i = 0;
        // 慢指针
        int j = 0;
        for (j = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        int result = removeElement2(nums, 3);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
