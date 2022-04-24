package mySqrt;

/**
 * @ClassName: MySqrt
 * @Author: jiaoxian
 * @Date: 2021/9/26 15:16
 * @Description:
 */
public class MySqrt {

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            System.out.println("left = " + left + ", right = " + right + ", middle = " + middle);
            // 使用 middle * middle 会溢出，所以改使用除法
            if (x / middle > middle) {
                // middle * middle < x
                left = middle + 1;
            } else if (x / middle < middle) {
                // middle * middle > x
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return right;
    }

    public static int mySqrt2(int x) {
        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int x = 6;
        int result = mySqrt2(x);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
