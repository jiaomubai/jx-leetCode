package addTwoNumbers;

import util.ListNode;

/**
 * @ClassName: AddTwoNumbers
 * @Description: leetCode-2: 两数相加
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:22
 **/
public class AddTwoNumbers {

    // 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0, 比如 987 + 23 = 987 + 023 = 1010
    // 每一位计算的同时需要考虑上一位的进位问题, 而当前位计算结束后同样需要更新进位值
    // 如果两个链表全部遍历完毕后，进位值为 1, 则在新链表最前方添加节点 1
    // 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 header。
    // 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        // 预先指针
        ListNode pre = new ListNode(0);
        ListNode.displayList(pre);
        // 当前指针
        ListNode cur = pre;
        // 进位
        int carry = 0;
        while(listNode1 != null || listNode2 != null) {
            int x = listNode1 == null ? 0 : listNode1.val;
            int y = listNode2 == null ? 0 : listNode2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }
        if (carry == 1) {
            // 考虑进位情况
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode listNode1 = ListNode.createList(nums1);
        ListNode listNode2 = ListNode.createList(nums2);
        ListNode listNode3 = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        ListNode.displayList(listNode3);
    }

}
