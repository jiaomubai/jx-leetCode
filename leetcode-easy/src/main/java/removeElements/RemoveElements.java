package removeElements;

import removeDuplicates.RemoveDuplicates;
import util.ListNode;

/**
 * @ClassName: RemoveElements
 * @Description: leetCode-203: 移除链表元素
 * @Author: jiaoxian
 * @Date: 2022/9/27 16:13
 **/
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        // 1. 迭代: 记录当前节点为 currentNode, 遍历 head
        // 如果 currentNode.next.val == val, 则通过 currentNode.next = currentNode.next.next 完成删除 currentNode 的操作
        // 考虑到要删除的节点可能为头节点, 所以先添加一个头节点 dummyHead, 遍历时从 dummyHead.next 开始
//        if (head == null) {
//            return head;
//        }
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode currentNode = dummyHead;
//        while(currentNode.next != null) {
//            if (currentNode.next.val == val) {
//                currentNode.next = currentNode.next.next;
//            } else {
//                currentNode = currentNode.next;
//            }
//        }
//        return dummyHead.next;

        // 2. 递归:
        // 首先对除了头节点 head 以外的节点进行判断删除操作, 然后判断 head 的节点值是否等于给定的 val
        // 如果 head 的节点值等于 val, 则 head 需要被删除, 因此删除操作后的头节点为 head.next;
        // 如果 head 的节点值不等于 val, 则 head 保留, 因此删除操作后的头节点还是 head.
        // 递归的终止条件是 head 为空, 此时直接返回 head.
        // 当 head 不为空时, 递归地进行删除操作, 然后判断 head 的节点值是否等于 val, 并决定是否要删除 head
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        ListNode head = ListNode.createList(new int[]{1,2,3,2,4,2,5,6});
        ListNode.displayList(head);
        head = removeElements.removeElements(head, 2);
        ListNode.displayList(head);
    }

}
