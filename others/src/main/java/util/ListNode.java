package util;

/**
 * @ClassName: ListNode
 * @Description: ��������, ʹ�� int ���鹹��������ӡ����
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:05
 **/
public class ListNode {

    // �ڵ�������
    public int val;

    // �ڵ�ָ����
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode header) {
        val = x;
        next = header;
    }

    /**
     * @Author jiaoxian
     * @Description createList β�巨��������
     * @Date 2022/9/13 17:14
     * @param a: �������
     * @return util.ListNode
     **/
    public static ListNode createList(int a[]) {
        // ͷ�ڵ�
        ListNode header = null;
        if (a.length < 1) {
            return header;
        }
        // β�ڵ�
        ListNode rear = null;
        for (int i = 0; i < a.length; i++) {
            ListNode s = new ListNode(a[i]);
            if (header == null) {
                header = s;
                rear = s;
            } else {
                rear.next = s;
                rear = rear.next;
            }
        }
        rear.next = null;
        return header;
    }

    /**
     * @Author jiaoxian
     * @Description displayList ��ӡ����
     * @Date 2022/9/13 17:15
     * @param header:
     * @return void
     **/
    public static void displayList(ListNode header) {
        while (header.next != null) {
            System.out.print(header.val + " -> ");
            header = header.next;
        }
        System.out.println(header.val);
    }

    /**
     * @Author jiaoxian
     * @Description getLength ����������
     * @Date 2022/9/13 17:56
     * @param head:
     * @return int
     **/
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.createList(nums);
        displayList(listNode);
        System.out.println(getLength(listNode));
    }

}
