package divideArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DivideArray
 * @Description: leetCode-2206: 将数组划分成相等数对
 * @Author: jiaoxian
 * @Date: 2022/9/21 10:09
 **/
public class DivideArray {

    // 如果能够划分为相等数对, 则一个元素的出现次数一定是偶数次
    // 所以, 遍历数组, 将数组元素出现的频率存储于 Map 中
    // 然后遍历 Map, 如果有出现奇数次的元素, 则 return false
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 遍历数组, 将数组元素作为 key 值存储 Map, Map 的 vlue 为数组元素出现的次数
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        // 遍历 Map 的 value, 如果有奇数, 则 return false
        for (Integer value : hashMap.values()) {
            if (value % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DivideArray divideArray = new DivideArray();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(divideArray.divideArray(nums));
    }

}
