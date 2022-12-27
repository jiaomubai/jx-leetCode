package minimumMoves;

/**
 * @author jiaoxian
 * @name minimumMoves
 * @date 2022/12/27 15:41
 * @description leetCode-2027: 转换字符串的最少操作次数
 */
public class MinimumMoves {

    public int minimumMoves(String s) {
        int covered = -1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X' && i > covered) {
                result++;
                covered = i + 2;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "XXOOXXXOOOOOOXXXXXOXXXXX";
        MinimumMoves minimumMoves = new MinimumMoves();
        System.out.println(minimumMoves.minimumMoves(s));
    }

}
