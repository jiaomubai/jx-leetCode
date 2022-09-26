package myLinkedList;

/**
 * @ClassName: MyLinkedListII ˫������
 * @Description: leetCode-707: �������
 * @Author: jiaoxian
 * @Date: 2022/9/23 14:01
 **/
public class MyLinkedListII {

    // �����С
    int size;
    // ͷ�ڵ�
    ListNodeII head;
    // β�ڵ�
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
     * @Description get ����ָ���±��ȡ�ڵ������������
     * @Date 2022/9/23 14:08
     * @param index:
     * @return int
     **/
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNodeII curr;
        // ��� index λ�������ǰ�벿��, ���ǰ����������
        if (index + 1 < size - index) {
            curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else {
            // ��� index λ������ĺ�벿��, ��Ӻ���ǰ��������
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    /**
     * @Author jiaoxian
     * @Description addAtHead ͷ�巨
     * @Date 2022/9/23 14:13
     * @param val:
     * @return void
     **/
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtTail β�巨
     * @Date 2022/9/23 14:13
     * @param val:
     * @return void
     **/
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * @Author jiaoxian
     * @Description addAtIndex ��ָ��λ�ò���ڵ�
     * @Date 2022/9/23 14:13
     * @param index: ָ��λ��, ���±�, �� 0 ��ʼ���
     * @param val:
     * @return void
     **/
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        // ������ڵ��ǰ���ڵ�
        ListNodeII first;
        // ������ڵ�ĺ����ڵ�
        ListNodeII second;
        // ���������λ��λ�������ǰ�벿��, ���ǰ������, �ҵ�������ڵ��ǰ���ڵ�ͺ�̽ڵ�
        if (index < size - index) {
            first = head;
            for (int i = 0; i < index; i++) {
                // �ҵ�������ڵ��ǰ���ڵ�
                first = first.next;
            }
            // �ҵ�������ڵ�ĺ�̽ڵ�
            second = first.next;
        } else {
            // ���������λ��λ������ĺ�벿��, ��Ӻ���ǰ����, �ҵ�������ڵ��ǰ���ڵ�ͺ�̽ڵ�
            second = tail;
            for (int i = 0; i < size - index; i++) {
                // �ҵ�������ڵ�ĺ�̽ڵ�
                second = second.prev;
            }
            // �ҵ�������ڵ��ǰ���ڵ�
            first = second.prev;
        }
        size++;
        // ������ڵ�
        ListNodeII toAdd = new ListNodeII(val);
        // ������ڵ��ǰ���ڵ�ָ�������ڵ��ǰ���ڵ�
        toAdd.prev = first;
        // ������ڵ�ĺ�̽ڵ�ָ�������ڵ�ĺ�̽ڵ�
        toAdd.next = second;
        // ������ڵ�ĺ�̽ڵ�ָ�������ڵ�
        first.next = toAdd;
        // ������ڵ��ǰ���ڵ�ָ�������ڵ�
        second.prev = toAdd;
    }

    /**
     * @Author jiaoxian
     * @Description deleteAtIndex ɾ��ָ��λ�õĽڵ�
     * @Date 2022/9/23 14:24
     * @param index: ָ��λ��, ���±�, �� 0 ��ʼ���
     * @return void
     **/
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        // ��ɾ��λ�õ�ǰ���ڵ�
        ListNodeII first;
        // ��ɾ��λ�õĺ�̽ڵ�
        ListNodeII second;
        if (index < size - index) {
            // �����ɾ����λ��λ�������ǰ�벿��, ���ǰ������, �ҵ���ɾ��λ�õ�ǰ���ڵ�ͺ�̽ڵ�
            first = head;
            for (int i = 0; i < index; i++) {
                // ��ɾ��λ�õ�ǰ���ڵ�
                first = first.next;
            }
            // ����ɾ��λ�õĺ�̽ڵ�ָ���ɾ��λ�õ�ǰ���ڵ�ĺ�̽ڵ�ĺ�̽ڵ�
            // ��ɾ��λ�õ�ǰ���ڵ�ĺ�̽ڵ���Ǵ�ɾ���Ľڵ�
            second = first.next.next;
        } else {
            second = tail;
            // �Ӻ���ǰ����, Ҫ�ҵ��Ǵ�ɾ��λ�õĺ�̽ڵ�, ����ע�� i ��ѭ����ֹ������
            for (int i = 0; i < size - index - 1; i++) {
                // ��ɾ��λ�õĺ�̽ڵ�
                second = second.prev;
            }
            // ����ɾ��λ�õ�ǰ���ڵ�ָ���ɾ��λ�õĺ�̽ڵ��ǰ���ڵ��ǰ���ڵ�
            // ��ɾ��λ�õĺ�̽ڵ��ǰ���ڵ���Ǵ�ɾ���Ľڵ�
            first = second.prev.prev;
        }
        size--;
        // ��ɾ��λ�õ�ǰ���ڵ�ĺ�̽ڵ�ָ���ɾ��λ�õĺ�̽ڵ�
        first.next = second;
        // ��ɾ��λ�õĺ�̽ڵ��ǰ���ڵ�ָ���ɾ��λ�õ�ǰ���ڵ�
        second.prev = first;
    }

    /**
     * @Author jiaoxian
     * @Description display �����ӡ
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
        // ͷ��5, 5
        myLinkedList.addAtHead(5);
        // ͷ��4, 4 -> 5
        myLinkedList.addAtHead(4);
        // ͷ��3, 3 -> 4 -> 5
        myLinkedList.addAtHead(3);
        // ͷ��2��2 -> 3 -> 4 -> 5
        myLinkedList.addAtHead(2);
        // ͷ��1, 1 -> 2 -> 3 -> 4 -> 5
        myLinkedList.addAtHead(1);
        myLinkedList.display(myLinkedList);
        // β��10, 1 -> 2 -> 3 -> 4 -> 5 -> 10
        myLinkedList.addAtTail(10);
        myLinkedList.display(myLinkedList);
        // ���±�λ 3 ��λ�ò���9, 1 -> 2 -> 3 -> 9 -> 4 -> 5 -> 10
        myLinkedList.addAtIndex(3, 9);
        // ���±�λ 5 ��λ�ò���8, 1 -> 2 -> 3 -> 9 -> 4 -> 8 -> 5 -> 10
        myLinkedList.addAtIndex(5, 8);
        myLinkedList.display(myLinkedList);
        // ɾ���±�Ϊ3�Ľڵ�, 1 -> 2 -> 3 -> 4 -> 8 -> 5 -> 10
        myLinkedList.deleteAtIndex(3);
        myLinkedList.display(myLinkedList);
    }
}

/*
    ˫������ڵ㶨��:
    ÿ���ڵ�Ҫ�洢�����ֵ val
    ��̽ڵ� next
    ǰ���ڵ� prev
 */
class ListNodeII {
    int val;
    ListNodeII next;
    ListNodeII prev;

    public ListNodeII(int val) {
        this.val = val;
    }
}
