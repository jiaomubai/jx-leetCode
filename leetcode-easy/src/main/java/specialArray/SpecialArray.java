package specialArray;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @ClassName: SpecialArray
 * @Description: leetCode-1608: 特殊数组的特征值
 * @Author: jiaoxian
 * @Date: 2022/9/13 10:10
 **/
@Slf4j
public class SpecialArray {

    // 将数组进行降序排序;
    // 根据特征值 x 的定义, x一定是在 [1,n] 范围内的一个整数, 其中 n 是数组 nums的长度, 因此，我们可以遍历 [1,n]  并判断某个整数 i 是否为特征值;
    // 若 i 为特征值，那么 nums 中恰好有 i 个元素大于等于 i.由于数组已经降序排序，说明 nums[i - 1] 必须大于等于 i, 并且 nums[i](如果存在)必须小于 i.
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= i && (i == nums.length || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArray specialArray = new SpecialArray();
        int[] nums = {3, 5};
        int result = specialArray.specialArray(nums);
        //log.info("result = {}", result);
    }
}
