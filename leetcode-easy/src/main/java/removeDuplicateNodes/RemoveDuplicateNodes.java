//package removeDuplicateNodes;
//
//import util.ListNode;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @ClassName: RemoveDuplicateNodes
// * @Description: leetCode-������ 02.01-�Ƴ��ظ��ڵ�
// * @Author: jiaoxian
// * @Date: 2022/9/30 14:11
// **/
//public class RemoveDuplicateNodes {
//
////    public ListNode removeDuplicateNodes(ListNode head) {
////        // ������ϣ��
////        // ���� head, ��ÿһ���ڵ�������򶼴洢�� hashSet ��, ��� add �ɹ�, �����; ��� add ʧ��, ��ɾ��
////        if (head == null) {
////            return null;
////        }
////        Set<Integer> hashSet = new HashSet<>();
////        // ͷ�ڵ㲻�ᱻɾ��, �����Ƚ�ͷ�ڵ��ֵ add �� hashSet ��
////        hashSet.add(head.val);
////        // ѭ������
////        ListNode pos = head;
////        while (pos.next != null) {
////            // ��ǰ�ڵ�
////            ListNode current = pos.next;
////            if (hashSet.add(current.val)) {
////                // ��� add �ɹ�, �����������һ�� pos
////                pos = pos.next;
////            } else {
////                // ��� add ʧ��, pos ָ�򲻱�, �����ж���һ�� current
////                pos.next = current.next;
////            }
////        }
////        pos.next = null;
////        return head;
////    }
//
//    public ListNode removeDuplicateNodes(ListNode head) {
//        // ˫��ѭ��
//        if (head == null) {
//            return null;
//        }
//        ListNode pos = head;
//        while (pos != null) {
//            ListNode currentNode = pos;
//            while (currentNode.next != null) {
//                if (currentNode.next.val == pos.val) {
//                    // �����Ϊ currentNode.next ��ΪҪɾ���Ľڵ�
//                    // �� currentNode �ĺ�̽ڵ�ָ�� currentNode �ĺ�̽ڵ�ĺ�̽ڵ�, ��ɾ���� currentNode �ĺ�̽ڵ�
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
