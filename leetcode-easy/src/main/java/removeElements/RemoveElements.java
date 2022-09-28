package removeElements;

import removeDuplicates.RemoveDuplicates;
import util.ListNode;

/**
 * @ClassName: RemoveElements
 * @Description: leetCode-203: �Ƴ�����Ԫ��
 * @Author: jiaoxian
 * @Date: 2022/9/27 16:13
 **/
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        // 1. ����: ��¼��ǰ�ڵ�Ϊ currentNode, ���� head
        // ��� currentNode.next.val == val, ��ͨ�� currentNode.next = currentNode.next.next ���ɾ�� currentNode �Ĳ���
        // ���ǵ�Ҫɾ���Ľڵ����Ϊͷ�ڵ�, ���������һ��ͷ�ڵ� dummyHead, ����ʱ�� dummyHead.next ��ʼ
//        if (head == null) {
//            return head;
//        }
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode currentNode = dummyHead;
//        while(currentNode.next != null) {
//            if (currentNode.next.val == val) {
//                currentNode.next = currentNode.next.next;
//            } else {
//                currentNode = currentNode.next;
//            }
//        }
//        return dummyHead.next;

        // 2. �ݹ�:
        // ���ȶԳ���ͷ�ڵ� head ����Ľڵ�����ж�ɾ������, Ȼ���ж� head �Ľڵ�ֵ�Ƿ���ڸ����� val
        // ��� head �Ľڵ�ֵ���� val, �� head ��Ҫ��ɾ��, ���ɾ���������ͷ�ڵ�Ϊ head.next;
        // ��� head �Ľڵ�ֵ������ val, �� head ����, ���ɾ���������ͷ�ڵ㻹�� head.
        // �ݹ����ֹ������ head Ϊ��, ��ʱֱ�ӷ��� head.
        // �� head ��Ϊ��ʱ, �ݹ�ؽ���ɾ������, Ȼ���ж� head �Ľڵ�ֵ�Ƿ���� val, �������Ƿ�Ҫɾ�� head
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode head = ListNode.createList(new int[]{1,2,3,2,4,2,5,6});
        ListNode.displayList(head);
        head = removeElements.removeElements(head, 2);
        ListNode.displayList(head);
    }

}
