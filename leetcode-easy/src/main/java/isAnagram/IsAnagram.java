package isAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name isAnagram
 * @date 2023/1/5 16:47
 * @description leetCode-242: 有效的字母异位词
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        // 哈希表记录字符与次数的对应关系 Character-Integer
        // s 负责给 value 加 1
        // t 负责给 value 减 1
        // 遍历完 s 和 t 之后再去遍历哈希表, 如果有不等于 0 的值存在, 则 false

        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character key = s.charAt(i);
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        for (int i = 0; i < length; i++) {
            Character key = t.charAt(i);
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, --value);
            } else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String s = "cat";
        String t = "taa";
        System.out.println(isAnagram.isAnagram(s, t));

    }

}
