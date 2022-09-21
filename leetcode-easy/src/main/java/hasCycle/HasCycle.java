package hasCycle;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: HasCycle
 * @Description: leetCode-141: ��������
 * @Author: jiaoxian
 * @Date: 2022/9/21 16:37
 **/
public class HasCycle {

    // ���� 1: ���� Set
    // ��������, �������ÿ���ڵ�洢�� Set ��, ���洢ʧ��ʱ, ֤������ڵ��Ѿ�����������, Ҳ��֤����ǰ�������л���
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while(head != null) {
            if (!listNodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // ���� 2: ����ָ��
    // ʹ�ÿ���˫ָ������������, ��ָ��ÿ����ǰ�ƶ�һ���ڵ�, ��ָ��ÿ����ǰ�ƶ������ڵ�
    // ����������ָ������, �����ʱ, ��֤�������л�
    // ��ʼ״̬ʱ, ��ָ��Ϊͷָ��, ��ָ��Ϊͷָ�����һ��ָ��
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

}
