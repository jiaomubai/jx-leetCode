package searchMatrix;

/**
 * @ClassName: SearchMatrix
 * @Description: leetCode-面试题10.09:排序矩阵查找
 * @Author: jiaoxian
 * @Date: 2025-02-11 19:23:25
 * @Version: 1.0
 **/

public class SearchMatrix {

    // 按行遍历, 从左下角开始
    // 如果比target大, 则向上找, 即i--
    // 如果比target小, 则向右找, 即j++
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
