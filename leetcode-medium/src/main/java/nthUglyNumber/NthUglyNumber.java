package nthUglyNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: NthUglyNumber
 * @Description: leetCode-264: ����II��leetCode-��ָ Offer 49: ����
 * @Author: jiaoxian
 * @Date: 2022/9/28 10:05
 **/
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        // set ������Ԫ��ȥ��
        Set<Long> set = new HashSet<Long>();
        // ʹ�����ȶ���ʵ����С��, ���洢������������
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        // ����С�ĳ��� 1 ���
        heap.offer(1L);
        // ��¼���
        int result = 0;
        for (int i = 0; i < n; i++) {
            // �Ѷ�Ԫ�� curr Ϊ��ǰ������С����
            long curr = heap.poll();
            result = (int) curr;
            // �Ѷ�Ԫ�� curr ��������, �� curr * 2��curr * 3��k * 5 Ҳ������������, ��˽�����Ӳ���
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
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        System.out.println(nthUglyNumber.nthUglyNumber(1));
    }

}
