package findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindDisappearedNumbers
 * @Author: jiaoxian
 * @Date: 2022/4/29 18:36
 * @Description: leetCode-448: 找到所有数组中消失的数字
 * TODO
 */
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i] != i) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        List<Integer> result = findDisappearedNumbers(nums);
    }

}
