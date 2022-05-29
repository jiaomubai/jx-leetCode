package findClosest;

/**
 * @ClassName: FindClosest
 * @Author: jiaoxian
 * @Date: 2022/5/27 14:42
 * @Description: leetCode-面试题 17.11: 单词距离
 */
public class FindClosest {

    public static int findClosest(String[] words, String word1, String word2) {
        int length = words.length;
        int first = 0 - length;
        int second = length;
        int minDistance = length;
        for (int i = 0; i < length; i++) {
            if (words[i].equals(word1)) {
                first = i;
            }
            if (words[i].equals(word2)) {
                second = i;
            }
            minDistance = Math.min(minDistance, Math.abs(second - first));
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String string = "I am a student";
        String[] words = string.split(",");
        String word1 = "I";
        String word2 = "a";
        int result = findClosest(words, word1, word2);
        System.out.println(result);
    }

}
