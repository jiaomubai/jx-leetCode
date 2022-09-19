package maxLengthBetweenEqualCharacters;

import java.util.Arrays;

/**
 * @ClassName: MaxLengthBetweenEqualCharacters
 * @Description: leetCode-1624: ������ͬ�ַ�֮�������ַ���
 * @Author: jiaoxian
 * @Date: 2022/9/19 9:49
 **/
public class MaxLengthBetweenEqualCharacters {

    // �����ַ� c ��˵, ֻ��Ҫ��� c ��һ�γ������ַ����е�����λ�� first �����һ�γ������ַ����е�����λ�� last ����, ���� c Ϊ��ͬ�ַ�֮������ַ�������󳤶Ⱦ��� last - first - 1, ���ǿ�������������п��ܵ����ַ��ĳ��ȵ����ֵ.
    // ���ǽ������� tempArray[26] ��¼ÿ���ַ� i ���ַ����е�һ�γ��ֵ�����, maxLength ��ʾ��ǰ���ַ�������󳤶�.
    // ��ʼ��ʱ tempArray �е�ÿ��Ԫ�ض���ʼ��Ϊ -1, ��ʾ���ַ���δ����.
    // ѭ�������ַ��� s, ���������� i ���ַ� c ʱ, �����ǰ������ tempArray[c] = -1 ʱ, ���¼���ַ���һ�γ��ֵ�����Ϊ i, ͬʱ���� tempArray[c] = i;
    // �����ǰ������ tempArray[c] �� 0 ʱ, ���ʾ�ַ� c �ڴ�֮ǰ�Ѿ����ֹ�, ��ʱ���� c ֮������ַ�������Ϊ i - tempArray[c] - 1, ͬʱ���� maxLength.
    // �������ĳ��� maxLength\textit{maxLength}maxLength ���ɡ�

    public int maxLengthBetweenEqualCharacters(String s) {
        // ��ʱ���� tempArray(�ַ� 'a' ���±��� 0, �ַ� 'b' ���±��� 1, �ַ� 'z' ���±��� 25), ��¼�ַ����ֵ�����
        int[] tempArray = new int[26];
        // ��ʼ�� tempArray, Ԫ��Ϊ -1
        Arrays.fill(tempArray, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            if (tempArray[s.charAt(i) - 'a'] < 0) {
                // ������ַ�֮ǰû�г��ֹ�, ����� tempArray
                tempArray[s.charAt(i) - 'a'] = i;
            } else {
                // ����Ѿ����ֹ�, ���������ַ����ĳ��ȼ���
                maxLength = Math.max(maxLength, i - tempArray[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters maxLengthBetweenEqualCharacters = new MaxLengthBetweenEqualCharacters();
        String s = "abcdefbfedcb";
        int result = maxLengthBetweenEqualCharacters.maxLengthBetweenEqualCharacters(s);
        System.out.println("result = " + result);
    }

}
