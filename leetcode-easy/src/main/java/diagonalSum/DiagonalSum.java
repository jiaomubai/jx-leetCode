package diagonalSum;

/**
 * @ClassName: DiagonalSum
 * @Description: leetCode-1572. 矩阵对角线元素的和
 * @Author: jiaoxian
 * @Date: 2025-02-10 10:25:18
 * @Version: 1.0
 **/

public class DiagonalSum {

    // 若为奇数行矩阵, 则最中间的数字只加一次
    public int diagonalSum(int[][] mat) {
        int result = 0;
        int row = mat.length;
        for (int i = 0; i < mat.length; i++) {
            if (row % 2 == 1) {
                if (i == row / 2) {
                    result += mat[i][i];
                } else {
                    result += mat[i][i] + mat[i][row - i - 1];
                }
            } else {
                result += mat[i][i] + mat[i][row - i - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(new DiagonalSum().diagonalSum(mat));
    }

}
