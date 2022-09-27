package checkPermutation;

import java.util.Arrays;

/**
 * @ClassName: CheckPermutation
 * @Description: leetCode-������ 01.02: �ж��Ƿ�Ϊ�ַ�����
 * @Author: jiaoxian
 * @Date: 2022/9/27 9:38
 **/
public class CheckPermutation {

    public boolean checkPermutation(String s1, String s2) {
        // ��� s1 �ĳ����� s2 �ĳ��Ȳ����, ��ֱ�� return
        if (s1.length() != s2.length()) {
            return false;
        }
        // ���ַ���ת��Ϊ�ַ�����֮���������, ���Ƿ����
        char[] strArray1 = s1.toCharArray();
        Arrays.sort(strArray1);
        char[] strArray2 = s2.toCharArray();
        Arrays.sort(strArray2);
        return Arrays.equals(strArray1, strArray2);
    }

    public boolean checkPermutation2(String s1, String s2) {
        // ��� s1 �ĳ����� s2 �ĳ��Ȳ����, ��ֱ�� return
        if (s1.length() != s2.length()) {
            return false;
        }
        // ʹ��һ����СΪ 26 ������ temp[] ȥ��¼ s1 ��ÿ���ַ����ֵĴ���, �±�Ϊ 0 �Ĵ��ַ� 'a' ���ֵĴ���, �±�Ϊ 25 ���ַ� 'z' ���ֵĴ���.
        // Ȼ����� s2 ��ÿ���ַ�, �� temp[] ����Ӧ�±��ֵ���� -- ����
        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            temp[s2.charAt(i) - 'a']--;
            // ���ĳ���±��ֵС�� 0, �� return false
            // ע��Ϊʲôֻ�ж�С�� 0 ���ܴﵽҪ�󣿾ٸ�����, s1 = "aacba", s2 = "cbaad"
            // ��Ϊ��ʱ s1 �� s2 �ĳ�������ȵ�, s1 ���������� temp[0] = 3, ���� s2 ʱ, ���ַ�Ϊ 'a' ʱ, temp[0] �����Լ�����, ��ô���ȿ϶�����ȥ�жϴ��� 0
            // �ж�С�� 0 ��ԭ����: ������ȵ������ַ��� s1 �� s2, ��� s1 ��ĳ���ַ����ֵĴ����ȸ��ַ��� s2 �г��ֵĴ�����, ��ô�Ϳ϶���һ���ַ��� s2 �г��ֵĴ������� s1 �г��ֵĴ�����
            // ���ʾ������, ��Ȼ 'a' �� s1 �г��ֵĴ������� s2 �г��ֵĴ�����, Ҳ��ζ�ű����� s2 ֮�� temp[0] > 0, �����ַ� 'd' �� s2 �г��ֵĴ������� s1 �г��ֵĴ�����, ���� temp[3] < 0
            // ��Ҳ�������ڱ����� s2 ֮��û����ȥ���� temp[] Ѱ��ֵ > 0 �� < 0 ��ԭ��
            if (temp[s2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        String s1 = "aacba";
        String s2 = "cbaad";
        System.out.println(checkPermutation.checkPermutation2(s1, s2));
    }

}
