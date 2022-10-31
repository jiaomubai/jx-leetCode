package mergeAlternately;

/**
 * @ClassName: MergeAlternately
 * @Description: leetCode-1768: ½»ÌæºÏ²¢×Ö·û´®
 * @Author: jiaoxian
 * @Date: 2022/10/25 13:30
 **/
public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int length = Math.min(length1, length2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (length1 > length) {
            stringBuilder.append(word1.substring(length));
        }
        if (length2 > length) {
            stringBuilder.append(word2.substring(length));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MergeAlternately mergeAlternately = new MergeAlternately();
        String word1 = "word156789";
        String word2 = "word234";
        System.out.println(mergeAlternately.mergeAlternately(word1, word2));
    }

}
