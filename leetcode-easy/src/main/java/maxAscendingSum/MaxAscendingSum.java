package maxAscendingSum;

/**
 * @ClassName: MaxAscendingSum
 * @Description: leetCode-1800: ��������������
 * @Author: jiaoxian
 * @Date: 2022/10/8 16:59
 **/
public class MaxAscendingSum {

    // ����
    // ʹ��������������¼��ǰ����������ĺ��Լ��������������ĺ�
    // ѭ������ nums[] ����, ������������ sum �� result

    public int maxAscendingSum(int[] nums) {
        // ��������������
        int result = 0;
        // ��ǰ�����������
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == nums.length - 1 || nums[i + 1] <= nums[i]) {
                // ������������
                result = Math.max(result, sum);
                sum = 0;
            }
        }
        return Math.max(result, sum);
    }

    public static void main(String[] args) {
        MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
        int[] nums = new int[]{1, 2, 3, 7, 5};
        System.out.println(maxAscendingSum.maxAscendingSum(nums));
    }

}
