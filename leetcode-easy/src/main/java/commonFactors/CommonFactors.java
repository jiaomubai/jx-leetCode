package commonFactors;

/**
 * @ClassName: CommonFactors
 * @Description: leetCode-2427: �����ӵ���Ŀ
 * @Author: jiaoxian
 * @Date: 2022/10/9 14:56
 **/
public class CommonFactors {

    // ��ȷ�� b Ϊ  �������н�С��һ��
    // �� 1 ��ʼ����, �� b ����, һ���жϵ�ǰ���ܷ����� a �� b, �������, �����ӵ���Ŀ�� 1
    public int commonFactors(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int result = 0;
        for (int i = 1; i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonFactors commonFactors = new CommonFactors();
        System.out.println(commonFactors.commonFactors(12, 20));
    }

}
