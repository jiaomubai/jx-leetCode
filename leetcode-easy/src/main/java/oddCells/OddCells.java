package oddCells;

/**
 * @ClassName: OddCells
 * @Description: leetCode-1252: 奇数值单元格的数目
 * @Author: jiaoxian
 * @Date: 2022/9/14 14:36
 **/
public class OddCells {

    // 创建一个 m * n 的矩阵
    // 遍历 indices, 对每一行的每个元素加 1, 对每一列的每个元素加 1, 填充矩阵
    // 遍历矩阵, 计算奇数值的数量
    public int oddCells(int m, int n, int[][] indices) {
        int[][] resultArray = new int[m][n];
        for (int[] indice : indices) {
            for (int j = 0; j < n; j++) {
                resultArray[indice[0]][j] += 1;
            }
        }
        for (int[] indice : indices) {
            for (int i = 0; i < m; i++) {
                resultArray[i][indice[1]] += 1;
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (resultArray[i][j] % 2 == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OddCells oddCells = new OddCells();
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells.oddCells(2, 3, indices));
    }

}
