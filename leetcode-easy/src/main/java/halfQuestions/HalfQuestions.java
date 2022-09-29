package halfQuestions;

import java.util.Arrays;

/**
 * @ClassName: HalfQuestions
 * @Description: leetCode-LCS 02: ���һ����Ŀ
 * @Author: jiaoxian
 * @Date: 2022/9/29 9:39
 **/
public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        // ʹ�ö�������� nums[] ȥ��¼֪ʶ���Ӧ����Ŀ����������, nums[1] ��ʾ�漰֪ʶ�� 1 ����Ŀ������
        int[] nums = new int[1001];
        for (int question : questions) {
            nums[question]++;
        }
        Arrays.sort(nums);
        // ������� nums[], Ѱ���漰֪ʶ�����Ŀ��������������������һ���֪ʶ������
        int sum = 0;
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i-- ) {
            sum += nums[i];
            result++;
            if (sum >= questions.length / 2) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HalfQuestions halfQuestions = new HalfQuestions();
        int[] questions = {1,5,1,3,4,5,2,5,3,3,8,6};
        System.out.println(halfQuestions.halfQuestions(questions));
    }

}
