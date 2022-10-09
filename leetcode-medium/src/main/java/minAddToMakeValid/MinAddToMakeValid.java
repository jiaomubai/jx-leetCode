package minAddToMakeValid;

/**
 * @ClassName: MinAddToMakeValid
 * @Description: leetCode-921: ʹ������Ч���������
 * @Author: jiaoxian
 * @Date: 2022/10/8 17:57
 **/
public class MinAddToMakeValid {

    // ̰��
    // ѭ�������ַ��� s, ʹ�� left ��¼�����ŵ�����, result ��¼��Ҫ��ӵ����ŵ�����
    // �����������, ��ֱ�� left �� 1; �����������, ���漰����������ƥ�������.
    // ���������������������, �Ҵ�ʱ������������Ϊ 0, ����Ϊ����������ƥ���, ���Դ�ʱ left �� 1
    // �����ʱ����������Ϊ 0, ����Ϊ�������Ų�ƥ��, ����Ҫ���һ�������Ų�����ȷƥ��, ���ʱ result �� 1
    // ��󷵻� result + left ��Ϊ��Ҫ������ӵĴ���

    public int minAddToMakeValid(String s) {
        int left = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (left < 1) {
                    result++;
                } else {
                    left--;
                }
            }
        }
        return result + left;
    }

    public static void main(String[] args) {
        MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
        String s = "()())((()";
        System.out.println(minAddToMakeValid.minAddToMakeValid(s));
    }

}
