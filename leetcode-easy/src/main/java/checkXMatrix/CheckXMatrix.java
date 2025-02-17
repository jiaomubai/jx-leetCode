package checkXMatrix;

/**
 * @ClassName: CheckXMatrix
 * @Description: CheckXMatrix
 * @Author: jiaoxian
 * @Date: 2025-02-10 11:13:29
 * @Version: 1.0
 **/

public class CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        int row = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i + j == row - 1 || i == j) {
                    if (grid[i][i] == 0 || grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,1,0},{1,0,1}};
        System.out.println(new CheckXMatrix().checkXMatrix(grid));
    }

}
