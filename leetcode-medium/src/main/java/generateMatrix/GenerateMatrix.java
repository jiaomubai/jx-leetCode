package generateMatrix;

/**
 * @ClassName: GenerateMatrix
 * @Description: leetCode-59.螺旋矩阵 II
 * @Author: jiaoxian
 * @Date: 2025-02-07 11:26:42
 * @Version: 1.0
 **/

public class GenerateMatrix {

    // 始终按照 从左到右、从上到下、从右到左、从下到上 的顺序去填充二维数组
    // 填充到边界之后, 根据实际情况更新边界, 比如 从左到右 填充到边界了, 则需要让上边界向内缩, 即 top++
    public int[][] generateMatrix(int n) {
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        int startNum = 1, endNum = n * n;
        int[][] result = new int[n][n];
        while (startNum <= endNum) {
            // 从左到右 填充
            for (int i = left; i <= right; i++) {
                result[top][i] = startNum;
                startNum++;
            }
            // 上边界向内缩
            top++;
            // 从上到下 填充
            for (int i = top; i <= bottom; i++) {
                result[i][right] = startNum;
                startNum++;
            }
            // 右边界向内缩
            right--;
            // 从右到左 填充
            for (int i = right; i >= left; i--) {
                result[bottom][i] = startNum;
                startNum++;
            }
            // 下边界向内缩
            bottom--;
            // 从下到上 填充
            for (int i = bottom; i >= top; i--) {
                result[i][left] = startNum;
                startNum++;
            }
            // 左边界向内缩
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateMatrix().generateMatrix(4));
    }

}
