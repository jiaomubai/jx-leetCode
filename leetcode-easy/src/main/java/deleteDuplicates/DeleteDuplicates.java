//package deleteDuplicates;
//
//import util.ListNode;
//
///**
// * @ClassName: DeleteDuplicates
// * @Description: leetCode-83: ɾ�����������е��ظ�Ԫ��
// * @Author: jiaoxian
// * @Date: 2022/9/21 16:30
// **/
//public class DeleteDuplicates {
//
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        // �����Ѿ�����, ����ֱ�ӱ�������
//        // �жϵ�ǰ�ڵ������������һ���ڵ���������Ƿ����
//        // ������, ��ɾ����һ���ڵ�
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
