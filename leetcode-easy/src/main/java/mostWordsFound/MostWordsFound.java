package mostWordsFound;

/**
 * @author jiaoxian
 * @name mostWordsFound
 * @date 2023/5/15 17:16
 * @description leetCode-2114: 句子中的最多单词数
 */
public class MostWordsFound {

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            String[] sentenceArr = sentence.split(" ");
            max = Math.max(sentenceArr.length, max);
        }
        return max;
    }

}
