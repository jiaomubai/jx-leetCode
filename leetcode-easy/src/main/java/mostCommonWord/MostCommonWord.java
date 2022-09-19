package mostCommonWord;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MostCommonWord
 * @Description: leetCode-819: 最常见的单词
 * @Author: jiaoxian
 * @Date: 2022/9/19 17:09
 **/
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        // 统计 paragraph 中出现的各个单词的频率
        StringBuilder wordBuilder = new StringBuilder();
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                // 如果当前字符是字母, 则拼接
                wordBuilder.append(c);
            } else {
                // 如果当前字符不是字母, 则将 StringBuilder 中的内容作为一个单词存放到 map 中并设置频率
                String key = wordBuilder.toString().toLowerCase();
                if (key.length() > 0) {
                    // 如果当前单词为禁用词, 则不处理
                    if (isBannedWord(key, banned)) {
                        // 恢复 wordBuilder
                        wordBuilder = new StringBuilder();
                        continue;
                    }
                    wordMap.put(key, wordMap.getOrDefault(key, 0) + 1);
                }
                // 恢复 wordBuilder
                wordBuilder = new StringBuilder();
            }
        }
        if (wordBuilder.toString().length() > 0) {
            if (!isBannedWord(wordBuilder.toString(), banned)) {
                wordMap.put(wordBuilder.toString().toLowerCase(), wordMap.getOrDefault(wordBuilder.toString().toLowerCase(), 0) + 1);
            }
        }
        // 遍历 Map, 寻找出现次数最多的单词
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
     * @Description isBannedWord 判断该单词是否为禁用词
     * @Date 2022/9/19 17:26
     * @param key: 单词
     * @param banned: 禁用词列表
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
