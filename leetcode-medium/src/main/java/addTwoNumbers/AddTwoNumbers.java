package addTwoNumbers;

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: AddTwoNumbers
 * @Description: leetCode-2: �������
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:22
 **/
public class AddTwoNumbers {

    // ����������������ͬ���ȵĽ��б��������һ������϶�����ǰ�油 0, ���� 987 + 23 = 987 + 023 = 1010
    // ÿһλ�����ͬʱ��Ҫ������һλ�Ľ�λ����, ����ǰλ���������ͬ����Ҫ���½�λֵ
    // �����������ȫ��������Ϻ󣬽�λֵΪ 1, ������������ǰ����ӽڵ� 1
    // С���ɣ������������⣬���ؽ��Ϊͷ���ʱ��ͨ����Ҫ�ȳ�ʼ��һ��Ԥ��ָ�� pre����ָ�����һ���ڵ�ָ��������ͷ��� header��
    // ʹ��Ԥ��ָ���Ŀ�����������ʼ��ʱ�޿��ýڵ�ֵ�����������������Ҫָ���ƶ��������ᵼ��ͷָ�붪ʧ���޷����ؽ����

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        // Ԥ��ָ��
        ListNode pre = new ListNode(0);
        // ��ǰָ��
        ListNode cur = pre;
        // ��λ
        int carry = 0;
        while(listNode1 != null || listNode2 != null) {
            int x = listNode1 == null ? 0 : listNode1.val;
            int y = listNode2 == null ? 0 : listNode2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }
        if (carry == 1) {
            // ���ǽ�λ���
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    // leetCode-��ָ Offer II 025: �����е��������
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<ListNode> dequeL1 = new ArrayDeque<>();
        Deque<ListNode> dequeL2 = new ArrayDeque<>();
        // l1 �� l2 �ֱ���ջ, ��ջ��Ԫ�ؾ���ԭ�����е�β�ڵ�
        while(l1 != null) {
            dequeL1.addLast(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            dequeL2.addLast(l2);
            l2 = l2.next;
        }

        ListNode temp = null;
        int carry = 0;
        while(!dequeL1.isEmpty() || !dequeL2.isEmpty() || carry != 0) {
            // ��������ջ, ����Ԫ�صļӷ������Լ�ջ�ĵ�ջ����
            int val1 = dequeL1.isEmpty() ? 0 : dequeL1.removeLast().val;
            int val2 = dequeL2.isEmpty() ? 0 : dequeL2.removeLast().val;
            ListNode node = new ListNode((val1 + val2 + carry) % 10);
            if (temp != null) {
                node.next = temp;
            }
            temp = node;
            carry = (val1 + val2 + carry) / 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode listNode1 = ListNode.createList(nums1);
        ListNode listNode2 = ListNode.createList(nums2);
        ListNode listNode3 = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        System.out.println("result1 = ");
        ListNode.displayList(listNode3);

        ListNode listNode11 = ListNode.createList(new int[]{7, 2, 4, 3});
        ListNode listNode21 = ListNode.createList(new int[]{5, 6, 4});
        ListNode listNode4 = addTwoNumbers.addTwoNumbers2(listNode11, listNode21);
        System.out.println("result2 = ");
        ListNode.displayList(listNode4)
        ;
    }

}
