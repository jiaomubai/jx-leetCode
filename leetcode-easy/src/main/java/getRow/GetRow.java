package getRow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: GetRow
 * @Author: jiaoxian
 * @Date: 2021/11/5 16:30
 * @Description: leetCode-119:杨辉三角II
 */
public class GetRow {

    // 递归
    public static List<Integer> getRow(int rowIndex) {
        Integer[] array = new Integer[rowIndex + 1];
        // rowIndex = 0 时，直接返回 [1]
        if (rowIndex == 0) {
            array[0] = 1;
            return Arrays.asList(array);
        }
        // rowIndex = 1 时，直接返回 [1, 1]
        if (rowIndex == 1) {
            array[0] = 1;
            array[1] = 1;
            return Arrays.asList(array);
        }
        array[0] = 1;
        array[1] = 1;
        // 从第三行(即 i = 2)开始使用公式去递归
        for (int i = 2; i <= rowIndex; i++) {
            if (i == rowIndex) {
                array[rowIndex] = 1;
            }
            array[i - 1] = getRow(rowIndex - 1).get(i - 2) + getRow(rowIndex - 1).get(i - 1);
        }
        return Arrays.asList(array);
    }

    // 使用公式迭代
    // 第 n 行的第 m 个数可表示为 C(n-1，m-1)，即为从 n - 1 个不同元素中取 m - 1 个元素的组合数。
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> resultList = new ArrayList<>(rowIndex + 1);
        resultList.add(1);
        BigDecimal factorialN = getFactorial(rowIndex);
        for (int i = 1; i <= rowIndex; i++) {
            BigDecimal factorialM = getFactorial(i);
            BigDecimal factorialNM = getFactorial(rowIndex - i);
            BigDecimal result = factorialN.divide(factorialM.multiply(factorialNM), 4, BigDecimal.ROUND_HALF_UP);
            resultList.add(result.intValue());
        }
        return resultList;
    }

    public static BigDecimal getFactorial(int n) {
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(new BigDecimal(i));
        }
        return factorial;
    }

    // 动态规划,第 i 行第 j 个数 = 第 i - 1 行第 j 个数 + 第 i - 1 行第 j - 1 个数
    public static List<Integer> getRow3(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        // i 控制当前行,i = 2 其实表示的是第三行
        for(int i = 2; i <= rowIndex; i++) {
            // j 控制前一行,j = 1 时表示第二个数
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> resultList = getRow2(34);
        System.out.println(resultList);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
