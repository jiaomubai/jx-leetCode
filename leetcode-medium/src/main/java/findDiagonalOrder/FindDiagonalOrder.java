package findDiagonalOrder;

/**
 * @ClassName: FindDiagonalOrder
 * @Author: jiaoxian
 * @Date: 2022/6/14 09:06
 * @Description: leetCode-498: 对角线遍历
 */
public class FindDiagonalOrder {

    /**
     * 官方解答：
     * m * n 的二维矩阵, 总共有 m + n - 1 条对角线, 相邻的对角线的遍历方向不同
     * 设对角线从上到下的编号为 [0,m + n − 2]
     * 当 i 为偶数时, 遍历方向为从左下向右上遍历;
     * 当 i 为奇数时，遍历方向为从右上向左下遍历;
     *
     * 当第 i 条对角线为从左下向右上遍历时, 即 i 为偶数时, 每次行索引减 1, 列索引加 1, 直到矩阵的边缘为止;
     *   当 i < m 时, 此时对角线遍历的起点位置为 (i, 0);
     *   当 i ≥ m 时，此时对角线遍历的起点位置为 (m − 1, i − m + 1);
     *
     * 当第 i 条对角线为从右上向左下遍历时, 即 i 为奇数时, 每次行索引加 1, 列索引减 1, 直到矩阵的边缘为止;
     *   当 i < n 时, 此时对角线遍历的起点位置为 (0, i);
     *   当 i ≥ n 时，此时对角线遍历的起点位置为 (i − n + 1, n − 1);
     **/

    public int[] findDiagonalOrder(int[][] mat) {
        // 行
        int m = mat.length;
        // 列
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                // 第偶数条对角线
                int row = 0;
                int line = 0;
                if (i < m) {
                    row = i;
                }
                if (i >= m) {
                    row = m - 1;
                    line = i - m + 1;
                }
                while (row >= 0 && line < n) {
                    result[index] = mat[row][line];
                    row--;
                    line++;
                    index++;
                }
            } else {
                // 第奇数条对角线
                int row = 0;
                int line = 0;
                if (i < n) {
                    line = i;
                }
                if (i >= n) {
                    row = i - n + 1;
                    line = n - 1;
                }
                while (row < m && line >= 0) {
                    result[index] = mat[row][line];
                    row++;
                    line--;
                    index++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        int[] result = new FindDiagonalOrder().findDiagonalOrder(mat);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%2d", result[i]);
        }
        System.out.println();
    }

}
