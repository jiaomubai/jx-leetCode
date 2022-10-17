package numComponents;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: NumComponents
 * @Description: leetCode-817: �������
 * @Author: jiaoxian
 * @Date: 2022/10/12 19:28
 **/
public class NumComponents {

    // ֵ�����������еĽڵ㣬�������ļ���
    // ��Ҫ��������ĸ���, ֻ���������м����ж����������ʼλ�ü���. ��һ���ڵ�������������֮һʱ�������������ʼλ��:
    // �ڵ��ֵ������ nums �д����ҽڵ�λ��������ʼλ��;
    // �ڵ��ֵ������ nums �д����ҽڵ��ǰһ���㲻������ nums ��.
    // ��������, ��������������ĵ�ĸ�������.
    // ��Ϊ��Ҫ����ж�ֵ�Ƿ�λ������ nums ��, ���Կ�����һ����ϣ���ϱ������� nums �е�ֵ, �Դ˽���ʱ�临�Ӷ�.

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int result = 0;
        while (head != null) {
            // �����ǰ�ڵ��ֵ������������
            if (numsSet.contains(head.val)) {
                if (!inSet) {
                    inSet = true;
                    result++;
                }
            } else {
                inSet = false;
            }
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        NumComponents numComponents = new NumComponents();
        ListNode listNode = ListNode.createList(new int[]{0,1,2,3,4});
        int[] nums = new int[]{0,3,1,4};
        System.out.println(numComponents.numComponents(listNode, nums));
    }

}
