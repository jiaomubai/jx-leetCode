package alternateDigitSum;

/**
 * @author jiaoxian
 * @name alternateDigitSum
 * @date 2023/7/12 15:27
 * @description leetCode-2544: ½»ÌæÊý×ÖºÍ
 */
public class AlternateDigitSum {

    public int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 48;
            if (i % 2 == 0) {
                sum = sum + num;
            } else {
                sum = sum - num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 886996;
        System.out.println(new AlternateDigitSum().alternateDigitSum(n));
    }

}
