package numPrimeArrangements;

import java.util.Arrays;

/**
 * @ClassName: NumPrimeArrangements
 * @Author: jiaoxian
 * @Date: 2022/7/1 18:38
 * @Description:
 */
public class NumPrimeArrangements {

    public static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {

        // 1.计算质数的个数 primeTotal，采用埃氏筛法
        int primeTotal = countPrime(n);
        // 2.计算非质数的个数 notPrimeTotal
        int notPrimeTotal = n - primeTotal;
        // 3.计算 primeTotal 的阶乘与 notPrimeTotal 的阶乘的乘积
        int result = (int) (factorial(primeTotal) * factorial(notPrimeTotal) % MOD);
        return result;
    }

    public int countPrime(int n) {
        if (n == 2) {
            return 1;
        }
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int result = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                result += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        System.out.println("质数数量为:" + result);
        return result;
    }

    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        System.out.println( n + "的阶乘为:" + res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumPrimeArrangements().numPrimeArrangements(2));
    }

}
