package trimMean;

import java.util.Arrays;

/**
 * @ClassName: TrimMean
 * @Description: leetCode-1619: 删除某些元素后的数组均值
 * @Author: jiaoxian
 * @Date: 2022/9/14 9:54
 **/
public class TrimMean {

    // 排序法
    // 1. 将数组升序排序
    // 2. 计算中间 90% 的数据的平均数(90% 即区间 [n / 20, 19n / 20)内的元素), n 为数组长度
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int n = arr.length;
        for (int i = n / 20; i < n * 19 / 20; i++) {
            sum += arr[i];
        }
        System.out.println("sum = " + sum);
        double result = sum / (n * 0.9);
        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {
        TrimMean trimMean = new TrimMean();
        int[] array = {4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1};
        System.out.println(trimMean.trimMean(array));
    }

}
