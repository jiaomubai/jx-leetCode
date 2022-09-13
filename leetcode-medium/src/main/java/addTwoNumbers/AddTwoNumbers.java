package addTwoNumbers;

import util.ListNode;

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
        ListNode.displayList(pre);
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

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode listNode1 = ListNode.createList(nums1);
        ListNode listNode2 = ListNode.createList(nums2);
        ListNode listNode3 = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        ListNode.displayList(listNode3);
    }

}
