package decrypt;

import util.ArraysUtil;

/**
 * @ClassName: Decrypt
 * @Description: leetCode-1652: 拆炸弹
 * @Author: jiaoxian
 * @Date: 2022/9/26 10:52
 **/
public class Decrypt {

    // 难点在于找到 k > 0 时的循环相加的下一个索引和 k < 0 时的循环相加的第一个元素的索引
    // 当 k > 0 时, 循环相加的下一个元素的索引为: (i + j + 1) % len
    // 当 k < 0 时, 循环相加的起始元素的索引为: (i - j - 1 + len) % len
    // 如: 假设 code[] = {1, 2, 3, 4}, k = 2
    // 则当循环 i = 3 时, 因为 k = 2 > 0, 则需要将接下来的 2 个数字相加来替换 code[3], 即需要使用 code[0] + code[1] 来替换 code[3]
    // 那么当 i = 3 时, 循环相加的索引就为 0 和 1, 即 (3 + 0 + 1) % 4 = 0 和 (3 + 1 + 1) % 4 = 1
    // 若 k = -2, 则当循环 i = 0 时, 就需要将 i 之前的 2 个元素相加来替换 code[0], 即需要使用 code[3] + code[2] 来替换 code[0]
    // 那么循环相加的索引就为 2 和 3, 即 (0 - 0 - 1 + 4) % 4 = 3 和 (0 - 1 - 1 + 4) % 4 = 2
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        // 当 k == 0 时, 直接将原数组内容赋值为 0 返回
        if (k == 0) {
            return result;
        }
        // 循环遍历原数组, 计算下标为 i 的元素该使用什么值来替换
        for (int i = 0; i < length; i++) {
            int sum = 0;
            // 计算替换值, 循环 |k| 次
            for (int j = 0; j < Math.abs(k); j++) {
                if (k > 0) {
                    // 当 k > 0 时, 使用公式 (i + j + 1) % len
                    sum += code[(i + j + 1) % length];
                } else {
                    // 当 k < 0 时, 使用公式 (i - j - 1 + len) % len
                    sum += code[(i - j - 1 + length) % length];
                }
                result[i] = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();
        int[] code = {1, 2, 3, 4, 5, 6, 0};
        int[] result = decrypt.decrypt(code, 3);
        ArraysUtil.displayIntArray(result);
    }

}
