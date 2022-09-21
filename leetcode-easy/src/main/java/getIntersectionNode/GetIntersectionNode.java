package getIntersectionNode;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: GetIntersectionNode
 * @Description: leetCode-160: 相交链表
 * @Author: jiaoxian
 * @Date: 2022/9/21 17:08
 **/
public class GetIntersectionNode {

    // 1. 借助 Set
    // 循环遍历 headA, 将每一个节点存储进 Set 中
    // 然后循环遍历 headB, 判断 headB 的节点是否存在于 Set 中,
    // 如果存在, 则返回 headB 当前节点, 如果遍历完也没有找到存在于 Set 中的节点, 则证明两个链表不相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 遍历 headA 存储进 Set
        Set<ListNode> hashSetA = new HashSet<>();
        while (headA != null) {
            hashSetA.add(headA);
            headA = headA.next;
        }
        // 遍历 headB, 看 Set 中是否包含该节点
        while(headB != null) {
            if (hashSetA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // 方法 2: 双指针
    // 分别使用指针 A 和 B 去遍历链表 headA 和 headB
    // 如果 A 不等于 null, 则向后移动, 如果 B 不等于 null, 则向后移动
    // 如果 A 等于 null, 即 A 已经遍历完了链表 headA, 则将 A 移动到链表 headB 的头节点继续遍历 headB
    // 如果 B 等于 null, 即 B 已经遍历完了链表 headB, 则将 B 移动到链表 headA 的头节点继续遍历 headA
    // 原因如下: 假设两个链表 headA 和 headB 相交,
    // 若链表 headA 的总长度为 m, 不相交部分的长度为 a, 相交部分的长度为 c, 则 a + c = m;
    // 若链表 headB 的总长度为 n, 不相交部分的长度为 b, 相交部分的长度为 c, 则 b + c = n.
    // 因为 m 不一定等于 n, 而且 a 不一定等于 c. 那么遍历时指针 A 和 B 就不一定同时到达相交节点
    // A 遍历完了 headA, 继续去遍历 headB, B 遍历完了 headB, 继续去遍历 headA
    // 当 A 和 B 相遇时, A 遍历的节点数为 m + b, B 遍历的节点数为 n + a, 此时 A 和 B 指向同一节点, 即
    // 若两个链表有相交, 则 A 和 B 会同时到达相交的节点
    // 若两个链表没有相交, 则 A 和 B 会同时为 null


    // 示例：
    // headA = 1 -> 2 -> 3 -> 4 -> 5 -> 9 -> 10     m = 7   a = 5   c = 2
    // headB = 7 -> 8 -> 9 -> 10                    n = 4   b = 2   c = 2
    // A 和 B 同时开始遍历, 当 B 遍历到 headB 的最后一点 10 时, A 此时位于 headA 的节点 4 处
    // 此时让 B 下一个去遍历 headA, 而 A 继续遍历 headA
    // 当 A 遍历到 headA 的最后一个节点 10 时, B 此时位于 headA 的节点 3 处
    // 此时让 A 下一个去遍历 headB, 而 B 继续遍历 headA
    // 则指针 A 和 B 的指向变化为:
    // A: 7 -> 8 -> 9
    // B: 4 -> 5 -> 9
    // 即 A 和 B 相遇于两个链表的相交节点处
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 指针 A 遍历 headA
        ListNode A = headA;
        // 指针 B 遍历 headB
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }

}
