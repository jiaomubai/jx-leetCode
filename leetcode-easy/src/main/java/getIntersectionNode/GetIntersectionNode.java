package getIntersectionNode;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: GetIntersectionNode
 * @Description: leetCode-160: �ཻ����
 * @Author: jiaoxian
 * @Date: 2022/9/21 17:08
 **/
public class GetIntersectionNode {

    // 1. ���� Set
    // ѭ������ headA, ��ÿһ���ڵ�洢�� Set ��
    // Ȼ��ѭ������ headB, �ж� headB �Ľڵ��Ƿ������ Set ��,
    // �������, �򷵻� headB ��ǰ�ڵ�, ���������Ҳû���ҵ������� Set �еĽڵ�, ��֤�����������ཻ
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // ���� headA �洢�� Set
        Set<ListNode> hashSetA = new HashSet<>();
        while (headA != null) {
            hashSetA.add(headA);
            headA = headA.next;
        }
        // ���� headB, �� Set ���Ƿ�����ýڵ�
        while(headB != null) {
            if (hashSetA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // ���� 2: ˫ָ��
    // �ֱ�ʹ��ָ�� A �� B ȥ�������� headA �� headB
    // ��� A ������ null, ������ƶ�, ��� B ������ null, ������ƶ�
    // ��� A ���� null, �� A �Ѿ������������� headA, �� A �ƶ������� headB ��ͷ�ڵ�������� headB
    // ��� B ���� null, �� B �Ѿ������������� headB, �� B �ƶ������� headA ��ͷ�ڵ�������� headA
    // ԭ������: ������������ headA �� headB �ཻ,
    // ������ headA ���ܳ���Ϊ m, ���ཻ���ֵĳ���Ϊ a, �ཻ���ֵĳ���Ϊ c, �� a + c = m;
    // ������ headB ���ܳ���Ϊ n, ���ཻ���ֵĳ���Ϊ b, �ཻ���ֵĳ���Ϊ c, �� b + c = n.
    // ��Ϊ m ��һ������ n, ���� a ��һ������ c. ��ô����ʱָ�� A �� B �Ͳ�һ��ͬʱ�����ཻ�ڵ�
    // A �������� headA, ����ȥ���� headB, B �������� headB, ����ȥ���� headA
    // �� A �� B ����ʱ, A �����Ľڵ���Ϊ m + b, B �����Ľڵ���Ϊ n + a, ��ʱ A �� B ָ��ͬһ�ڵ�, ��
    // �������������ཻ, �� A �� B ��ͬʱ�����ཻ�Ľڵ�
    // ����������û���ཻ, �� A �� B ��ͬʱΪ null


    // ʾ����
    // headA = 1 -> 2 -> 3 -> 4 -> 5 -> 9 -> 10     m = 7   a = 5   c = 2
    // headB = 7 -> 8 -> 9 -> 10                    n = 4   b = 2   c = 2
    // A �� B ͬʱ��ʼ����, �� B ������ headB �����һ�� 10 ʱ, A ��ʱλ�� headA �Ľڵ� 4 ��
    // ��ʱ�� B ��һ��ȥ���� headA, �� A �������� headA
    // �� A ������ headA �����һ���ڵ� 10 ʱ, B ��ʱλ�� headA �Ľڵ� 3 ��
    // ��ʱ�� A ��һ��ȥ���� headB, �� B �������� headA
    // ��ָ�� A �� B ��ָ��仯Ϊ:
    // A: 7 -> 8 -> 9
    // B: 4 -> 5 -> 9
    // �� A �� B ����������������ཻ�ڵ㴦
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // ָ�� A ���� headA
        ListNode A = headA;
        // ָ�� B ���� headB
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }

}
