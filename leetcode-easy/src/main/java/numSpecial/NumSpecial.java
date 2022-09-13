package numSpecial;

/**
 * @ClassName: NumSpecial
 * @Description: leetCode-1582: �����ƾ����е�����λ��
 * @Author: jiaoxian
 * @Date: 2022/9/5 16:38
 **/
public class NumSpecial {

    // ����λ�ö��壺��� mat[i][j] == 1 ���ҵ� i �к͵� j ���е���������Ԫ�ؾ�Ϊ 0���к��е��±�� �� 0 ��ʼ ������λ�� (i, j) ����Ϊ����λ�á�
    // Ҳ����˵, �����ǰԪ�����ڵ��к���ֻ�����Լ���ֵΪ1, ��ô����������λ��
    // Ҳ����˵, ֻ�е�ǰ�к͵�ǰ��ֻ��һ��Ԫ�ص�ֵΪ1ʱ, �Ż���ܳ�������λ��
    // ����, �ȷֱ����ÿ��Ԫ�غ�ÿ��Ԫ�صĺ�, Ȼ����ȥ����ԭ��ά����, ��ϵ�ǰ�еĺ��뵱ǰ�еĺ͵�����ȥ�����ж�
    public int numSpecial(int[][] mat) {
        int result = 0;
        if (null == mat || mat.length < 1) {
            return result;
        }
        // ��
        int lines = mat.length;
        // ��
        int columns = mat[0].length;
        // ÿ��Ԫ�صĺ�
        int[] linesValueSum = new int[lines];
        // ÿ��Ԫ�صĺ�
        int[] columnsValueSum = new int[columns];
        //  1.�ֱ��������ÿ�����ֵĺ��Լ�ÿ�����ֵĺ�, ����2��һά����
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                linesValueSum[i] += mat[i][j];
                columnsValueSum[j] += mat[i][j];
            }
        }
        System.out.println("ÿ��Ԫ��֮��Ϊ:");
        for (int i = 0; i < lines; i++) {
            System.out.printf("%4d", linesValueSum[i]);
        }
        System.out.println();
        System.out.println("ÿ��Ԫ��֮��Ϊ:");
        for (int i = 0; i < columns; i++) {
            System.out.printf("%4d", columnsValueSum[i]);
        }
        System.out.println();
        // 2.������ά����, �ж��Ƿ�Ϊ����λ��
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1 && linesValueSum[i] == 1 && columnsValueSum[j] == 1) {
                    // �����ǰԪ��Ϊ1�ҵ�ǰԪ�����ڵ��к��о�û��ֵΪ1��Ԫ��, ��ǰλ�õ�Ԫ�ؾ�Ϊ����λ�õ�Ԫ��
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0}, {0, 0}, {1, 0}};
        int result = new NumSpecial().numSpecial(mat);
        System.out.println("result = " + result);
    }

}
