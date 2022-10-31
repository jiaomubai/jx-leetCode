package averageValue;

/**
 * @ClassName: AverageValue
 * @Description: leetCode-2455: 可被三整除的偶数的平均值
 * @Author: jiaoxian
 * @Date: 2022/10/31 15:43
 **/
public class AverageValue {

    // 可被 3 整除的偶数，一定得可以被 6 整除
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        int result = sum / count;
        return result;
    }

}
