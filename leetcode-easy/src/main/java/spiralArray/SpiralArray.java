package spiralArray;

/**
 * @ClassName: SpiralArray
 * @Description: leetCode-LCR 146:螺旋遍历二维数组
 * @Author: jiaoxian
 * @Date: 2025-02-07 16:41:23
 * @Version: 1.0
 **/

public class SpiralArray {

    public int[] spiralArray(int[][] array) {
        int row = array.length, col = 0;
        if (row > 0) {
            col = array[0].length;
        }
        int[] resultArray = new int[row * col];
        int count = 0;
        int x = 0;
        int top = 0, left = 0;
        int bottom = row - 1, right = col - 1;
        while (count < row * col) {
            // 从左到右 遍历
            if (top <= bottom) {
                for (int i = left; i <= right; i++) {
                    resultArray[x++] = array[top][i];
                    count++;
                }
                // 上边界向内缩
                top++;
            }
            // 从上到下 遍历
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    resultArray[x++] = array[i][right];
                    count++;
                }
                // 右边界向内缩
                right--;
            }
            // 从右到左 填充
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    resultArray[x++] = array[bottom][i];
                    count++;
                }
                // 下边界向内缩
                bottom--;
            }
            // 从下到上 填充
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    resultArray[x++] = array[i][left];
                    count++;
                }
                // 左边界向内缩
                left++;
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int array[][] = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        System.out.println(new SpiralArray().spiralArray(array));
    }

}
