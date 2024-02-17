package addDigits;

/**
 * @author jiaoxian
 * @name addDigits
 * @date 2023/7/12 15:37
 * @description leetCode-258: 各位相加
 */
public class AddDigits {

    public int addDigits(int num) {

        if (num < 10) {
            return num;
        } else {
            int sum = 0;
            String str = String.valueOf(num);
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - 48;
            }
            return addDigits(sum);
        }
    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(new AddDigits().addDigits(num));
    }

}
