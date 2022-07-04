package countPrimes;

import java.util.Arrays;

/**
 * @ClassName: CountPrimes
 * @Author: jiaoxian
 * @Date: 2022/6/30 17:09
 * @Description:
 */
public class CountPrimes {

    // 1.枚举法：除了 1 和它本身之外没有其他因数的自然数称为质数，也叫素数。
    // 枚举法就是对于每个数 x 从小到大枚举 [2, x - 1] 范围内的每个数 y，判断 y 是否为 x 的因数。这样的话时间复杂度是 O(n)。
    // 如果 y 为 x 的因数，那么 x / y 也一定是 x 的因数，而 y 与 x / y 中的较小的一个值一定落在区间 [2, sqrt(x)] 内，于是我们遍只需要枚举 [2, sqrt(x)] 区间内的所有数即可，此时时间复杂度就变为 O(sqrt(n))。

    public int countPrimes(int n) {
        int result = 0;
        for (int i = 2; i < n; ++i) {
            result += isPrime(i) ? 1 : 0;
        }
        return result;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 2：埃氏筛
    // 该算法由希腊数学家厄拉多塞（Eratosthenes）提出，称为厄拉多塞筛法，简称埃氏筛。
    // 我们考虑这样一个事实：如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,…一定不是质数，因此我们可以从这里入手。
    // 我们设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0。
    // 从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 0，这样在运行结束的时候我们即能知道质数的个数。
    // 这种方法的正确性是比较显然的：这种方法显然不会将质数标记成合数；
    // 另一方面，当从小到大遍历到数 x 时，倘若它是合数，则它一定是某个小于 x 的质数 y 的整数倍，故根据此方法的步骤，我们在遍历到 y 时，
    // 就一定会在此时将 x 标记为 isPrime[x]=0。因此，这种方法也不会将合数标记为质数。
    // 当然这里还可以继续优化，对于一个质数 x，如果按上文说的我们从 2x 开始标记其实是冗余的，应该直接从 x * x 开始标记，因为 2x,3x,… 这些数一定在 x 之前就被其他数的倍数标记过了，例如 2 的所有倍数，3 的所有倍数等。

    public int countPrimes2(int n) {
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
        return result;
    }

    
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(2));
        System.out.println(new CountPrimes().countPrimes2(2));
    }

}
