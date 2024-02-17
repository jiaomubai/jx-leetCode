package judgeCircle;

/**
 * @author jiaoxian
 * @name judgeCircle
 * @date 2023/6/2 16:39
 * @description leetCode-657: 机器人能否返回原点
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int countUD = 0;
        int countLR = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                countUD++;
            } else if (moves.charAt(i) == 'D') {
                countUD--;
            } else if (moves.charAt(i) == 'L') {
                countLR++;
            } else if (moves.charAt(i) == 'R') {
                countLR--;
            }
        }
        if (countLR == 0 && countUD == 0) {
            return true;
        }
        return false;
    }

}
