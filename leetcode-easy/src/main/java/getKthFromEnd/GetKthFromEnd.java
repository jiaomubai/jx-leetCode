//package getKthFromEnd;
//
//import util.ListNode;
//
///**
// * @ClassName: GetKthFromEnd
// * @Description: leetCode-������22: �����е����� k ���ڵ�
// * @Author: jiaoxian
// * @Date: 2022/9/30 17:38
// **/
//public class GetKthFromEnd {
//
//    // ����ָ��
//    // ��ʼʱ����ָ��ʱָ��ͷ�ڵ�
//    public ListNode getKthFromEnd(ListNode head, int k) {
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
