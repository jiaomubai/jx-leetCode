package missingTwo;

import util.ArraysUtil;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * @ClassName: MissingTwo
 * @Description: leetCode-面试题 17.19: 消失的两个数字
 * @Author: jiaoxian
 * @Date: 2022/9/26 15:48
 **/
public class MissingTwo {

    public int[] missingTwo(int[] nums) {
        // 因为数组中没有重复元素, 且只丢失了 2 个元素.
        // 所以实际上完整数组的长度应该是 nums.length + 2.
        // 假设 nums = {1, 3, 2, 5, 8, 9, 10, 6}, 丢失的数字为 4 和 7;
        // 那么, 1. 计算完整数组的元素总和: (1 + 10) * 10 / 2, 即：55.
        // 2. 然后再遍历 nums 数组, 获得所有元素总和等于 44, 那么我们就可以知道丢失的元素 x 和 y 的总和为: 55 - 44 = 11.
        // 然后想办法确定 x 和 y 的值. 首先, 获取 x 和 y 的中心点, 即: 11 / 2 = 5.
        // 那么, 既然是中心点, 而且没有重复元素值, 所以, 肯定是一个小于 5(指定为 x), 另一个大于 5(指定为 y).
        // 接着遍历 nums 中所有小于等于 5 的元素(即：1、3、2、5), 获取总和等于 11.
        // 再获取完整数组小于等于 5 的元素(即：1、2、3、4、5)总和为 15, 那么他们的差值就是 x 了, 所以 x = 4, y = 7

//        int x;
//        int y;
//        int[] result = new int[2];
//        // 1. 完整数组 [1, n] 的长度应为当前数组的长度 nums.length + 2
//        int newNumsLength = nums.length + 2;
//        // 2. 完整数组的元素总和为 (1 + n) * (n / 2) (n = newNumsLength)
//        int newSum = (1 + newNumsLength) * newNumsLength / 2;
//        // 3. 当前数组的元素总和
//        int sum = Arrays.stream(nums).sum();
//        // 4. x + y = newSum - sum
//        int total = newSum - sum;
//        // 5. 计算 x + y 的中心点
//        int totalHalf = total / 2;
//        // 6. 完整数组中小于等于中心点元素的和
//        int newTotalHalfSum = (1 + totalHalf) * totalHalf / 2;
//        // 7. 当前数组中小于等于中心点元素的和
//        int totalHalfSum = 0;
//        for (int num : nums) {
//            if (num <= totalHalf) {
//                totalHalfSum += num;
//            }
//        }
//        // 8. 计算 x、y
//        x = newTotalHalfSum - totalHalfSum;
//        result[0] = x;
//        y = total - x;
//        result[1] = y;

        // 1. 完整数组 [1, n] 的长度应为当前数组的长度 nums.length + 2
        int newNumsLength = nums.length + 2;
        // 2. 完整数组的元素总和为 (1 + n) * (n / 2) (n = newNumsLength)
        int sum = (1 + newNumsLength) * newNumsLength / 2;
        // 3. 计算 x + y
        for (int num : nums) {
            sum -= num;
        }
        // 4. 计算 x + y 的中心点
        int totalHalf = sum / 2;
        // 5. 完整数组中小于等于中心点元素的和
        int newTotalHalfSum = (1 + totalHalf) * totalHalf / 2;
        // 6. 得到 x 的值
        for (int num : nums) {
            if (num <= totalHalf) {
                newTotalHalfSum -= num;
            }
        }
        return new int[]{newTotalHalfSum, sum - newTotalHalfSum};
    }

    public static void main(String[] args) {
        System.out.println(1 / 2);
        MissingTwo missingTwo = new MissingTwo();
        int[] result = missingTwo.missingTwo(new int[]{1});
        ArraysUtil.displayIntArray(result);
    }

}
