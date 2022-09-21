package countPrefixes;

/**
 * @ClassName: CountPrefixes
 * @Description: leetCode-2255: ͳ���Ǹ����ַ���ǰ׺���ַ�����Ŀ
 * @Author: jiaoxian
 * @Date: 2022/9/21 10:27
 **/
public class CountPrefixes {

    // ѭ������ words[], �ж� s ���� words ��Ԫ�ؿ�ʼ������
    public int countPrefixes(String[] words, String s) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                ++result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPrefixes countPrefixes = new CountPrefixes();
        String[] words = {"a", "ab", "abc", "c", "d"};
        String s = "abcd";
        System.out.println(countPrefixes.countPrefixes(words, s));
    }

}
