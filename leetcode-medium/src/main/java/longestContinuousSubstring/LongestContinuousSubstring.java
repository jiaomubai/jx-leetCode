package longestContinuousSubstring;

/**
 * @ClassName: LongestContinuousSubstring
 * @Description: leetCode-2414: �����ĸ���������ַ����ĳ���
 * @Author: jiaoxian
 * @Date: 2022/9/19 10:32
 **/
public class LongestContinuousSubstring {

    // ���� maxLength Ϊ���������ĸ��ĳ���, currentLength Ϊ��ǰ�������ĸ��ĳ���, ��ʼֵΪ 1, ����ǰ�ַ�, ���շ��� maxLength �� currentLength �нϴ�ֵ����
    // �����ַ���, �����һ���ַ����뵱ǰ�ַ���Ϊ������ĸ��(�������ַ�����), �� currentLength ���� 1
    // ��������ַ�������, ���� maxLength ���ָ� currentLength
    // ѭ��������, �ٸ��� maxLength, ���ǵ����һ���ַ��뵹���ڶ����ַ�Ϊ��ĸ������

    public int longestContinuousSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) - s.charAt(i) == 1) {
                currentLength += 1;
            } else {
                maxLength = Math.max(currentLength, maxLength);
                currentLength = 1;
            }
        }
        return Math.max(currentLength, maxLength);
    }

    // ���� StringBuilder ����ŷ�����ĸ������ַ���, ���������߼��� longestContinuousSubstring() ������ͬ

    public int longestContinuousSubstring2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int maxLength = 0;
        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                stringBuilder.append(s.charAt(i));
            } else {
                maxLength = Math.max(maxLength, stringBuilder.toString().length());
                stringBuilder = new StringBuilder();
                stringBuilder.append(s.charAt(i));
            }
        }
        return Math.max(maxLength, stringBuilder.toString().length());
    }

    public static void main(String[] args) {
        LongestContinuousSubstring longestContinuousSubstring = new LongestContinuousSubstring();
        String s = "abcdeghijklmn";
        System.out.println("result1 = " + longestContinuousSubstring.longestContinuousSubstring(s));
        System.out.println("result2 = " + longestContinuousSubstring.longestContinuousSubstring2(s));
    }

}
