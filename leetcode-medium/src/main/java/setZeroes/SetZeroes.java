package setZeroes;

/**
 * @ClassName: SetZeroes
 * @Description: leetCode-������ 01.08: �����
 * @Author: jiaoxian
 * @Date: 2022/9/30 9:21
 **/
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // ��¼���� 0 ����
        int[] tempM = new int[m];
        // ��¼���� 0 ����
        int[] tempN = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    tempM[i] = 1;
                    tempN[j] = 1;
                }
            }
        }
        // ��������, ����ǰ�л�ǰ���г��ֹ� 0, �򽫵�ǰ�к͵�ǰ���� 0 ���
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tempM[i] == 1 || tempN[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        setZeroes.setZeroes(matrix);
    }

}
