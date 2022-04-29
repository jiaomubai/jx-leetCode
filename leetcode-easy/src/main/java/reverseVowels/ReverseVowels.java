package reverseVowels;

/**
 * @ClassName: ReverseVowels
 * @Author: jiaoxian
 * @Date: 2022/4/28 17:24
 * @Description: leetCode-345: 反转字符串中的元音字母
 */
public class ReverseVowels {

    private static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            if (!isVowel(charArray[left])) {
                left++;
                continue;
            }
            if (!isVowel(charArray[right])) {
                right--;
                continue;
            }
            if (isVowel(charArray[left]) && isVowel(charArray[right])) {
                if (charArray[left] != charArray[right]) {
                    char temp = charArray[left];
                    charArray[left] = charArray[right];
                    charArray[right] = temp;
                }
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }

    private static boolean isVowel(Character character) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(character.toString());
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

}
