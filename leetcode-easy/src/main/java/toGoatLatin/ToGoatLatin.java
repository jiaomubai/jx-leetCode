package toGoatLatin;

/**
 * @author jiaoxian
 * @name toGoatLatin
 * @date 2023/6/25 17:05
 * @description leetCode-824: 山羊拉丁文
 */
public class ToGoatLatin {

    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        if (sentence != null && !"".equals(sentence)) {
            String[] sentenceArr = sentence.split(" ");
            for (int i = 0; i < sentenceArr.length; i++) {
                String word = sentenceArr[i];
                String vowelString = "aeiouAEIOU";
                if (vowelString.contains(String.valueOf(word.charAt(0)))) {
                    // 元音单词，单词后添加 ma，并添加索引次 a
                    result.append(word).append("ma");
                } else {
                    // 辅音单词，首字母添加到尾部，并添加 ma
                    String newWord = word.substring(1) + word.charAt(0);
                    result.append(newWord).append("ma");
                }
                for (int j = 0; j <= i; j++) {
                    result.append("a");
                }
                result.append(" ");
            }
        }
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        System.out.println(new ToGoatLatin().toGoatLatin(sentence));

        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
        // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa

        // Imaa peaksmaaa oatGmaaaa atinLmaaaaa
        // Imaa peaksmaaa oatGmaaaa atinLmaaaaa

    }

}
