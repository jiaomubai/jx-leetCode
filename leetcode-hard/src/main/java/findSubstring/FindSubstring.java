package findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FindSubstring
 * @Author: jiaoxian
 * @Date: 2022/6/23 14:52
 * @Description:
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        out:
        for (int i = 0; i + m * w <= n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            String sub = s.substring(i, i + m * w);
            for (int j = 0; j < sub.length(); j += w) {
                String item = sub.substring(j, j + w);
                if (!map.containsKey(item)) {
                    continue out;
                }
                cur.put(item, cur.getOrDefault(item, 0) + 1);
            }
            if (cur.equals(map)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"bar", "foo"};
//        new FindSubstring().findSubstring(s, words);
        out:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5;j++) {
                System.out.print("i = " + i + ", j = " + j);
                if (j == 2) {
                    System.out.println(" Hello");
                    continue out;
                }
                System.out.println(" World");
            }
        }


    }

}
