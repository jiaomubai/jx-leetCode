package checkIfPangram;

/**
 * @author jiaoxian
 * @name checkIfPangram
 * @date 2022/12/13 15:05
 * @description leetCode-1832: 判断句子是否为全字母句
 */
public class CheckIfPangram {

    public boolean checkIfPangram(String sentence) {
        int length = sentence.length();
        boolean[] array = new boolean[26];
        for (int i = 0; i < length; i++) {
            char s = sentence.charAt(i);
            array[s - 'a'] = true;
        }
        for (boolean x : array) {
            if (!x) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfPangram checkIfPangram = new CheckIfPangram();
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram.checkIfPangram(sentence));
    }

}
