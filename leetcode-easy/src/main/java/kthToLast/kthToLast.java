//package kthToLast;
//
//import util.ListNode;
//
///**
// * @ClassName: kthToLast
// * @Description: leetCode-������ 02.02: ���ص����� k ���ڵ�
// * @Author: jiaoxian
// * @Date: 2022/9/30 17:51
// **/
//public class kthToLast {
//
//    public int kthToLast(ListNode head, int k) {
//        // �������ָ��, ͬʱָ��ͷ�ڵ�
//        ListNode fast = head;
//        ListNode slow = head;
//        // ��������, �ÿ�ָ��ָ��� k ���ڵ�
//        for (int i = 0; i < k; i++) {
//            fast = fast.next;
//        }
//        // ����ָ��ÿ��ͬʱ����ƶ�һ���ڵ�, ����ָ�����������β��ʱ, ��ָ����ָ�Ľڵ���ǵ����� k ���ڵ�
//        while (fast != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow.val;
//    }
//
//}
