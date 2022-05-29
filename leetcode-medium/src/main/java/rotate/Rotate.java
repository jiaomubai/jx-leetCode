package rotate;

/**
 * @ClassName: Rotate
 * @Author: jiaoxian
 * @Date: 2022/5/19 18:41
 * @Description: leetCode-48: 旋转图像
 */
public class Rotate {

    public static void rotate(int[][] matrix) {
        int line = matrix.length;
        // 1.沿对角线交换元素
        changeElementByDiagonal(matrix, line);
        display(matrix);
        // 2.沿垂直的对称轴将每一行元素交换
        for (int[] row : matrix) {
            changeElementByVertical(row);
        }
    }

    private static void changeElementByVertical(int[] row) {
        int i = 0;
        int j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    private static void changeElementByDiagonal(int[][] matrix, int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void display(int[][] matrix) {
        int line = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        display(matrix);
        rotate(matrix);
        display(matrix);
    }
}
