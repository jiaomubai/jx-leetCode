package canConstruct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaoxian
 * @name canConstruct
 * @date 2023/1/6 10:52
 * @description leetCode-383: 赎金信
 */
public class CanConstruct {

    // 使用 map 记录字符串 magazine 中字符与其出现次数的对应关系
    // 遍历字符串 ransomNote, 如果字符在 map 中存在, 则其对应的 value 减 1, 若 value 小于 0, 则 false
    // 若字符在 map 中不存在, 则 false

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character key = magazine.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character key = ransomNote.charAt(i);
            if (map.containsKey(key)) {
                Integer value = map.get(key) - 1;
                if (value < 0) {
                    return false;
                } else {
                    map.put(key, value);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        String ransomNote = "aabcd";
        String magazine = "aaabc";
        System.out.println(canConstruct.canConstruct(ransomNote, magazine));
    }

}
