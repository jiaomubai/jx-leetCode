package maximumSwap;

import lombok.extern.slf4j.Slf4j;
import util.ArraysUtil;

import java.util.Arrays;

/**
 * @ClassName: MaximumSwap
 * @Description: leetCode-670: 最大交换
 * @Author: jiaoxian
 * @Date: 2022/9/13 9:02
 **/
@Slf4j
public class MaximumSwap {

    // 1. 将 int 数据转换成数组
    // 2. copy 该数组, 并降序排序
    // 3. 逐位比较两个数组, 如果两个下标对应的元素不一致, 则交换(只进行一次交换)

    public int maximumSwap(int num) {
        // 将 int 数据转换成数组
        String strTemp = String.valueOf(num);
        int[] array = new int[strTemp.length()];
        for (int i = 0; i < strTemp.length(); i++) {
            array[i] = Integer.valueOf(String.valueOf(strTemp.charAt(i)));
        }
        ArraysUtil.displayIntArray(array);
        // 复制该数组并降序排序
        int[] arrayDesc = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayDesc);
        for (int i = 0; i < arrayDesc.length / 2; i++) {
            int temp = arrayDesc[i];
            arrayDesc[i] = arrayDesc[arrayDesc.length - 1 - i];
            arrayDesc[arrayDesc.length - 1 - i] = temp;
        }
        ArraysUtil.displayIntArray(arrayDesc);
        // 比较两个数组, 如果相同下标对应的元素不一致, 则交换
        int result = 0;
        // 是否继续交换标识
        boolean swapFlag = false;
        for (int i = 0; i < arrayDesc.length; i++) {
            if (arrayDesc[i] != array[i] && !swapFlag) {
                int temp = array[i];
                int target = arrayDesc[i];
                int targetIndex = 0;
                for (int j = i; j < array.length; j++) {
                    if (array[j] == target) {
                        targetIndex = j;
                    }
                }
                array[i] = array[targetIndex];
                array[targetIndex] = temp;
                swapFlag = true;
            }
            result = result * 10 + array[i];
        }
        //log.info("result = {}", result);
        return result;
    }

    // 暴力求解: 枚举所有两两交换后组成的数据, 在这些数据中取最大的
    public int maximumSwap2(int num) {
        String strTemp = String.valueOf(num);
        char[] array = strTemp.toCharArray();
        int result = num;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // 交换 i、j 位置的元素
                swap(i, j, array);
                // 交换 i、j 之后新组成的数为 tempResult
                int tempResult = Integer.parseInt(new String(array));
                result = Math.max(result, tempResult);
                // 再次交换 i、j, 恢复 num 顺序, 等待下次交换
                swap(i, j, array);
            }
        }
        return result;
    }

    private void swap(int i, int j, char[] array) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        int num = 95271;
        int result = maximumSwap.maximumSwap2(num);
        //log.info("result = {}", result);
    }

}
