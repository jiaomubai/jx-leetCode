package isIsomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name isIsomorphic
 * @date 2023/1/5 16:34
 * @description leetCode-205: 同构字符串
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        Map<Character, Character> charCharMap1 = new HashMap<>();
        Map<Character, Character> charCharMap2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character key1 = s.charAt(i);
            Character key2 = t.charAt(i);
            if (charCharMap1.containsKey(key1)) {
                Character value = charCharMap1.get(key1);
                if (!value.equals(key2)) {
                    return false;
                }
            } else {
                charCharMap1.put(key1, key2);
            }
            if (charCharMap2.containsKey(key2)) {
                Character value = charCharMap2.get(key2);
                if (!value.equals(key1)) {
                    return false;
                }
            } else {
                charCharMap2.put(key2, key1);
            }
        }
        return true;
    }

}
