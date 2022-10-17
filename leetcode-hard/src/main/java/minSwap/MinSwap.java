package minSwap;

/**
 * @ClassName: MinSwap
 * @Description: leetCode-801: ʹ���е�������С��������
 * @Author: jiaoxian
 * @Date: 2022/10/10 17:51
 **/
public class MinSwap {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                //��ǰ���ִ���ǰһ������
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    //��ǰ���ִ�����һ�������ǰһ������

                    //ǰһ������������������ν
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    //���� + 1
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                } else {
                    //��ǰ���ֲ�������һ�������ǰһ������

                    //��ǰ���ֲ���������һ��Ҳ���ܽ���
                    dp[i][0] = dp[i - 1][0];
                    //��ǰ���ֽ�������һ��Ҳ���뽻��
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            } else {
                //��ǰ���ֲ�����ǰһ������

                //���β����� ����һ�ν���
                dp[i][0] = dp[i - 1][1];
                //���ν��� ����һ�β�����
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        MinSwap minSwap = new MinSwap();
        int[] nums1 = new int[]{1,8};
        int[] nums2 = new int[]{7,6};
        System.out.println(minSwap.minSwap(nums1, nums2));
    }

}
