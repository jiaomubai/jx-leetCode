package wordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name wordPattern
 * @date 2023/1/5 15:55
 * @description leetCode-290: 单词规律
 */
public class WordPattern {


    // 双射
    // Character 对应 String, String 对应 Character

    public boolean wordPattern(String pattern, String s) {
        String[] stringArray = s.split(" ");
        int length = pattern.length();
        if (length != stringArray.length) {
            return false;
        }
        Map<Character, String> charStringMap = new HashMap<>();
        Map<String, Character> stringCharMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character key1 = pattern.charAt(i);
            String key2 = stringArray[i];
            if (charStringMap.containsKey(key1)) {
                String value = charStringMap.get(key1);
                if (!value.equals(key2)) {
                    return false;
                }
            } else {
                charStringMap.put(key1, key2);
            }
            if (stringCharMap.containsKey(key2)) {
                Character value = stringCharMap.get(key2);
                if (!value.equals(key1)) {
                    return false;
                }
            } else {
                stringCharMap.put(key2, key1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "A A A A";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }

}
