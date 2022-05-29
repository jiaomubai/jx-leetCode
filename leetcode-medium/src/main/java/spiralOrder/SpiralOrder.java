package spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SpiralOrder
 * @Author: jiaoxian
 * @Date: 2022/5/20 10:50
 * @Description: leetCode-54: 螺旋矩阵
 */
public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        int line = matrix.length;
        int column = matrix[0].length;
        // 上边界
        int top = 0;
        // 下边界
        int bottom = line - 1;
        // 左边界
        int left = 0;
        // 右边界
        int right = column - 1;
        while (resultList.size() < line * column) {
            // 如果上边界 <= 下边界, 从左到右遍历
            if (top <= bottom) {
                fromLeftToRight(matrix, left, right, top, resultList);
                top++;
            }
            // 如果左边界 <= 右边界, 从上到下遍历
            if (left <= right) {
                fromTopToBottom(matrix, top, bottom, right, resultList);
                right--;
            }
            // 如果上边界 <= 下边界, 从右到左遍历Left
            if (top <= bottom) {
                fromRightToLeft(matrix, left, right, bottom, resultList);
                bottom--;
            }
            // 如果左边界 <= 右边界, 从下到上遍历
            if (left <= right) {
                fromBottomToTop(matrix, top, bottom, left, resultList);
                left++;
            }
        }
        return resultList;
    }

    private static void fromBottomToTop(int[][] matrix, int top, int bottom, int left, List<Integer> resultList) {
        for (int i = bottom; i >= top; i--) {
            resultList.add(matrix[i][left]);
        }
    }

    private static void fromRightToLeft(int[][] matrix, int left, int right, int bottom, List<Integer> resultList) {
        for (int i = right; i >= left; i--) {
            resultList.add(matrix[bottom][i]);
        }
    }

    private static void fromTopToBottom(int[][] matrix, int top, int bottom, int right, List<Integer> resultList) {
        for (int i = top; i <= bottom; i++) {
            resultList.add(matrix[i][right]);
        }
    }

    private static void fromLeftToRight(int[][] matrix, int left, int right, int top, List<Integer> resultList) {
        for (int i = left; i <= right; i++) {
            resultList.add(matrix[top][i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        List<Integer> resultList = new ArrayList<>();
        resultList = spiralOrder(matrix);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.printf("%4d", resultList.get(i));
        }
        System.out.println();
    }

}
