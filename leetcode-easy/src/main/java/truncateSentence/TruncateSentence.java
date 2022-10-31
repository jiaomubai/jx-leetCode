package truncateSentence;

/**
 * @ClassName: TruncateSentence
 * @Description: leetCode-1816: ½Ø¶Ï¾ä×Ó
 * @Author: jiaoxian
 * @Date: 2022/10/27 17:02
 **/
public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        String[] wordArray = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder(wordArray[0]);
        for (int i = 1; i < k; i++) {
            stringBuilder.append(" ");
            stringBuilder.append(wordArray[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TruncateSentence truncateSentence = new TruncateSentence();
        String s = "how are you I am fine thank you";
        int k = 3;
        System.out.println(truncateSentence.truncateSentence(s, k));
    }

}
