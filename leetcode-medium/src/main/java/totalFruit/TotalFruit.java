package totalFruit;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TotalFruit
 * @Description: leetCode-904: ˮ������
 * @Author: jiaoxian
 * @Date: 2022/10/17 14:37
 **/
public class TotalFruit {

    public int totalFruit(int[] fruits) {
        // ��������,
        // left ָ���������, right ָ�������ұ�, ʹ�� hashMap ���洢 [left, right] �����ڵ����ݼ�����ֵĴ���
        // ���� [left, right] �ڵ�����ȫ������ hashMap ��, �����ʱ hashMap �еļ�ֵ���� 2, �򲻶��ƶ���ָ�� left, ֱ�� hashMap ��������Ϊֹ
        // ��Ҫע�����, ����ָ�� left �����ƶ��Ĺ�����, ��Ҫ�Ƴ� hashMap ����ָ��Ķ�Ӧ�ļ�ֵ

        int n = fruits.length;
        Map<Integer, Integer> hanshMap = new HashMap<Integer, Integer>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < n; right++) {
            hanshMap.put(fruits[right], hanshMap.getOrDefault(fruits[right], 0) + 1);
            while (hanshMap.size() > 2) {
                hanshMap.put(fruits[left], hanshMap.get(fruits[left]) - 1);
                if (hanshMap.get(fruits[left]) == 0) {
                    hanshMap.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        int[] fruits = new int[]{1,0};
        int result = totalFruit.totalFruit(fruits);
        System.out.println(result);
    }

}
