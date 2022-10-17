package sumOfNumberAndReverse;

/**
 * @ClassName: SumOfNumberAndReverse
 * @Description: leetCode-6219: 反转之后的数字和
 * @Author: jiaoxian
 * @Date: 2022/10/17 16:27
 **/
public class SumOfNumberAndReverse {

    public boolean sumOfNumberAndReverse(int num) {
        // 枚举
        for (int i = 0; i <= num; i++) {
            // 反转
            StringBuilder stringBuilder = new StringBuilder().append(i);
            stringBuilder.reverse();
            int reversNum = Integer.valueOf(stringBuilder.toString());
            if (i + reversNum == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfNumberAndReverse sumOfNumberAndReverse = new SumOfNumberAndReverse();
        int num = 88;
        System.out.println(sumOfNumberAndReverse.sumOfNumberAndReverse(num));
    }


}
