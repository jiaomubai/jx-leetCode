package countDistinctIntegers;

import java.util.HashSet;

/**
 * @ClassName: CountDistinctIntegers
 * @Description: leetCode-6205: ��ת֮��ͬ��������Ŀ
 * @Author: jiaoxian
 * @Date: 2022/10/17 15:58
 **/
public class CountDistinctIntegers {

    public int countDistinctIntegers(int[] nums) {
        // ʹ�� hashSet ȥ�洢��ͬ������, ��󷵻� hashSet ����������
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
            int reverseNum = reverseNum(String.valueOf(num));
            hashSet.add(reverseNum);
        }
        return hashSet.size();
    }

    /**
     * @Author jiaoxian
     * @Description reverseNum ��ת����
     * @Date 2022/10/17 16:01
     * @param numStr:
     * @return int
     **/
    private int reverseNum(String numStr) {
        StringBuilder stringBuilder = new StringBuilder(numStr);
        String strNum = stringBuilder.reverse().toString();
        if (strNum.startsWith("0")) {
            strNum.substring(1);
        }
        return Integer.parseInt(strNum);
    }

    public static void main(String[] args) {
        CountDistinctIntegers countDistinctIntegers = new CountDistinctIntegers();
        int[] nums = new int[]{11,12,13,14,15,10};
        System.out.println(countDistinctIntegers.countDistinctIntegers(nums));
    }

}
