package removeNthFromEnd;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: RemoveNthFromEnd
 * @Description: leetCode-19: ɾ������ĵ����� N ����㡢leetCode-��ָ Offer II 021: ɾ������ĵ����� n �����
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:46
 **/
public class RemoveNthFromEnd {

    // �ڶ�������в���ʱ��һ�ֳ��õļ��������һ���ƽڵ�(dummy node), Ҳ��ΪԤ�Ƚڵ㣬���� next ָ��ָ�������ͷ�ڵ�.����һ��, ���ǾͲ���Ҫ��ͷ�ڵ����������ж���.
    // �ڱ����У��������Ҫɾ���ڵ� y, ��ô���Ǿ���Ҫ֪���ڵ� y ��ǰ���ڵ� x, ���� x ��ָ����ָ�� y �ĺ�̽ڵ�, ������ͷ�ڵ㲻����ǰ���ڵ�, ���������Ҫ��ɾ��ͷ�ڵ�ʱ���������ж�.
    // ���������������ƽڵ�, ��ôͷ�ڵ��ǰ���ڵ�����ƽڵ㱾��, ��ʱ���Ǿ�ֻ��Ҫ����ͨ�õ��������.

    // 1. ͨ����������ĳ��ȵõ������� N ���ڵ�
    // �������ȴ�ͷ�ڵ㿪ʼ���������һ�α���, �õ�����ĳ��� length.
    // ��������ٴ�ͷ�ڵ㿪ʼ��������ж��α���, ���������� length - n + 1 ���ڵ�ʱ, ����������Ҫɾ���Ľڵ�.
    // Ϊ������Ŀ�е� n����һ��, �ڵ�ı�Ŵ� 1 ��ʼ, ͷ�ڵ�Ϊ��� 1 �Ľڵ�.
    // Ϊ�˷���ɾ������, ���ǿ��Դ��ƽڵ㿪ʼ���� length - n + 1 ���ڵ�.
    // ���������� length - n + 1 ���ڵ�ʱ, ������һ���ڵ����������Ҫɾ���Ľڵ�, ��������ֻ��Ҫ�޸�һ��ָ��, �������ɾ������.
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // �ƽڵ�(Ԥ�Ƚڵ�)
        ListNode dummy = new ListNode(0, head);
        ListNode.displayList(dummy);
        // ����������
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        // ��ǰָ����ָ����һ���ڵ��ָ����, ��ɾ������һ���ڵ�
        cur.next = cur.next.next;
        ListNode result = dummy.next;
        return result;
    }

    /**
     * @Author jiaoxian
     * @Description getLength ����������
     * @Date 2022/9/13 17:56
     * @param head:
     * @return int
     **/
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    // 2. ����ջ��ʵ��
    // �ڱ��������ͬʱ�����нڵ�������ջ.
    // ����ջ�Ƚ������ԭ��, ���ǵ���ջ�ĵ� n ���ڵ������Ҫɾ���Ľڵ�, ����Ŀǰջ���Ľڵ���Ǵ�ɾ���ڵ��ǰ���ڵ�.
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            // ����Ԫ����ջ
            stack.push(cur);
            cur = cur.next;
        }
        // ջԪ�����ε�ջ
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        // ��ǰ�ڵ��������Ϊջ��Ԫ��
        ListNode prev = stack.peek();
        // ��ǰ�ڵ��ָ����ָ��ǰ�ڵ����һ���ڵ��ָ����, ��ɾ������һ���ڵ�(pre.next)
        prev.next = prev.next.next;
        ListNode result = dummy.next;
        return result;
    }

    // 3. ����ָ��
    // ����������Ҫ�ҵ������� n ���ڵ�, ������ǿ���ʹ������ָ�� first �� second ͬʱ��������б���,���� first �� second ��ǰ n ���ڵ�.
    // �� first ָ������������ĩβʱ, second ��ǡ�ô��ڵ����� n ���ڵ�.
    // ��ʼʱ, first �� second  ��ָ��ͷ�ڵ�. ��������ʹ�� first ��������б���, �����Ĵ���Ϊ n.
    // ��ʱ, first �� second ֮������ n - 1 ���ڵ�, �� first �� second ��ǰ�� n ���ڵ�.
    // ����֮��, ͬʱʹ�� first �� second ��������б���. �� first �����������ĩβ(�� first Ϊ��ָ��)ʱ, second ǡ��ָ������ n ���ڵ�.
    // ��������ܹ��õ����ǵ����� n ���ڵ��ǰ���ڵ�����ǵ����� n ���ڵ�Ļ�, ɾ����������ӷ���. ������ǿ��Կ����ڳ�ʼʱ�� second ָ���ƽڵ�, ����Ĳ������費��.
    // ����һ��, �� first �����������ĩβʱ, second ����һ���ڵ����������Ҫɾ���Ľڵ�.
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode result = dummy.next;
        return result;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode listNode = ListNode.createList(nums);
        ListNode.displayList(listNode);
        ListNode result = removeNthFromEnd.removeNthFromEnd3(listNode, n);
        ListNode.displayList(result);
    }

}
