package mergeTwoLists;

import util.ListNode;

/**
 * @ClassName: mergeTwoLists
 * @Author: jiaoxian
 * @Date: 2021/9/23 14:46
 * @Description: leetCode-21: 合并两个有序链表
 */
public class mergeTwoLists {

    /**
     * 合并两个有序链表--迭代
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        // 定义一个 val 为 0，next 为空的链表
        ListNode listNode = new ListNode(0);
        // 声明当前节点
        ListNode cur = listNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                // 当前节点的 next 域连接较小的一个节点
                cur.next = listNode1;
                // 更新当前节点
                cur = listNode1;
                // 更新 listNode1
                listNode1 = listNode1.next;
            } else {
                cur.next = listNode2;
                cur = cur.next;
                listNode2 = listNode2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (listNode1 == null) {
            cur.next = listNode2;
        } else {
            cur.next = listNode1;
        }
        return listNode.next;
    }

    /**
     * 合并两个有序链表--递归
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        if (listNode1.val < listNode2.val) {
            listNode1.next = mergeTwoLists2(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoLists2(listNode1, listNode2.next);
            return listNode2;
        }
    }

    public static void main(String[] args) {
        int[] arrays1 = {1, 2, 3};
        ListNode listNode1 = ListNode.createList(arrays1);
        ListNode.displayList(listNode1);
        int[] arrays2 = {2, 3, 4};
        ListNode listNode2 = ListNode.createList(arrays2);
        ListNode.displayList(listNode2);
        ListNode listNode3 = mergeTwoLists(listNode1, listNode2);
        ListNode.displayList(listNode3);
    }

}
