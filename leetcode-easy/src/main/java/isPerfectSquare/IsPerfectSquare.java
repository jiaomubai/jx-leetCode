package isPerfectSquare;

/**
 * @ClassName: IsPerfectSquare
 * @Author: jiaoxian
 * @Date: 2022/4/29 15:27
 * @Description: leetCode-367: 有效的完全平方数
 */
public class IsPerfectSquare {

    public static boolean isPerfectSquare1(int num) {
        for (int i = 1; i <= (num + 1) / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare2(int num) {
        // 二分法
        int left = 1;
        int right = num;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            System.out.println(middle);
            int temp = num / middle;
            if (temp == middle && num % temp == 0) {
                return true;
            } else if (temp > middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(isPerfectSquare1(16));
        System.out.println(isPerfectSquare2(2147483647));
    }

}
