package firstUniqChar;

import java.util.HashMap;

/**
 * @ClassName: FirstUniqChar
 * @Author: jiaoxian
 * @Date: 2022/4/29 14:05
 * @Description: leetCode-387: 字符串中的第一个唯一字符
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {
        int result = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.remove(s.charAt(i));
            } else {
                hashMap.put(s.charAt(i), i);
            }
        }
        for (Character entry : hashMap.keySet()) {
            result = hashMap.get(entry);
            break;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

}
