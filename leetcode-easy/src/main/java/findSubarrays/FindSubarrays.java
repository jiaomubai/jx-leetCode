package findSubarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: FindSubarrays
 * @Description: leetCode-2395: ����ȵ�������
 * @Author: jiaoxian
 * @Date: 2022/9/19 17:40
 **/
public class FindSubarrays {

    // ������ĿҪ��, ���������������������֮��, ����һ�α�������
    public boolean findSubarrays(int[] nums) {
        // ʹ�� Set ���洢�������ĺ�, ��� add ʧ��, ��֤�����к���ȵ��������
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!sumSet.add(nums[i] + nums[i - 1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindSubarrays findSubarrays = new FindSubarrays();
        System.out.println(findSubarrays.findSubarrays(new int[]{4,2,4}));
    }

}
