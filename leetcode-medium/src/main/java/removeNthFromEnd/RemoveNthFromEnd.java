package removeNthFromEnd;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: RemoveNthFromEnd
 * @Description: leetCode-19: 删除链表的倒数第 N 个结点、leetCode-剑指 Offer II 021: 删除链表的倒数第 n 个结点
 * @Author: jiaoxian
 * @Date: 2022/9/13 17:46
 **/
public class RemoveNthFromEnd {

    // 在对链表进行操作时，一种常用的技巧是添加一个哑节点(dummy node), 也称为预先节点，它的 next 指针指向链表的头节点.这样一来, 我们就不需要对头节点进行特殊的判断了.
    // 在本题中，如果我们要删除节点 y, 那么我们就需要知道节点 y 的前驱节点 x, 并将 x 的指针域指向 y 的后继节点, 但由于头节点不存在前驱节点, 因此我们需要在删除头节点时进行特殊判断.
    // 但如果我们添加了哑节点, 那么头节点的前驱节点就是哑节点本身, 此时我们就只需要考虑通用的情况即可.

    // 1. 通过计算链表的长度得到倒数第 N 个节点
    // 我们首先从头节点开始对链表进行一次遍历, 得到链表的长度 length.
    // 随后我们再从头节点开始对链表进行二次遍历, 当遍历到第 length - n + 1 个节点时, 就是我们需要删除的节点.
    // 为了与题目中的 n保持一致, 节点的编号从 1 开始, 头节点为编号 1 的节点.
    // 为了方便删除操作, 我们可以从哑节点开始遍历 length - n + 1 个节点.
    // 当遍历到第 length - n + 1 个节点时, 它的下一个节点就是我们需要删除的节点, 这样我们只需要修改一次指针, 就能完成删除操作.
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 哑节点(预先节点)
        ListNode dummy = new ListNode(0, head);
        ListNode.displayList(dummy);
        // 计算链表长度
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        // 当前指针域指向下一个节点的指针域, 即删除了下一个节点
        cur.next = cur.next.next;
        ListNode result = dummy.next;
        return result;
    }

    /**
     * @Author jiaoxian
     * @Description getLength 计算链表长度
     * @Date 2022/9/13 17:56
     * @param head:
     * @return int
     **/
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    // 2. 借助栈来实现
    // 在遍历链表的同时将所有节点依次入栈.
    // 根据栈先进后出的原则, 我们弹出栈的第 n 个节点就是需要删除的节点, 并且目前栈顶的节点就是待删除节点的前驱节点.
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            // 链表元素入栈
            stack.push(cur);
            cur = cur.next;
        }
        // 栈元素依次弹栈
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        // 当前节点的数据域即为栈顶元素
        ListNode prev = stack.peek();
        // 当前节点的指针域指向当前节点的下一个节点的指针域, 即删除了下一个节点(pre.next)
        prev.next = prev.next.next;
        ListNode result = dummy.next;
        return result;
    }

    // 3. 快慢指针
    // 由于我们需要找到倒数第 n 个节点, 因此我们可以使用两个指针 first 和 second 同时对链表进行遍历,并且 first 比 second 超前 n 个节点.
    // 当 first 指针遍历到链表的末尾时, second 就恰好处于倒数第 n 个节点.
    // 初始时, first 和 second  均指向头节点. 我们首先使用 first 对链表进行遍历, 遍历的次数为 n.
    // 此时, first 和 second 之间间隔了 n - 1 个节点, 即 first 比 second 超前了 n 个节点.
    // 在这之后, 同时使用 first 和 second 对链表进行遍历. 当 first 遍历到链表的末尾(即 first 为空指针)时, second 恰好指向倒数第 n 个节点.
    // 如果我们能够得到的是倒数第 n 个节点的前驱节点而不是倒数第 n 个节点的话, 删除操作会更加方便. 因此我们可以考虑在初始时将 second 指向哑节点, 其余的操作步骤不变.
    // 这样一来, 当 first 遍历到链表的末尾时, second 的下一个节点就是我们需要删除的节点.
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode result = dummy.next;
        return result;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode listNode = ListNode.createList(nums);
        ListNode.displayList(listNode);
        ListNode result = removeNthFromEnd.removeNthFromEnd3(listNode, n);
        ListNode.displayList(result);
    }

}
