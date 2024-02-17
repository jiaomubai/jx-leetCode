//package getKthFromEnd;
//
//import util.ListNode;
//
///**
// * @ClassName: GetKthFromEnd
// * @Description: leetCode-面试题22: 链表中倒数第 k 个节点
// * @Author: jiaoxian
// * @Date: 2022/9/30 17:38
// **/
//public class GetKthFromEnd {
//
//    // 快慢指针
//    // 开始时快慢指针时指向头节点
//    public ListNode getKthFromEnd(ListNode head, int k) {
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
//        return slow;
//    }
//
//    public static void main(String[] args) {
//        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
//        ListNode head = ListNode.createList(new int[]{1,2,3,4,5,6});
//        ListNode.displayList(head);
//        ListNode result = getKthFromEnd.getKthFromEnd(head, 2);
//        ListNode.displayList(result);
//    }
//
//}
