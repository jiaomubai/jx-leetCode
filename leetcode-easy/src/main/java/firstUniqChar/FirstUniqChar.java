package firstUniqChar;

import java.util.HashMap;

/**
 * @ClassName: FirstUniqChar
 * @Author: jiaoxian
 * @Date: 2022/4/29 14:05
 * @Description: leetCode-387: 字符串中的第一个唯一字符
 */
public class FirstUniqChar {

    public static int firstUniqChar1(String s) {
        // 使用HashMap 存储的字符与插入顺序不一致,需要循环遍历完整个HashMap才能得到第一次出现一次的字符
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + s.length());
            } else {
                hashMap.put(key, i);
            }
        }
        int result = s.length();
        for (Character entry : hashMap.keySet()) {
            if (hashMap.get(entry) < s.length()) {
                if (hashMap.get(entry) < result) {
                    result = hashMap.get(entry);
                }
            }
        }
        return result == s.length() ? -1 : result;
    }

    public static int firstUniqChar2(String s) {
        // 使用HashMap + char[],用数组中的每个字符作为 key 去判断 HashMap 中该 key 的 value 是否为1
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + i);
            } else {
                hashMap.put(key, 1);
            }
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (hashMap.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar3(String s) {
        // 判断每个字符在String中第一次出现的下标是否等于最后一次出现的下标
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar3(s));
    }

}
