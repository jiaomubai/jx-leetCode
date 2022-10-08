package findDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: FindDuplicate
 * @Description: leetCode-287: Ѱ���ظ���
 * @Author: jiaoxian
 * @Date: 2022/10/8 8:57
 **/
public class FindDuplicate {

    // ���� HashSet
    public int findDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return num;
            }
        }
        return 0;
    }

    // ���������е�Ԫ��, ʹ����λ������ȷ���±괦
    // ��Ϊ�����ȡֵ��Χ�� [1, n], ���鳤���� n + 1, �����±��� [0, n]
    // ���û���ظ�������, ��ô�������� n ��˵, ���������е��±��Ӧ���� n - 1
    // �Դ���Ϊ�����, ��ÿ��ֵ��ͨ������������ȷ��λ����, �ظ���ֵ��Ȼ����Ϊ�±��ͻ���ҳ���
    public int findDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length;) {
            int x = nums[i];
            int idx = x - 1;
            // ��� x λ����ȷ���±� x - 1 ��
            if (nums[idx] == x) {
                // �ظ�ֵ
                if (idx != i) {
                    return x;
                }
                i++;
            } else {
                // ��� x û��λ����ȷ���±� x - 1 ��, �򽻻�
                swap(nums, idx, i);
            }
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4};
        System.out.println(new FindDuplicate().findDuplicate2(nums));
    }

}
