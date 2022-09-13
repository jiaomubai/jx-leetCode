package util;

/**
 * @ClassName: MyListNode
 * @Description: ��������, ʹ�� int ���鹹��������ӡ����
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:05
 **/
public class MyListNode {

    // �ڵ�������
    public int val;

    // �ڵ�ָ����
    public MyListNode next;

    public MyListNode() {
    }

    public MyListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * @Author jiaoxian
     * @Description createList β�巨��������
     * @Date 2022/9/13 17:14
     * @param a: �������
     * @return util.MyListNode
     **/
    public static MyListNode createList(int a[]) {
        // ͷ�ڵ�
        MyListNode header = null;
        if (a.length < 1) {
            return header;
        }
        // β�ڵ�
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
     * @Description displayList ��ӡ����
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
