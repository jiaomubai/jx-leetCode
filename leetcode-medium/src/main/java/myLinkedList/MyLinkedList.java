package myLinkedList;

/**
 * @ClassName: MyLinkedList ������
 * @Description: leetCode-707: �������
 * @Author: jiaoxian
 * @Date: 2022/9/23 11:10
 **/
public class MyLinkedList {

    // �����С
    int size;
    // ͷ�ڵ�
    ListNode head;

    /**
     * @Author jiaoxian
     * @Description MyLinkedList ���캯��
     * @Date 2022/9/23 11:15
     * @param :
     * @return
     **/
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * @Author jiaoxian
     * @Description get �����±��ȡ�ڵ������������
     * @Date 2022/9/23 11:12
     * @param index:
     * @return int
     **/
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * @Author jiaoxian
     * @Description addAtHead ͷ�巨
     * @Date 2022/9/23 11:13
     * @param val: ����
     * @return void
     **/
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtTail β�巨
     * @Date 2022/9/23 11:13
     * @param val:
     * @return void
     **/
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtIndex ��ָ��λ�ò���ָ���ڵ�
     * @Date 2022/9/23 11:14
     * @param index: ָ��λ��, ���±�, �� 0 ��ʼ���
     * @param val:
     * @return void
     **/
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        size++;
        // ���ҵ� index ��ǰ���ڵ�
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        // ������ڵ�
        ListNode toAdd = new ListNode(val);
        // ��������ڵ�ĺ�̽ڵ�ָ��ǰ���ڵ�ĺ�̽ڵ�
        toAdd.next = pred.next;
        // ǰ���ڵ�ĺ�̽ڵ�ָ�������ڵ�
        pred.next = toAdd;
    }

    /**
     * @Author jiaoxian
     * @Description deleteAtIndex ɾ��ָ���±�Ľڵ�
     * @Date 2022/9/23 11:14
     * @param index: �±�, �� 0 ��ʼ���
     * @return void
     **/
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        // �ҵ� index ��ǰ���ڵ�
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        // ��ǰ���ڵ�ĺ�̽ڵ�ָ��ǰ���ڵ�ĺ�̽ڵ�ĺ�̽ڵ�
        pred.next = pred.next.next;
    }

    public void display(MyLinkedList head) {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(head.get(i));
            System.out.print(" -> ");
        }
        System.out.println(head.get(size - 1));
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 9);
        myLinkedList.display(myLinkedList);

    }
}

/*
    ��������ڵ���
    ÿ���ڵ�Ҫ�洢�����ֵ val
    ��̽ڵ� next
 */
class ListNode {
    // ������
    int val;
    // ָ����
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
