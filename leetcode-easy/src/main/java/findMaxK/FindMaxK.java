package findMaxK;

import java.util.HashSet;

/**
 * @ClassName: FindMaxK
 * @Description: leetCode-6204: ���Ӧ����ͬʱ���ڵ����������
 * @Author: jiaoxian
 * @Date: 2022/10/17 15:52
 **/
public class FindMaxK {

    public int findMaxK(int[] nums) {
        int result = -1;
        // ʹ�ù� hashSet ��¼���ֹ�������
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            int absNum = Math.abs(num);
            // ���ֹ��෴�����Ҿ���ֵ���ڵ�ǰ���ֵ
            if (hashSet.contains(-num) && absNum > result) {
                // �������ֵ
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
