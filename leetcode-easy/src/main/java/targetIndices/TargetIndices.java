package targetIndices;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TargetIndices
 * @Description: leetCode-2089: 找出数组排序后的目标下标
 * @Author: jiaoxian
 * @Date: 2025-05-24 16:13:48
 * @Version: 1.0
 **/

public class TargetIndices {

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> resultList = new ArrayList<>();
        int count1 = 0, count2 = 0;
        for (int num: nums) {
            if (num < target) {
                count1++;
            } else if (num == target) {
                count2++;
            }
        }
        for (int i = count1; i < count1 + count2; i++) {
            resultList.add(i);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5, 6, 2, 8, 9, 2, 0};
        int target = 2;
        System.out.println(new TargetIndices().targetIndices(nums, target));

    }

}
