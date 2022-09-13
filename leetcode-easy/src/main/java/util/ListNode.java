package util;

/**
 * @ClassName: ListNode
 * @Description: 链表工具类, 使用 int 数组构造链表、打印链表
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:05
 **/
public class ListNode {

    // 节点数据域
    public int val;

    // 节点指针域
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
     * @Description createList 尾插法构造链表
     * @Date 2022/9/13 17:14
     * @param a: 入参数组
     * @return util.ListNode
     **/
    public static ListNode createList(int a[]) {
        // 头节点
        ListNode header = null;
        if (a.length < 1) {
            return header;
        }
        // 尾节点
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
     * @Description displayList 打印链表
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
     * @Description getLength 计算链表长度
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
