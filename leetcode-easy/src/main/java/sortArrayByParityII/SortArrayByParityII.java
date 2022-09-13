package sortArrayByParityII;

/**
 * @ClassName: SortArrayByParityII
 * @Description: leetCode-922: ����ż��������II
 * @Author: jiaoxian
 * @Date: 2022/9/6 16:39
 **/
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        // i ����ѭ������, j ������ҷ���������Ԫ�ؽ��н���
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // ��� i Ϊż��
                if (nums[i] % 2 == 0) {
                    // ��� i Ϊż��, �ҵ�ǰλ�õ�Ԫ��ҲΪż��, �򲻽��д���
                    continue;
                } else {
                    // ��� i Ϊż��, ����ǰλ�õ�Ԫ��Ϊ����, ��Ӻ���ǰ��������, Ѱ��ż����֮����
                    // ע�� j -= 2 ����ͼ: ��ʱ i Ϊż��, ���� nums[i] Ϊ����, ����ҪѰ������λ�ϵ�ż�����佻��,
                    // ��Ϊ���鳤��Ϊż��, ��ô�����һ���±��������, j -= 2 ��ʵ����ֻѰ������λ�ϵ�ż��
                    for (int j = nums.length - 1; j > i; j -= 2) {
                        if (nums[j] % 2 == 0) {
                            // ����±� j λ�õ�Ԫ��Ϊż��, �򽻻�
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            } else {
                // ��� i Ϊ����
                if (nums[i] % 2 == 1) {
                    // ��� i Ϊ����, �ҵ�ǰλ�õ�Ԫ��ҲΪ����, �򲻽��д���
                    continue;
                } else {
                    // ��� i Ϊ����, ����ǰλ�õ�Ԫ��Ϊż��, ��Ӻ���ǰ��������, Ѱ��������֮����
                    for (int j = nums.length - 2; j > i; j -= 2) {
                        if (nums[j] % 2 == 1) {
                            // ����±� j λ�õ�Ԫ��Ϊ����, �򽻻�
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                        }
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] nums = {2, 4, 5, 7};
        nums = sortArrayByParityII.sortArrayByParityII(nums);
        for (int i : nums) {
            System.out.printf("%4d", i);
        }
        System.out.println();
    }

}
