package frequencySort;

import util.ArraysUtil;
import java.util.*;

/**
 * @ClassName: FrequencySort
 * @Description: leetCode-1636: 按照频率将数组升序排序
 * @Author: jiaoxian
 * @Date: 2022/9/19 14:50
 **/
public class FrequencySort {

    public int[] frequencySort(int[] nums) {

        // hashMap 用来记录数组中每个数字出现的频率
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        // 复制原数组, 转换成 List, 方便比较排序
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int cnt1 = hashMap.get(a);
            int cnt2 = hashMap.get(b);
            return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
        });
        int length = nums.length;
        // 将 List 的值赋值给原数组
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 4};
        int[] result = frequencySort.frequencySort(nums);
        ArraysUtil.displayIntArray(result);
    }

}
