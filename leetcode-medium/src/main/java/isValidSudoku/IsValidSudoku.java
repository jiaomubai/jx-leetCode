package isValidSudoku;

/**
 * @ClassName: IsValidSudoku
 * @Description: leetCode-36: 有效的数独
 * @Author: jiaoxian
 * @Date: 2022/9/9 17:01
 **/
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 双循环: i 控制行, j 控制列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }
                if (!check(i, j, value, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @Author jiaoxian
     * @Description check 验证当前值是否有效
     * @Date 2022/9/9 17:05
     * @param row: 当前值所在的行
     * @param col: 当前值所在的列
     * @param val: 当前值
     * @param board: 整个数独
     * @return boolean
     **/
    private static boolean check(int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] == val) {
                System.out.println("同行有重复值: 当前行为: " + row + " 当前列为:" + i);
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (j == row) {
                continue;
            }
            if (board[j][col] == val) {
                System.out.println("同列有重复值: 当前行为: " + j + " 当前列为:" + col);
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] == val) {
                    System.out.println("同宫格有重复值: 当前行为: " + i + " 当前列为:" + j);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        IsValidSudoku isValidSudoku = new IsValidSudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '3', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(isValidSudoku.isValidSudoku(board));
    }

}
