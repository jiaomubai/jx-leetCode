//package deleteDuplicates;
//
//import util.ListNode;
//
///**
// * @ClassName: DeleteDuplicates
// * @Description: leetCode-83: 删除排序链表中的重复元素
// * @Author: jiaoxian
// * @Date: 2022/9/21 16:30
// **/
//public class DeleteDuplicates {
//
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        // 链表已经有序, 所以直接遍历链表
//        // 判断当前节点的数据域与下一个节点的数据域是否相等
//        // 如果相等, 则删除下一个节点
//        ListNode cur = head;
//        while (cur.next != null) {
//            if (cur.val == cur.next.val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//        return head;
//    }
//
//    public static void main(String[] args) {
//        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
//        ListNode listNode = ListNode.createList(new int[]{1,1,2,3,4,4});
//        ListNode.displayList(listNode);
//        listNode = deleteDuplicates.deleteDuplicates(listNode);
//        ListNode.displayList(listNode);
//    }
//
//}
