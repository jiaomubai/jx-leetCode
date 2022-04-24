package mergeTwoLists;

/**
 * @ClassName: ListNode
 * @Author: jiaomubai
 * @Date: 2021/9/13 10:31
 * @Description: 合并两个有序链表, LeetCode 题库第21题
 */
public class ListNode {

    /**
     * 数据域
     */
    public int val;

    /**
     * 指向下一个节点的链接
     */
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    /**
     * 打印链表
     * @param listNode
     */
    public static void display(ListNode listNode) {
        if (listNode == null) {
            return;
        } else {
            while (listNode.next != null) {
                System.out.print(listNode.val + " -> ");
                listNode = listNode.next;
            }
        }
        System.out.println(listNode.val);
    }

    /**
     * 获取链表中元素的个数
     * @param listNode
     * @return
     */
    public static int getSize(ListNode listNode) {
        int count = 0;
        if (listNode == null) {
            return count;
        } else {
            while (listNode != null) {
                count++;
                listNode = listNode.next;
            }
            return count;
        }
    }

    /**
     * 数组转链表
     * @param arrays
     * @return
     */
    public static ListNode arrayToListNode(int[] arrays) {
        if (arrays.length == 0) {
            return null;
        }
        // 用数组的第一个元素生成一个新的链表
        ListNode head = new ListNode(arrays[0]);
        // 声明前一个节点等于头节点
        ListNode pre = head;
        for (int i = 1; i < arrays.length; i++) {
            // 要插入的节点对象
            ListNode node = new ListNode(arrays[i]);
            // 前一个节点的 next 指向当前节点
            pre.next = node;
            // 更新前一个节点
            pre = node;
        }
        return head;
    }

//    /**
//     * 合并两个有序链表--迭代
//     * @param listNode1
//     * @param listNode2
//     * @return
//     */
//    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
//        // 定义一个 val 为 0，next 为空的链表
//        ListNode listNode = new ListNode(0);
//        // 声明当前节点
//        ListNode cur = listNode;
//        while (listNode1 != null && listNode2 != null) {
//            if (listNode1.val < listNode2.val) {
//                // 当前节点的 next 域连接较小的一个节点
//                cur.next = listNode1;
//                // 更新当前节点
//                cur = listNode1;
//                // 更新 listNode1
//                listNode1 = listNode1.next;
//            } else {
//                cur.next = listNode2;
//                cur = cur.next;
//                listNode2 = listNode2.next;
//            }
//        }
//        // 任一为空，直接连接另一条链表
//        if (listNode1 == null) {
//            cur.next = listNode2;
//        } else {
//            cur.next = listNode1;
//        }
//        return listNode.next;
//    }
//
//    /**
//     * 合并两个有序链表--递归
//     * @param listNode1
//     * @param listNode2
//     * @return
//     */
//    public static ListNode mergeTwoLists2(ListNode listNode1, ListNode listNode2) {
//        if (listNode1 == null) {
//            return listNode2;
//        }
//        if (listNode2 == null) {
//            return listNode1;
//        }
//        if (listNode1.val < listNode2.val) {
//            listNode1.next = mergeTwoLists2(listNode1.next, listNode2);
//            return listNode1;
//        } else {
//            listNode2.next = mergeTwoLists2(listNode1, listNode2.next);
//            return listNode2;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arrays1 = {1, 2, 3};
//        ListNode listNode1 = arrayToListNode(arrays1);
//        System.out.println(getSize(listNode1));
//        display(listNode1);
//        int[] arrays2 = {2, 3, 4};
//        ListNode listNode2 = arrayToListNode(arrays2);
//        System.out.println(getSize(listNode2));
//        display(listNode2);
//        ListNode listNode3 = mergeTwoLists2(listNode1, listNode2);
//        display(listNode3);
//    }

}
