package singleNumber;

import util.ArraysUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: SingleNumber
 * @Description: leetCode-260: 只出现一次的数字III
 * @Author: jiaoxian
 * @Date: 2022/9/27 9:23
 **/
public class SingleNumber {

    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                hashSet.remove(num);
            }
        }
        int i = 0;
        for (Integer value : hashSet) {
            result[i++] = value;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {-1,0};
        int[] result = singleNumber.singleNumber(nums);
        ArraysUtil.displayIntArray(result);
    }

}
