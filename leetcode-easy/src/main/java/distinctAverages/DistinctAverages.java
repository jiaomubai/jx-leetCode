package distinctAverages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: DistinctAverages
 * @Description: leetCode-2465:不同的平均值数目
 * @Author: jiaoxian
 * @Date: 2025-01-10 16:05:43
 * @Version: 1.0
 **/

public class DistinctAverages {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int size = length / 2;
        Set<Double> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add((nums[i] + nums[length - 1 - i]) / 2.0);
        }
        return set.size();
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 4, 0, 3, 5};
        System.out.println(new DistinctAverages().distinctAverages(nums));
    }

}
