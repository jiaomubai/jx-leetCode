package hasCycle;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: HasCycle
 * @Description: leetCode-141: 环形链表
 * @Author: jiaoxian
 * @Date: 2022/9/21 16:37
 **/
public class HasCycle {

    // 方法 1: 借助 Set
    // 遍历链表, 将链表的每个节点存储进 Set 中, 当存储失败时, 证明这个节点已经被遍历过了, 也就证明当前链表是有环的
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while(head != null) {
            if (!listNodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 方法 2: 快慢指针
    // 使用快慢双指针来遍历链表, 慢指针每次向前移动一个节点, 快指针每次向前移动两个节点
    // 当快慢两个指针相遇, 即相等时, 则证明链表有环
    // 初始状态时, 慢指针为头指针, 快指针为头指针的下一个指针
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

}
