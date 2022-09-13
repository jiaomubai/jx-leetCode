package isValidSudoku;

/**
 * @ClassName: IsValidSudoku
 * @Description: leetCode-36: ��Ч������
 * @Author: jiaoxian
 * @Date: 2022/9/9 17:01
 **/
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // ˫ѭ��: i ������, j ������
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
     * @Description check ��֤��ǰֵ�Ƿ���Ч
     * @Date 2022/9/9 17:05
     * @param row: ��ǰֵ���ڵ���
     * @param col: ��ǰֵ���ڵ���
     * @param val: ��ǰֵ
     * @param board: ��������
     * @return boolean
     **/
    private static boolean check(int row, int col, char val, char[][] board) {
        // ͬ���Ƿ��ظ�
        for (int i = 0; i < 9; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] == val) {
                System.out.println("ͬ�����ظ�ֵ: ��ǰ��Ϊ: " + row + " ��ǰ��Ϊ:" + i);
                return false;
            }
        }
        // ͬ���Ƿ��ظ�
        for (int j = 0; j < 9; j++) {
            if (j == row) {
                continue;
            }
            if (board[j][col] == val) {
                System.out.println("ͬ�����ظ�ֵ: ��ǰ��Ϊ: " + j + " ��ǰ��Ϊ:" + col);
                return false;
            }
        }
        // 9�������Ƿ��ظ�
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] == val) {
                    System.out.println("ͬ�������ظ�ֵ: ��ǰ��Ϊ: " + i + " ��ǰ��Ϊ:" + j);
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
