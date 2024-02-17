//package kthToLast;
//
//import util.ListNode;
//
///**
// * @ClassName: kthToLast
// * @Description: leetCode-面试题 02.02: 返回倒数第 k 个节点
// * @Author: jiaoxian
// * @Date: 2022/9/30 17:51
// **/
//public class kthToLast {
//
//    public int kthToLast(ListNode head, int k) {
//        // 定义快慢指针, 同时指向头节点
//        ListNode fast = head;
//        ListNode slow = head;
//        // 遍历链表, 让快指针指向第 k 个节点
//        for (int i = 0; i < k; i++) {
//            fast = fast.next;
//        }
//        // 快慢指针每次同时向后移动一个节点, 当快指针遍历到链表尾部时, 慢指针所指的节点就是倒数第 k 个节点
//        while (fast != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow.val;
//    }
//
//}
