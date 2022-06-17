package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ThreeSum
 * @Author: jiaoxian
 * @Date: 2022/6/7 14:18
 * @Description:
 */
public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        resultList.add(list);
                    }
                }
            }
        }
        System.out.println(resultList);
        return resultList;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 因为数组已经排序了, 若此时 nums[i] > 0, 那么后面的数就全部是 > 0 的, 无需再进行计算
                return resultList;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重第一个数
                continue;
            }

            // 双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        // 去重第二个数
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        // 去重第三个数
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new ThreeSum().threeSum(nums);
    }

}
