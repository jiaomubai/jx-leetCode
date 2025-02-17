package spiralMatrixIII;

/**
 * @ClassName: SpiralMatrixIII
 * @Description: leetCode-885:螺旋矩阵 III
 * @Author: jiaoxian
 * @Date: 2025-02-07 15:16:01
 * @Version: 1.0
 **/

public class SpiralMatrixIII {

    // 遍历方向为 右、下、左、上
    // 遍历的位移为 1, 1, 2, 2, 3, 3......结合遍历方向即为 右1、下1、左2、上2
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int m = rows;
        int n = cols;
        int all = m * n;
        int[][] result = new int[all][2];
        int left = cStart;
        int right = cStart;
        int top = rStart;
        int bottom = rStart;
        int count = 0;
        while (count < all) {
            // 向右遍历
            for (int i = left; i <= right; i++) {
                if (i >= 0 && i < n && top >= 0 && top < m) {
                    result[count] = new int[]{top, i};
                    count++;
                }
            }
            // 右边界向外扩
            right++;
            // 向下遍历
            for (int i = top; i <= bottom; i++) {
                if (i >= 0 && i < m && right >= 0 && right < n) {
                    result[count] = new int[]{i, right};
                    count++;
                }
            }
            // 下边界向外扩
            bottom++;
            // 向左遍历
            for (int i = right; i >= left; i--) {
                if (i >= 0 && i < n && bottom >= 0 && bottom < m) {
                    result[count] = new int[]{bottom, i};
                    count++;
                }
            }
            // 左边界向外扩
            left--;
            // 向上遍历
            for (int i = bottom; i >= top; i--) {
                if (i >= 0 && i < m && left >= 0 && left < n) {
                    result[count] = new int[]{i, left};
                    count++;
                }
            }
            // 上边界向外扩
            top--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrixIII().spiralMatrixIII(5, 6, 1, 4));
    }

}
