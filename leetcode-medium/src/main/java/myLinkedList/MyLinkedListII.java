package myLinkedList;

/**
 * @ClassName: MyLinkedListII 双向链表
 * @Description: leetCode-707: 设计链表
 * @Author: jiaoxian
 * @Date: 2022/9/23 14:01
 **/
public class MyLinkedListII {

    // 链表大小
    int size;
    // 头节点
    ListNodeII head;
    // 尾节点
    ListNodeII tail;

    public MyLinkedListII() {
        size = 0;
        head = new ListNodeII(0);
        tail = new ListNodeII(0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * @Author jiaoxian
     * @Description get 根据指定下标获取节点数据域的数据
     * @Date 2022/9/23 14:08
     * @param index:
     * @return int
     **/
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNodeII curr;
        // 如果 index 位于链表的前半部分, 则从前向后遍历链表
        if (index + 1 < size - index) {
            curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            // 如果 index 位于链表的后半部分, 则从后向前遍历链表
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    /**
     * @Author jiaoxian
     * @Description addAtHead 头插法
     * @Date 2022/9/23 14:13
     * @param val:
     * @return void
     **/
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtTail 尾插法
     * @Date 2022/9/23 14:13
     * @param val:
     * @return void
     **/
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtIndex 在指定位置插入节点
     * @Date 2022/9/23 14:13
     * @param index: 指定位置, 即下标, 从 0 开始编号
     * @param val:
     * @return void
     **/
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        // 待插入节点的前驱节点
        ListNodeII first;
        // 待插入节点的后驱节点
        ListNodeII second;
        // 如果待插入位置位于链表的前半部分, 则从前向后遍历, 找到待插入节点的前驱节点和后继节点
        if (index < size - index) {
            first = head;
            for (int i = 0; i < index; i++) {
                // 找到待插入节点的前驱节点
                first = first.next;
            }
            // 找到待插入节点的后继节点
            second = first.next;
        } else {
            // 如果待插入位置位于链表的后半部分, 则从后向前遍历, 找到待插入节点的前驱节点和后继节点
            second = tail;
            for (int i = 0; i < size - index; i++) {
                // 找到待插入节点的后继节点
                second = second.prev;
            }
            // 找到待插入节点的前驱节点
            first = second.prev;
        }
        size++;
        // 待插入节点
        ListNodeII toAdd = new ListNodeII(val);
        // 待插入节点的前驱节点指向待插入节点的前驱节点
        toAdd.prev = first;
        // 待插入节点的后继节点指向待插入节点的后继节点
        toAdd.next = second;
        // 待插入节点的后继节点指向待插入节点
        first.next = toAdd;
        // 待插入节点的前驱节点指向待插入节点
        second.prev = toAdd;
    }

    /**
     * @Author jiaoxian
     * @Description deleteAtIndex 删除指定位置的节点
     * @Date 2022/9/23 14:24
     * @param index: 指定位置, 即下标, 从 0 开始编号
     * @return void
     **/
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        // 待删除位置的前驱节点
        ListNodeII first;
        // 待删除位置的后继节点
        ListNodeII second;
        if (index < size - index) {
            // 如果待删除的位置位于链表的前半部分, 则从前向后遍历, 找到待删除位置的前驱节点和后继节点
            first = head;
            for (int i = 0; i < index; i++) {
                // 待删除位置的前驱节点
                first = first.next;
            }
            // 将待删除位置的后继节点指向待删除位置的前驱节点的后继节点的后继节点
            // 待删除位置的前驱节点的后继节点就是待删除的节点
            second = first.next.next;
        } else {
            second = tail;
            // 从后往前遍历, 要找的是待删除位置的后继节点, 所以注意 i 的循环终止的条件
            for (int i = 0; i < size - index - 1; i++) {
                // 待删除位置的后继节点
                second = second.prev;
            }
            // 将待删除位置的前驱节点指向待删除位置的后继节点的前驱节点的前驱节点
            // 待删除位置的后继节点的前驱节点就是待删除的节点
            first = second.prev.prev;
        }
        size--;
        // 待删除位置的前驱节点的后继节点指向待删除位置的后继节点
        first.next = second;
        // 待删除位置的后继节点的前驱节点指向待删除位置的前驱节点
        second.prev = first;
    }

    /**
     * @Author jiaoxian
     * @Description display 链表打印
     * @Date 2022/9/23 14:40
     * @param head:
     * @return void
     **/
    public void display(MyLinkedListII head) {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(head.get(i));
            System.out.print(" -> ");
        }
        System.out.println(head.get(size - 1));
    }

    public static void main(String[] args) {
        MyLinkedListII myLinkedList = new MyLinkedListII();
        // 头插5, 5
        myLinkedList.addAtHead(5);
        // 头插4, 4 -> 5
        myLinkedList.addAtHead(4);
        // 头插3, 3 -> 4 -> 5
        myLinkedList.addAtHead(3);
        // 头插2，2 -> 3 -> 4 -> 5
        myLinkedList.addAtHead(2);
        // 头插1, 1 -> 2 -> 3 -> 4 -> 5
        myLinkedList.addAtHead(1);
        myLinkedList.display(myLinkedList);
        // 尾插10, 1 -> 2 -> 3 -> 4 -> 5 -> 10
        myLinkedList.addAtTail(10);
        myLinkedList.display(myLinkedList);
        // 在下标位 3 的位置插入9, 1 -> 2 -> 3 -> 9 -> 4 -> 5 -> 10
        myLinkedList.addAtIndex(3, 9);
        // 在下标位 5 的位置插入8, 1 -> 2 -> 3 -> 9 -> 4 -> 8 -> 5 -> 10
        myLinkedList.addAtIndex(5, 8);
        myLinkedList.display(myLinkedList);
        // 删除下标为3的节点, 1 -> 2 -> 3 -> 4 -> 8 -> 5 -> 10
        myLinkedList.deleteAtIndex(3);
        myLinkedList.display(myLinkedList);
    }
}

/*
    双向链表节点定义:
    每个节点要存储本身的值 val
    后继节点 next
    前驱节点 prev
 */
class ListNodeII {
    int val;
    ListNodeII next;
    ListNodeII prev;

    public ListNodeII(int val) {
        this.val = val;
    }
}
