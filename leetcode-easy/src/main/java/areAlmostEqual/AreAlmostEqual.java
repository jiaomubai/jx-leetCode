package areAlmostEqual;

/**
 * @ClassName: AreAlmostEqual
 * @Description: leetCode-1790: ��ִ��һ���ַ��������ܷ�ʹ�����ַ������
 * @Author: jiaoxian
 * @Date: 2022/10/11 10:53
 **/
public class AreAlmostEqual {

    // s1 �� s2 ��һ���ô�������λ�ô���Ԫ�ز�ͬ, ���������������λ�ô���Ԫ�ز�ͬ, ��ֱ�ӷ��� false.
    // ֮�����ж� s1 ��������λ�ô���Ԫ�ؽ���֮���� s2 ��������λ�ô���Ԫ���Ƿ����

    public boolean areAlmostEqual(String s1, String s2) {
        boolean result = false;
        if (s1.length() != s2.length()) {
            return result;
        }
        // ʹ�������¼Ԫ�ز���ͬ��λ��, ����������� 2, ֱ�ӷ��� false
        int[] diffIndexArray = new int[2];
        int index = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index < 2) {
                    diffIndexArray[index++] = i;
                } else {
                    // ��ͬԪ�ص�λ�ô��ڴ��� 2
                    return result;
                }
            }
        }
        if (index == 0) {
            // �޲�ͬԪ��, �������ַ����Ѿ����
            return true;
        }
        if (index == 1) {
            // ֻ��һ��λ�ô���Ԫ�ز�ͬ
            return result;
        }
        result = s1.charAt(diffIndexArray[0]) == s2.charAt(diffIndexArray[1]) && s1.charAt(diffIndexArray[1]) == s2.charAt(diffIndexArray[0]);
        return result;
    }

    public static void main(String[] args) {
        AreAlmostEqual areAlmostEqual = new AreAlmostEqual();
        String s1 = "abcd";
        String s2 = "dcba";
        System.out.println(areAlmostEqual.areAlmostEqual(s1, s2));
    }

}
