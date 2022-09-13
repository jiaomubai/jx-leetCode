package util;

/**
 * @ClassName: MyListNode
 * @Description: 链表工具类, 使用 int 数组构造链表、打印链表
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:05
 **/
public class MyListNode {

    // 节点数据域
    public int val;

    // 节点指针域
    public MyListNode next;

    public MyListNode() {
    }

    public MyListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * @Author jiaoxian
     * @Description createList 尾插法构造链表
     * @Date 2022/9/13 17:14
     * @param a: 入参数组
     * @return util.MyListNode
     **/
    public static MyListNode createList(int a[]) {
        // 头节点
        MyListNode header = null;
        if (a.length < 1) {
            return header;
        }
        // 尾节点
        MyListNode rear = null;
        for (int i = 0; i < a.length; i++) {
            MyListNode s = new MyListNode(a[i]);
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
    public static void displayList(MyListNode header) {
        while (header.next != null) {
            System.out.print(header.val + " -> ");
            header = header.next;
        }
        System.out.println(header.val);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        MyListNode myListNode = MyListNode.createList(nums);
        displayList(myListNode);
    }

}
