package guessNumber;

/**
 * @ClassName: GuessNumber
 * @Author: jiaoxian
 * @Date: 2022/4/28 16:27
 * @Description: leetCode-374:猜数字大小
 */
public class GuessNumber {

    public static int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (guess(middle) == -1) {
                right = middle - 1;
            } else if (guess(middle) == 1) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return left;
    }

    public static int guess(int n) {
        int pick = 6;
        if (n > pick) {
            return -1;
        } else if (n < pick) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(guessNumber(num));
    }

}
