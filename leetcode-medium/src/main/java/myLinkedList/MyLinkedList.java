package myLinkedList;

/**
 * @ClassName: MyLinkedList 单链表
 * @Description: leetCode-707: 设计链表
 * @Author: jiaoxian
 * @Date: 2022/9/23 11:10
 **/
public class MyLinkedList {

    // 链表大小
    int size;
    // 头节点
    ListNode head;

    /**
     * @Author jiaoxian
     * @Description MyLinkedList 构造函数
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
     * @Description get 根据下标获取节点数据域的数据
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
     * @Description addAtHead 头插法
     * @Date 2022/9/23 11:13
     * @param val: 数据
     * @return void
     **/
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtTail 尾插法
     * @Date 2022/9/23 11:13
     * @param val:
     * @return void
     **/
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtIndex 在指定位置插入指定节点
     * @Date 2022/9/23 11:14
     * @param index: 指定位置, 即下标, 从 0 开始编号
     * @param val:
     * @return void
     **/
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        size++;
        // 先找到 index 的前驱节点
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        // 待插入节点
        ListNode toAdd = new ListNode(val);
        // 将待插入节点的后继节点指向前驱节点的后继节点
        toAdd.next = pred.next;
        // 前驱节点的后继节点指向待插入节点
        pred.next = toAdd;
    }

    /**
     * @Author jiaoxian
     * @Description deleteAtIndex 删除指定下标的节点
     * @Date 2022/9/23 11:14
     * @param index: 下标, 从 0 开始编号
     * @return void
     **/
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        // 找到 index 的前驱节点
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        // 将前驱节点的后继节点指向前驱节点的后继节点的后继节点
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
    定义链表节点类
    每个节点要存储本身的值 val
    后继节点 next
 */
class ListNode {
    // 数据域
    int val;
    // 指针域
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
