package maximumSwap;

import lombok.extern.slf4j.Slf4j;
import util.ArraysUtil;

import java.util.Arrays;

/**
 * @ClassName: MaximumSwap
 * @Description: leetCode-670: ��󽻻�
 * @Author: jiaoxian
 * @Date: 2022/9/13 9:02
 **/
@Slf4j
public class MaximumSwap {

    // 1. �� int ����ת��������
    // 2. copy ������, ����������
    // 3. ��λ�Ƚ���������, ��������±��Ӧ��Ԫ�ز�һ��, �򽻻�(ֻ����һ�ν���)

    public int maximumSwap(int num) {
        // �� int ����ת��������
        String strTemp = String.valueOf(num);
        int[] array = new int[strTemp.length()];
        for (int i = 0; i < strTemp.length(); i++) {
            array[i] = Integer.valueOf(String.valueOf(strTemp.charAt(i)));
        }
        ArraysUtil.displayIntArray(array);
        // ���Ƹ����鲢��������
        int[] arrayDesc = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayDesc);
        for (int i = 0; i < arrayDesc.length / 2; i++) {
            int temp = arrayDesc[i];
            arrayDesc[i] = arrayDesc[arrayDesc.length - 1 - i];
            arrayDesc[arrayDesc.length - 1 - i] = temp;
        }
        ArraysUtil.displayIntArray(arrayDesc);
        // �Ƚ���������, �����ͬ�±��Ӧ��Ԫ�ز�һ��, �򽻻�
        int result = 0;
        // �Ƿ����������ʶ
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

    // �������: ö������������������ɵ�����, ����Щ������ȡ����
    public int maximumSwap2(int num) {
        String strTemp = String.valueOf(num);
        char[] array = strTemp.toCharArray();
        int result = num;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // ���� i��j λ�õ�Ԫ��
                swap(i, j, array);
                // ���� i��j ֮������ɵ���Ϊ tempResult
                int tempResult = Integer.parseInt(new String(array));
                result = Math.max(result, tempResult);
                // �ٴν��� i��j, �ָ� num ˳��, �ȴ��´ν���
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
