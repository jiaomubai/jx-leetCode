package equalFrequency;

import java.util.*;

/**
 * @ClassName: EqualFrequency
 * @Description: leetCode-2423: 删除字符使频率相同
 * @Author: jiaoxian
 * @Date: 2022/10/11 11:26
 **/
public class EqualFrequency {

    public boolean equalFrequency(String word) {
        int length = word.length();
        // 记录字母与其频次的关系
        Map<Character, Integer> charToFrequencyMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character key = word.charAt(i);
            charToFrequencyMap.put(key, charToFrequencyMap.getOrDefault(key, 0) + 1);
        }
        // charToFrequencyMap 的 key 和 value 反转, 记录频次与其对应的字母
        Map<Integer, List<Character>> frequencyToCharMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : charToFrequencyMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (frequencyToCharMap.containsKey(value)) {
                List<Character> list = frequencyToCharMap.get(value);
                list.add(key);
                frequencyToCharMap.put(value, list);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(key);
                frequencyToCharMap.put(value, list);
            }
        }
        // word 中每个字母出现的频次都一样, "a"、"aa"、"aaabbb"、"aabbcc"、"abcd"
        if (frequencyToCharMap.size() == 1) {
            for (Map.Entry<Integer, List<Character>> entry : frequencyToCharMap.entrySet()) {
                if (entry.getKey() == 1) {
                    // 如果所有的字母都只出现了一次, "abcd"、"a"
                    return true;
                } else {
                    // 字母出现了 2 次及以上, "aa"、"aaabbb"、"aabbcc"
                    if (entry.getValue().size() == 1) {
                        // 同一个字母出现了多次, "aa"
                        return true;
                    } else {
                        // 多个字母出现了多次, "aaabbb"、"aabbcc"
                        return false;
                    }
                }
            }
        }
        // word 中的字母有两种频次, "abbb"、"aabbc"、"aabbcccddd"
        if (frequencyToCharMap.size() == 2) {
            // 记录两种频次
            int[] keyCountArray = new int[2];
            int i = 0;
            for (Map.Entry<Integer, List<Character>> entry : frequencyToCharMap.entrySet()) {
                keyCountArray[i++] = entry.getKey();
            }
            // keyCountArray[0] 频次较小者, keyCountArray[1] 频次较大者
            Arrays.sort(keyCountArray);
            // 如果两种频次的值相差 1 , "aab"、"aabbc"、"abccddee"
            if (keyCountArray[1] - keyCountArray[0] == 1) {
                // 且其中有一个频次对应的字母数量为 1, "aab"、"aabbc"
                if (frequencyToCharMap.get(keyCountArray[1]).size() == 1) {
                    return true;
                }
            }
            if (keyCountArray[0] == 1 && frequencyToCharMap.get(keyCountArray[0]).size() == 1) {
                // 频次较小者等于 1, "abbb"
                return true;
            }
            // "aabbbb"
            return false;
        }
        // 如果 frequencyToCharMap 的大小大于 2, 即存在 3 个不同频次的字母, 如"abbccc"
        if (frequencyToCharMap.size() > 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EqualFrequency equalFrequency = new EqualFrequency();
        String word = "abeeee";
        System.out.println(equalFrequency.equalFrequency(word));
    }

}
