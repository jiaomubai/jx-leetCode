package getKthMagicNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: GetKthMagicNumber
 * @Description: leetCode-������ 17.09: �� K ����
 * @Author: jiaoxian
 * @Date: 2022/9/28 9:44
 **/
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        // set ������Ԫ��ȥ��
        Set<Long> set = new HashSet<Long>();
        // ʹ�����ȶ���ʵ����С��, ���洢������������
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        // �� 1 ���
        heap.offer(1L);
        // ��¼���
        int result = 0;
        for (int i = 0; i < k; i++) {
            // �Ѷ�Ԫ�� curr Ϊ��ǰ������С����
            long curr = heap.poll();
            result = (int) curr;
            // �Ѷ�Ԫ�� curr ��������, �� curr * 3��curr * 5��k * 7 Ҳ������������, ��˽�����Ӳ���
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        System.out.println(getKthMagicNumber.getKthMagicNumber(5));
    }

}
