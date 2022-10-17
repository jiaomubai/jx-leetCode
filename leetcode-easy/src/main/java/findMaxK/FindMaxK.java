package findMaxK;

import java.util.HashSet;

/**
 * @ClassName: FindMaxK
 * @Description: leetCode-6204: 与对应负数同时存在的最大正整数
 * @Author: jiaoxian
 * @Date: 2022/10/17 15:52
 **/
public class FindMaxK {

    public int findMaxK(int[] nums) {
        int result = -1;
        // 使用哈 hashSet 记录出现过的数字
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            int absNum = Math.abs(num);
            // 出现过相反数，且绝对值大于当前最大值
            if (hashSet.contains(-num) && absNum > result) {
                // 更新最大值
                result = absNum;
            }
            hashSet.add(num);
        }
        return result;
    }

    public static void main(String[] args) {
        FindMaxK findMaxK = new FindMaxK();
        int[] nums = new int[]{7,-7,1,1,1,2};
        int result = findMaxK.findMaxK(nums);
        System.out.println(result);
    }

}
