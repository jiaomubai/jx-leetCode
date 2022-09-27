package goodIndices;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GoodIndices
 * @Description: leetCode-6190: �ҵ����к��±�
 * @Author: jiaoxian
 * @Date: 2022/9/26 14:44
 **/
public class GoodIndices {

    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> resultList = new ArrayList<>();
        if ( n < 1 || k > n - k || k < 1) {
            return resultList;
        }

        for (int i = k; i < n - k; i++) {
            // �ж� k ֮ǰ�� k ��Ԫ���Ƿ�Ϊ�ǵ���
            boolean notIncreasing = isNotIncreasing(i, k, nums);
            if (notIncreasing) {
                // �ж� k ֮��� k ��Ԫ���Ƿ�Ϊ�ǵݼ�
                boolean notDiminishing = isNotDiminishing(i, k, nums);
                if (notDiminishing) {
                    resultList.add(i);
                }
            }
        }
        System.out.println(resultList.size());
        return resultList;
    }

    /**
     * @Author jiaoxian
     * @Description isNotIncreasing �ж�����Ԫ���Ƿ�Ϊ�ǵ���(���ж�����Ԫ���Ƿ�ݼ�)
     * @Date 2022/9/26 14:52
     * @param i
     * @param k
     * @param nums :
     * @return boolean
     **/
    private boolean isNotIncreasing(int i, int k, int[] nums) {
        if (k == 1) {
            return true;
        }
        for (int j = i - k; j < i - 1; j++) {
            if (nums[j + 1] > nums[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Author jiaoxian
     * @Description isNotIncreasing �ж�����Ԫ���Ƿ�Ϊ�ǵݼ�(���ж�����Ԫ���Ƿ����)
     * @Date 2022/9/26 14:52
     * @param i
     * @param k :
     * @param nums :
     * @return boolean
     **/
    private boolean isNotDiminishing(int i, int k, int[] nums) {
        if (k == 1) {
            return true;
        }
        for (int j = i + 1; j < i + k; j++) {
            if (nums[j] > nums[j + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GoodIndices goodIndices = new GoodIndices();
        int[] nums = new int[16666 * 10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 10;
        }
        goodIndices.goodIndices(nums, 16666);
    }

}
