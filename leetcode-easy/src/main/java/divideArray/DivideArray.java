package divideArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DivideArray
 * @Description: leetCode-2206: �����黮�ֳ��������
 * @Author: jiaoxian
 * @Date: 2022/9/21 10:09
 **/
public class DivideArray {

    // ����ܹ�����Ϊ�������, ��һ��Ԫ�صĳ��ִ���һ����ż����
    // ����, ��������, ������Ԫ�س��ֵ�Ƶ�ʴ洢�� Map ��
    // Ȼ����� Map, ����г��������ε�Ԫ��, �� return false
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        // ��������, ������Ԫ����Ϊ key ֵ�洢 Map, Map �� vlue Ϊ����Ԫ�س��ֵĴ���
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        // ���� Map �� value, ���������, �� return false
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
