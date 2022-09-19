package countAndSay;

/**
 * @ClassName: CountAndSay
 * @Description: leetCode-38: �������
 * @Author: jiaoxian
 * @Date: 2022/9/14 11:23
 **/
public class CountAndSay {

    // ������ֻ������ͳ���ַ�����������ͬ�ַ��ĸ���
    // ������
    // ����˫ָ�����, pos ָ��Ϊ��ǰλ��, start ָ���¼�뵱ǰָ����ָԪ����ͬ����ʼλ��;
    // pos - start ��Ϊ��ͬ�ַ����ֵĴ���
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < result.length()) {
                while (pos < result.length() && result.charAt(pos) == result.charAt(start)) {
                    pos++;
                }
                sb.append((pos - start)).append(result.charAt(start));
                start = pos;
            }
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

}
