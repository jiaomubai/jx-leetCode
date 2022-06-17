package minFlipsMonoIncr;

/**
 * @ClassName: MinFlipsMonoIncr
 * @Author: jiaoxian
 * @Date: 2022/6/11 14:34
 * @Description:
 */
public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        // 右半部分, 0 变为 1 需要 sumZeroForRight 步, 1 变为 0 需要 sumOneForRight 步
        int sumZeroForRight = 0;
        int sumOneForRight = 0;
        String rightPart = s.substring(s.length() / 2);
        for (int i = 0; i < rightPart.length(); i++) {
            if (s.charAt(i) == '0') {
                sumZeroForRight++;
            } else {
                sumOneForRight++;
            }
        }
        // 左半部分, 0 变为 1 需要 sumZeroForLeft 步, 1 变为 0 需要 sumOneForLeft 步
        int sumZeroForLeft = 0;
        int sumOneForLeft = 0;
        String leftPart = s.substring(0, s.length() / 2 + 1);
        for (int i = 0; i < leftPart.length(); i++) {
            if (s.charAt(i) == '0') {
                sumZeroForLeft++;
            } else {
                sumOneForLeft++;
            }
        }
        // 左边为 0 右边为 1
        int sumZeroOne = sumOneForLeft + sumZeroForRight;
        // 左边为 1 右边为 1
        int sumOneOne = sumZeroForLeft + sumZeroForRight;
        // 左边为 0 右边为 0
        int sumZeroZero = sumOneForLeft + sumOneForRight;
        return Math.min(Math.min(sumZeroOne, sumOneOne), sumZeroZero);
    }

    public static void main(String[] args) {
        System.out.println(new MinFlipsMonoIncr().minFlipsMonoIncr("00011110"));
    }

}
