package constructArray;

import util.ArraysUtil;


/**
 * @ClassName: ConstructArray
 * @Description: leetCode-667: 优美的排列 II
 * @Author: jiaoxian
 * @Date: 2022/9/8 9:17
 **/
public class ConstructArray {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int oddNum = 1;
        int evenNum = k + 1;
        // 下标 [0, k], 偶数位按顺序填充 [1, 2, 3, 4, ...], 奇数位按顺序填充 [k + 1, k, k - 1, ...]
        for (int i = 0; i <= k; i++) {
            if (i % 2 == 0) {
                result[i] = oddNum++;
            } else {
                result[i] = evenNum--;
            }
        }
        // 下标 [k + 1, n - 1], 按顺序填充剩下的数, 剩下的数应该是从 k + 2 开始, 到 n 结束
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
