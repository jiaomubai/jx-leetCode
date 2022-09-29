package halfQuestions;

import java.util.Arrays;

/**
 * @ClassName: HalfQuestions
 * @Description: leetCode-LCS 02: 完成一半题目
 * @Author: jiaoxian
 * @Date: 2022/9/29 9:39
 **/
public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        // 使用额外的数组 nums[] 去记录知识点对应的题目数量并排序, nums[1] 表示涉及知识点 1 的题目的数量
        int[] nums = new int[1001];
        for (int question : questions) {
            nums[question]++;
        }
        Arrays.sort(nums);
        // 逆序遍历 nums[], 寻找涉及知识点的题目的数量大于问题总数的一半的知识点数量
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
