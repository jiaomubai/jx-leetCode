package common;

/**
 * @ClassName: ArrayDisplayUtil
 * @Author: jiaoxian
 * @Date: 2022/5/2 15:45
 * @Description:
 */
public class ArrayDisplayUtil {

    public static void arrayDisplay(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + "->");
        }
        System.out.print(nums[nums.length - 1]);
        System.out.println();
    }

}
