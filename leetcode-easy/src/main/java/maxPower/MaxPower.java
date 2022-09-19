package maxPower;

/**
 * @ClassName: MaxPower
 * @Description: leetCode-1446: �����ַ�
 * @Author: jiaoxian
 * @Date: 2022/9/19 16:53
 **/
public class MaxPower {

    public int maxPower(String s) {
        int result = 1;
        int current = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // �����ǰ�ַ���ǰһ���ַ����, current �� 1, ����ǰ�����ַ��ĳ��� + 1
                current++;
            } else {
                // �����ǰ�ַ���ǰһ���ַ������, ����������ַ��ĳ���
                result = Math.max(current, result);
                // �ָ� current
                current = 1;
            }
        }
        return Math.max(current, result);
    }

    public static void main(String[] args) {
        MaxPower maxPower = new MaxPower();
        System.out.println(maxPower.maxPower("cc"));
    }

}
