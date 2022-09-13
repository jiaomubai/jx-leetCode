package numSpecial;

/**
 * @ClassName: NumSpecial
 * @Description: leetCode-1582: 二进制矩阵中的特殊位置
 * @Author: jiaoxian
 * @Date: 2022/9/5 16:38
 **/
public class NumSpecial {

    // 特殊位置定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
    // 也就是说, 如果当前元素所在的行和中只有它自己的值为1, 那么它就是特殊位置
    // 也就是说, 只有当前行和当前列只有一个元素的值为1时, 才会可能出现特殊位置
    // 所以, 先分别计算每行元素和每列元素的和, 然后再去遍历原二维数组, 结合当前行的和与当前列的和的数组去进行判断
    public int numSpecial(int[][] mat) {
        int result = 0;
        if (null == mat || mat.length < 1) {
            return result;
        }
        // 行
        int lines = mat.length;
        // 列
        int columns = mat[0].length;
        // 每行元素的和
        int[] linesValueSum = new int[lines];
        // 每列元素的和
        int[] columnsValueSum = new int[columns];
        //  1.分别计算数组每行数字的和以及每列数字的和, 生成2个一维数组
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                linesValueSum[i] += mat[i][j];
                columnsValueSum[j] += mat[i][j];
            }
        }
        System.out.println("每行元素之和为:");
        for (int i = 0; i < lines; i++) {
            System.out.printf("%4d", linesValueSum[i]);
        }
        System.out.println();
        System.out.println("每列元素之和为:");
        for (int i = 0; i < columns; i++) {
            System.out.printf("%4d", columnsValueSum[i]);
        }
        System.out.println();
        // 2.遍历二维数组, 判断是否为特殊位置
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (mat[i][j] == 1 && linesValueSum[i] == 1 && columnsValueSum[j] == 1) {
                    // 如果当前元素为1且当前元素所在的行和列均没有值为1的元素, 则当前位置的元素就为特殊位置的元素
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0}, {0, 0}, {1, 0}};
        int result = new NumSpecial().numSpecial(mat);
        System.out.println("result = " + result);
    }

}
