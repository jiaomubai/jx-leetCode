package squareIsWhite;

/**
 * @author jiaoxian
 * @name squareIsWhite
 * @date 2022/12/14 13:29
 * @description leetCode-1812: 判断国际象棋棋盘中一个格子的颜色
 */
public class SquareIsWhite {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 96;
        int y = coordinates.charAt(1) - 48;
        if (x % 2 == 0) {
            if (y % 2 == 0) {
                // 偶数行偶数列，黑色
                return false;
            } else {
                // 偶数行奇数列，白色
                return true;
            }
        } else {
            if (y % 2 == 0) {
                // 奇数行偶数列，白色
                return true;
            } else {
                // 奇数行奇数列，黑色
                return false;
            }
        }
    }

}
