package uncommonFromSentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaoxian
 * @name uncommonFromSentences
 * @date 2023/10/7 15:54
 * @description leetCode-884: 两句话中的不常见单词
 */
public class UncommonFromSentences {

    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> listResult = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] s1Array = s1.split(" ");
        for (int i = 0; i < s1Array.length; i++) {
            String key = s1Array[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        String[] s2Array = s2.split(" ");
        for (int i = 0; i < s2Array.length; i++) {
            String key = s2Array[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                listResult.add(entry.getKey());
            }
        }
        String[] result = listResult.toArray(new String[0]);
        return result;
    }

}
