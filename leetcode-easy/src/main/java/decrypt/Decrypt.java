package decrypt;

import util.ArraysUtil;

/**
 * @ClassName: Decrypt
 * @Description: leetCode-1652: ��ը��
 * @Author: jiaoxian
 * @Date: 2022/9/26 10:52
 **/
public class Decrypt {

    // �ѵ������ҵ� k > 0 ʱ��ѭ����ӵ���һ�������� k < 0 ʱ��ѭ����ӵĵ�һ��Ԫ�ص�����
    // �� k > 0 ʱ, ѭ����ӵ���һ��Ԫ�ص�����Ϊ: (i + j + 1) % len
    // �� k < 0 ʱ, ѭ����ӵ���ʼԪ�ص�����Ϊ: (i - j - 1 + len) % len
    // ��: ���� code[] = {1, 2, 3, 4}, k = 2
    // ��ѭ�� i = 3 ʱ, ��Ϊ k = 2 > 0, ����Ҫ���������� 2 ������������滻 code[3], ����Ҫʹ�� code[0] + code[1] ���滻 code[3]
    // ��ô�� i = 3 ʱ, ѭ����ӵ�������Ϊ 0 �� 1, �� (3 + 0 + 1) % 4 = 0 �� (3 + 1 + 1) % 4 = 1
    // �� k = -2, ��ѭ�� i = 0 ʱ, ����Ҫ�� i ֮ǰ�� 2 ��Ԫ��������滻 code[0], ����Ҫʹ�� code[3] + code[2] ���滻 code[0]
    // ��ôѭ����ӵ�������Ϊ 2 �� 3, �� (0 - 0 - 1 + 4) % 4 = 3 �� (0 - 1 - 1 + 4) % 4 = 2
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        // �� k == 0 ʱ, ֱ�ӽ�ԭ�������ݸ�ֵΪ 0 ����
        if (k == 0) {
            return result;
        }
        // ѭ������ԭ����, �����±�Ϊ i ��Ԫ�ظ�ʹ��ʲôֵ���滻
        for (int i = 0; i < length; i++) {
            int sum = 0;
            // �����滻ֵ, ѭ�� |k| ��
            for (int j = 0; j < Math.abs(k); j++) {
                if (k > 0) {
                    // �� k > 0 ʱ, ʹ�ù�ʽ (i + j + 1) % len
                    sum += code[(i + j + 1) % length];
                } else {
                    // �� k < 0 ʱ, ʹ�ù�ʽ (i - j - 1 + len) % len
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
