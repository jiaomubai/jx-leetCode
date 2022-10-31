package kthGrammar;

import util.ArraysUtil;

/**
 * @ClassName: KthGrammar
 * @Description: leetCode-779: �� K ���﷨����
 * @Author: jiaoxian
 * @Date: 2022/10/20 16:27
 **/
public class KthGrammar {

    public int kthGrammar(int n, int k) {

        // 0
        // 01
        // 0110
        // 01101001
        // ���Կ���, �� n ���ܹ��� 2 ^ (n - 1) ����, ���˵�һ����ÿ�е����ֵ���Ŀ����ż��, ͬʱ��Щ������ƽ����Ϊ������
        // ǰһ������� n - 1 �е���ȫ��ͬ; ��һ�����ǵ� n - 1 �е�ÿ������ȡ��
        // ���� k ����, ������Ҫ���� k �뵱ǰ������������һ��Ĺ�ϵ, ��� k С�ڵ��ڵ� n ������������һ��, �� k < n - 1 �е���Ŀ����, ��� n �е� k �����ּ�Ϊ�� n - 1 �еĵ� k ������;
        // ��� k С�ڵ� n ������������һ��, �� k > n - 1 �е���Ŀ����, �Ǿ�ȡ�� n - 1 �еĵ� (k - n) �����ֵ��෴��
        // ��: ���Ҫ��� 4 �еĵ� 6 ��Ԫ��: �ǵ� 6 ��Ԫ���� 0, ��������һ��(�� 3 ��)�� 2(��(6 - 4)) ��Ԫ���෴��Ԫ��. ���� k > n - 1 ���������������;
        // ��Ҫ��֪���� 4 �еĵ� 6 ��Ԫ����ʲô, ����Ҫ֪���� 3 �е� 2 ��Ԫ����ʲô. �� k = 2, n = 3 ʱ, �������� k < n - 1 ���������������, ����Ӧ������һ��(���� 2 ��)�ĵ� k ��Ԫ��.

        return dfs(n, k);
    }

    private int dfs(int n, int k) {
        // �߽�����
        if (n == 1) {
            return 0;
        }
        // ����һ�����ֵ�����(�� n == 3 ʱ, ��һ��(���� 2 ��)�� 2 ^ (3 - 2) = 2 ������)
        int len = (int) Math.pow(2, n - 2);
        if (k - len <= 0) {
            // ��� k С�ڵ��� len, ��� n �е� k �����־͵��� �� n - 1 �е� k ������
            return dfs(n - 1, k);
        } else {
            // ��� k ���� len, ��� n �е� k ������͵��ڵ� n - 1 �е� (k - len) �����ֵ��෴��
            return dfs(n - 1, k - len) == 0 ? 1 : 0;
        }

    }

    public static void main(String[] args) {
        KthGrammar kthGrammar = new KthGrammar();
        System.out.println(kthGrammar.kthGrammar(3,3));
    }

}
