package kingAndGold;

import java.util.Arrays;

/**
 * @ClassName: KingAndGold
 * @Author: jiaoxian
 * @Date: 2021/11/2 15:50
 * @Description:
 */
public class KingAndGold {

    public static Integer kingAndGold(Integer n, Integer w, Integer[] gold, Integer[] workers) {

        //存储上一行结果的数组
        Integer[] preResult = new Integer[w + 1];
        // 存储当前行结果的数组
        Integer[] result = new Integer[w + 1];
        result[0] = 0;
        // 填充边界单元格的值，即设置金矿1 的各种结果，i 用来循环工人数量，闭区间 [0, w]
        for (int i = 0; i <= w; i++) {
            if (i >= workers[1]) {
                preResult[i] = gold[1];
            } else {
                preResult[i] = 0;
            }
        }
        System.out.println("第1行的结果为：");
        display(preResult);
        // 填充其余单元格的值，外层循环金矿数量，内层循环工人数量
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < workers[i]) {
                    result[j] = preResult[j];
                } else {
                    Integer temp = preResult[j - workers[i]];
                    result[j] = Math.max(preResult[j], temp + gold[i]);
                }
            }
            preResult = Arrays.copyOf(result, result.length);
            System.out.println("第" + i + "行的结果为：");
            display(preResult);
            display(result);
        }
        return result[w];
    }

    private static void display(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + "-->");
        }
        System.out.println(array[array.length - 1]);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // 初始化金矿含金量数组
        Integer gold[] = {0, 400, 500, 200, 300, 350};
        // 初始化各金矿所需的工人数组
        Integer workers[] = {0, 5, 5, 3, 4, 3};
        // 金矿数量(也可以根据p[]的数量获得)
        Integer n = 5;
        // 工人数量
        Integer w = 10;
        Integer result = kingAndGold(n, w, gold, workers);
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}
