package matrixReshape;

/**
 * @author jiaoxian
 * @name matrixReshape
 * @date 2023/6/21 17:34
 * @description leetCode-566: ÷ÿÀ‹æÿ’Û
 */
public class MatrixReshape {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int cross = mat[0].length;
        if (row * cross != r * c) {
            return mat;
        }
        int[] temp = new int[row * cross];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cross; j++) {
                temp[index++] = mat[i][j];
            }
        }
        int[][] result = new int[r][c];
        int indexNew = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = temp[indexNew++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        new MatrixReshape().matrixReshape(mat, 4, 1);
    }

}
