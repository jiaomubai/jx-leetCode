package fib;

/**
 * @ClassName: Fib
 * @Author: jiaoxian
 * @Date: 2022/4/29 09:58
 * @Description: leetCode-509: 斐波那契数
 */
public class Fib {

    public static  int fib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        int fib0 = 0;
        int fib1 = 1;
        int fibn = 0;
        for (int i = 2; i <= n; i++) {
            fibn = fib0 + fib1;
            fib0 = fib1;
            fib1 = fibn;
        }
        return fibn;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

}
