//package removeDuplicateNodes;
//
//import util.ListNode;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @ClassName: RemoveDuplicateNodes
// * @Description: leetCode-面试题 02.01-移除重复节点
// * @Author: jiaoxian
// * @Date: 2022/9/30 14:11
// **/
//public class RemoveDuplicateNodes {
//
////    public ListNode removeDuplicateNodes(ListNode head) {
////        // 借助哈希表
////        // 遍历 head, 将每一个节点的数据域都存储到 hashSet 中, 如果 add 成功, 则继续; 如果 add 失败, 则删除
////        if (head == null) {
////            return null;
////        }
////        Set<Integer> hashSet = new HashSet<>();
////        // 头节点不会被删除, 所以先将头节点的值 add 到 hashSet 中
////        hashSet.add(head.val);
////        // 循环变量
////        ListNode pos = head;
////        while (pos.next != null) {
////            // 当前节点
////            ListNode current = pos.next;
////            if (hashSet.add(current.val)) {
////                // 如果 add 成功, 则继续遍历下一个 pos
////                pos = pos.next;
////            } else {
////                // 如果 add 失败, pos 指向不变, 继续判断下一个 current
////                pos.next = current.next;
////            }
////        }
////        pos.next = null;
////        return head;
////    }
//
//    public ListNode removeDuplicateNodes(ListNode head) {
//        // 双重循环
//        if (head == null) {
//            return null;
//        }
//        ListNode pos = head;
//        while (pos != null) {
//            ListNode currentNode = pos;
//            while (currentNode.next != null) {
//                if (currentNode.next.val == pos.val) {
//                    // 可理解为 currentNode.next 即为要删除的节点
//                    // 将 currentNode 的后继节点指向 currentNode 的后继节点的后继节点, 即删除了 currentNode 的后继节点
//                    currentNode.next = currentNode.next.next;
//                } else {
//                    currentNode = currentNode.next;
//                }
//            }
//            pos = pos.next;
//        }
//        return head;
//    }
//
//    public static void main(String[] args) {
//        RemoveDuplicateNodes removeDuplicateNodes = new RemoveDuplicateNodes();
//        ListNode head = ListNode.createList(new int[]{1,2,3,2,1,3,4});
//        ListNode.displayList(head);
//        head = removeDuplicateNodes.removeDuplicateNodes(head);
//        ListNode.displayList(head);
//    }
//
//}
//
