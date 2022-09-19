package mostFrequentEven;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MostFrequentEven
 * @Description: leetCode-2404: ������Ƶ����ż��Ԫ��
 * @Author: jiaoxian
 * @Date: 2022/9/14 15:25
 **/
public class MostFrequentEven {

    // ������
    // ����һ�� map ���洢������ÿ��ż��Ԫ�س��ֵĴ���, key Ϊż��Ԫ��, value Ϊ��ż��Ԫ�س��ֵĴ���
    // ���� map �� value, �ҵ����ֵ�������
    // ���� map �� key, �ҵ����ִ�������Ԫ��
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (tempMap.containsKey(nums[i])) {
                    int value = tempMap.get(nums[i]);
                    tempMap.put(nums[i], ++value);
                } else {
                    tempMap.put(nums[i], 1);
                }
            }
        }
        int frequen = 0;
        int frequenElement = 2147483647;
        // ���� map �� value, �ҵ��������Ĵ���
        for (Integer value : tempMap.values()) {
            if (value > frequen) {
                // �ҵ����Ĵ���
                frequen = Math.max(frequen, value);
            }
        }
        if (frequen == 0) {
            // ������Ĵ�������0, ��������ֵΪ -1
            frequenElement = -1;
        } else {
            // ���� map �� key, �ҵ���������������ֵ��С��Ԫ��
            for (Integer key : tempMap.keySet()) {
                if (tempMap.get(key) == frequen) {
                    frequenElement = Math.min(frequenElement, key);
                }
            }
        }
        return frequenElement;
    }

    public static void main(String[] args) {
        MostFrequentEven mostFrequentEven = new MostFrequentEven();
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        System.out.println(mostFrequentEven.mostFrequentEven(nums));
    }

}
