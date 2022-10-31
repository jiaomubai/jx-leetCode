package arraySign;

/**
 * @ClassName: ArraySign
 * @Description: leetCode-1822: ����Ԫ�ػ��ķ���
 * @Author: jiaoxian
 * @Date: 2022/10/27 16:13
 **/
public class ArraySign {

    public int arraySign(int[] nums) {
        // ��¼С�� 0 ��Ԫ������
        int lessZeroNum = 0;
        for (int num : nums) {
            if (num < 0) {
                lessZeroNum++;
            }
            if (num == 0) {
                return 0;
            }
        }
        return lessZeroNum % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 8, -2, -3};
        ArraySign arraySign = new ArraySign();
        System.out.println(arraySign.arraySign(nums));
    }

}
