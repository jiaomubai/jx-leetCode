package vowelStrings;

/**
 * @author jiaoxian
 * @name vowelStrings
 * @date 2023/5/26 15:32
 * @description leetCode-2586: 统计范围内的元音字符串数
 */
public class VowelStrings {

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        String vowels = "aeiou";
        for (int i = left; i <= right; i++) {
            String word = words[i];
            String temp1 = String.valueOf(word.charAt(0));
            String temp2 = String.valueOf(word.charAt(word.length() - 1));
            if (vowels.contains(temp1) && vowels.contains(temp2)) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"are","amy","u"};
        int left = 0;
        int right = 2;
    }

}
