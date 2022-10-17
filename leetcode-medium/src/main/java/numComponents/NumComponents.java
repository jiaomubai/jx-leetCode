package numComponents;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: NumComponents
 * @Description: leetCode-817: 链表组件
 * @Author: jiaoxian
 * @Date: 2022/10/12 19:28
 **/
public class NumComponents {

    // 值存在于数组中的节点，是连续的几段
    // 需要计算组件的个数, 只需在链表中计算有多少组件的起始位置即可. 当一个节点满足以下条件之一时，它是组件的起始位置:
    // 节点的值在数组 nums 中存在且节点位于链表起始位置;
    // 节点的值在数组 nums 中存在且节点的前一个点不在数组 nums 中.
    // 遍历链表, 计算出满足条件的点的个数即可.
    // 因为需要多次判断值是否位于数组 nums 中, 可以考虑用一个哈希集合保存数组 nums 中的值, 以此降低时间复杂度.

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        boolean inSet = false;
        int result = 0;
        while (head != null) {
            // 如果当前节点的值存在于数组中
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
