package longestSubarray;

/**
 * @ClassName: LongestSubarray
 * @Description: leetCode-6189: ��λ�������������
 * @Author: jiaoxian
 * @Date: 2022/9/26 11:31
 **/
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        // ��λ�����Ľ��һ���������е����Ԫ��
        // �������Ԫ��Ϊ {1, 3, 4, 5, 5, 2, 6}, ��ô����������ִ�а�λ������Ľ�����ľ��� 5
        // Ҫ��λ������������������, �������������Ԫ���������ֵĸ���

        // ���������İ�λ����
        int maxBitAndResult = nums[0];
        // ���������ĳ���
        int maxLength = 0;
        // ��ǰ���������ĳ���
        int currentLenght = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maxBitAndResult) {
                ++currentLenght;
            } else if (nums[i] > maxBitAndResult) {
                // �����ǰԪ�ش������������İ�λ����
                maxBitAndResult = nums[i];
                maxLength = 0;
                currentLenght = 1;
            } else {
                if (currentLenght > maxLength) {
                    maxLength = currentLenght;
                }
                currentLenght = 0;
            }
        }
        return maxLength > currentLenght ? maxLength : currentLenght;
    }

    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        System.out.println(longestSubarray.longestSubarray(new int[]{1, 2, 3, 4}));
    }

}
