package mostCommonWord;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MostCommonWord
 * @Description: leetCode-819: ����ĵ���
 * @Author: jiaoxian
 * @Date: 2022/9/19 17:09
 **/
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        // ͳ�� paragraph �г��ֵĸ������ʵ�Ƶ��
        StringBuilder wordBuilder = new StringBuilder();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                // �����ǰ�ַ�����ĸ, ��ƴ��
                wordBuilder.append(c);
            } else {
                // �����ǰ�ַ�������ĸ, �� StringBuilder �е�������Ϊһ�����ʴ�ŵ� map �в�����Ƶ��
                String key = wordBuilder.toString().toLowerCase();
                if (key.length() > 0) {
                    // �����ǰ����Ϊ���ô�, �򲻴���
                    if (isBannedWord(key, banned)) {
                        // �ָ� wordBuilder
                        wordBuilder = new StringBuilder();
                        continue;
                    }
                    wordMap.put(key, wordMap.getOrDefault(key, 0) + 1);
                }
                // �ָ� wordBuilder
                wordBuilder = new StringBuilder();
            }
        }
        if (wordBuilder.toString().length() > 0) {
            if (!isBannedWord(wordBuilder.toString(), banned)) {
                wordMap.put(wordBuilder.toString().toLowerCase(), wordMap.getOrDefault(wordBuilder.toString().toLowerCase(), 0) + 1);
            }
        }
        // ���� Map, Ѱ�ҳ��ִ������ĵ���
        int max = 0;
        for (Integer value : wordMap.values()) {
            max = Math.max(max, value);
        }
        for (String key : wordMap.keySet()) {
            if (wordMap.get(key) == max) {
                return key;
            }
        }
        return null;
    }

    /**
     * @Author jiaoxian
     * @Description isBannedWord �жϸõ����Ƿ�Ϊ���ô�
     * @Date 2022/9/19 17:26
     * @param key: ����
     * @param banned: ���ô��б�
     * @return boolean
     **/
    private boolean isBannedWord(String key, String[] banned) {
        for (String banWord : banned) {
            if (key.equals(banWord)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned));
    }

}
