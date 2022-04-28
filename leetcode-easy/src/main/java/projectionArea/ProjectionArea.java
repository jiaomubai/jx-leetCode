package projectionArea;

/**
 * @ClassName: ProjectionArea
 * @Author: jiaoxian
 * @Date: 2022/4/26 20:32
 * @Description:
 */
public class ProjectionArea {

    public static int projectionArea(int[][] grid) {
        // x:主视图 y:左视图 z:俯视图
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < grid.length; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 0) {
                    z++;
                }
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            y += a;
            x += b;
        }
        return x + y + z;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        int result = projectionArea(grid);
        System.out.println(result);
    }

}
