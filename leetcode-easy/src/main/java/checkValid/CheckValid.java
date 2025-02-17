package checkValid;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: CheckValid
 * @Description: leetCode-2133:检查是否每一行每一列都包含全部整数
 * @Author: jiaoxian
 * @Date: 2025-02-10 10:49:08
 * @Version: 1.0
 **/

public class CheckValid {

    // 矩阵大小为n
    // 先按行、再按列进行遍历
    // 按行遍历时, 若该数字大于0且小于等于n, 则存储进 set 中, 否则直接返回 false
    // 每行遍历完成之后判断 set 的大小是不是等于n, 如果不是, 直接返回 false, 如果是, 则继续遍历下一行
    // 按列遍历时逻辑与按行遍历时一样
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        // 按行遍历
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (0 < matrix[i][j] && matrix[i][j] <= n) {
                    set.add(matrix[i][j]);
                } else {
                    return false;
                }
            }
            if (set.size() != n) {
                return false;
            }
        }
        // 按列遍历
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (0 < matrix[j][i] && matrix[j][i] <= n) {
                    set.add(matrix[j][i]);
                } else {
                    return false;
                }
            }
            if (set.size() != n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{2,1,4,3},{3,4,1,2},{4,3,2,1}};
        System.out.println(new CheckValid().checkValid(matrix));
    }

}
