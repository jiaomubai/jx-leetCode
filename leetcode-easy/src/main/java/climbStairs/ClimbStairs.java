package climbStairs;

import java.util.HashMap;

/**
 * @ClassName: ClimbStairs
 * @Author: jiaoxian
 * @Date: 2021/9/27 14:49
 * @Description:
 */
public class ClimbStairs {

    // 迭代(动态规划)
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int temp1 = 1;
        int temp2 = 2;
        for (int i = 3; i <= n; i++) {
            int result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return temp2;
    }

    // 递归
    public static int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return climbStairs2(n - 1) + climbStairs2(n - 2);
        }
    }

    // 备忘录
    public static int climbStairs3(int n, HashMap<Integer, Integer> map) {
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            Integer value = climbStairs3(n -1, map) + climbStairs3(n -2, map);
            map.put(n, value);
            return value;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int result = climbStairs3(10, new HashMap<>());
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
