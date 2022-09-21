package constructArray;

import util.ArraysUtil;


/**
 * @ClassName: ConstructArray
 * @Description: leetCode-667: ���������� II
 * @Author: jiaoxian
 * @Date: 2022/9/8 9:17
 **/
public class ConstructArray {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int oddNum = 1;
        int evenNum = k + 1;
        // �±� [0, k], ż��λ��˳����� [1, 2, 3, 4, ...], ����λ��˳����� [k + 1, k, k - 1, ...]
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0) {
                result[i] = oddNum++;
            } else {
                result[i] = evenNum--;
            }
        }
        // �±� [k + 1, n - 1], ��˳�����ʣ�µ���, ʣ�µ���Ӧ���Ǵ� k + 2 ��ʼ, �� n ����
        for (int i = n - 1; i >= k + 1; i--) {
            result[i] = n--;
        }
        ArraysUtil.displayIntArray(result);
        return result;
    }

    public static void main(String[] args) {
        ConstructArray constructArray = new ConstructArray();
        int n = 50; int k = 20;
        constructArray.constructArray(n, k);

    }

}
