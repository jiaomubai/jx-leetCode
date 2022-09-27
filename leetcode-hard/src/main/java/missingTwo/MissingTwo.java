package missingTwo;

import util.ArraysUtil;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * @ClassName: MissingTwo
 * @Description: leetCode-������ 17.19: ��ʧ����������
 * @Author: jiaoxian
 * @Date: 2022/9/26 15:48
 **/
public class MissingTwo {

    public int[] missingTwo(int[] nums) {
        // ��Ϊ������û���ظ�Ԫ��, ��ֻ��ʧ�� 2 ��Ԫ��.
        // ����ʵ������������ĳ���Ӧ���� nums.length + 2.
        // ���� nums = {1, 3, 2, 5, 8, 9, 10, 6}, ��ʧ������Ϊ 4 �� 7;
        // ��ô, 1. �������������Ԫ���ܺ�: (1 + 10) * 10 / 2, ����55.
        // 2. Ȼ���ٱ��� nums ����, �������Ԫ���ܺ͵��� 44, ��ô���ǾͿ���֪����ʧ��Ԫ�� x �� y ���ܺ�Ϊ: 55 - 44 = 11.
        // Ȼ����취ȷ�� x �� y ��ֵ. ����, ��ȡ x �� y �����ĵ�, ��: 11 / 2 = 5.
        // ��ô, ��Ȼ�����ĵ�, ����û���ظ�Ԫ��ֵ, ����, �϶���һ��С�� 5(ָ��Ϊ x), ��һ������ 5(ָ��Ϊ y).
        // ���ű��� nums ������С�ڵ��� 5 ��Ԫ��(����1��3��2��5), ��ȡ�ܺ͵��� 11.
        // �ٻ�ȡ��������С�ڵ��� 5 ��Ԫ��(����1��2��3��4��5)�ܺ�Ϊ 15, ��ô���ǵĲ�ֵ���� x ��, ���� x = 4, y = 7

//        int x;
//        int y;
//        int[] result = new int[2];
//        // 1. �������� [1, n] �ĳ���ӦΪ��ǰ����ĳ��� nums.length + 2
//        int newNumsLength = nums.length + 2;
//        // 2. ���������Ԫ���ܺ�Ϊ (1 + n) * (n / 2) (n = newNumsLength)
//        int newSum = (1 + newNumsLength) * newNumsLength / 2;
//        // 3. ��ǰ�����Ԫ���ܺ�
//        int sum = Arrays.stream(nums).sum();
//        // 4. x + y = newSum - sum
//        int total = newSum - sum;
//        // 5. ���� x + y �����ĵ�
//        int totalHalf = total / 2;
//        // 6. ����������С�ڵ������ĵ�Ԫ�صĺ�
//        int newTotalHalfSum = (1 + totalHalf) * totalHalf / 2;
//        // 7. ��ǰ������С�ڵ������ĵ�Ԫ�صĺ�
//        int totalHalfSum = 0;
//        for (int num : nums) {
//            if (num <= totalHalf) {
//                totalHalfSum += num;
//            }
//        }
//        // 8. ���� x��y
//        x = newTotalHalfSum - totalHalfSum;
//        result[0] = x;
//        y = total - x;
//        result[1] = y;

        // 1. �������� [1, n] �ĳ���ӦΪ��ǰ����ĳ��� nums.length + 2
        int newNumsLength = nums.length + 2;
        // 2. ���������Ԫ���ܺ�Ϊ (1 + n) * (n / 2) (n = newNumsLength)
        int sum = (1 + newNumsLength) * newNumsLength / 2;
        // 3. ���� x + y
        for (int num : nums) {
            sum -= num;
        }
        // 4. ���� x + y �����ĵ�
        int totalHalf = sum / 2;
        // 5. ����������С�ڵ������ĵ�Ԫ�صĺ�
        int newTotalHalfSum = (1 + totalHalf) * totalHalf / 2;
        // 6. �õ� x ��ֵ
        for (int num : nums) {
            if (num <= totalHalf) {
                newTotalHalfSum -= num;
            }
        }
        return new int[]{newTotalHalfSum, sum - newTotalHalfSum};
    }

    public static void main(String[] args) {
        System.out.println(1 / 2);
        MissingTwo missingTwo = new MissingTwo();
        int[] result = missingTwo.missingTwo(new int[]{1});
        ArraysUtil.displayIntArray(result);
    }

}
