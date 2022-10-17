package equalFrequency;

import java.util.*;

/**
 * @ClassName: EqualFrequency
 * @Description: leetCode-2423: ɾ���ַ�ʹƵ����ͬ
 * @Author: jiaoxian
 * @Date: 2022/10/11 11:26
 **/
public class EqualFrequency {

    public boolean equalFrequency(String word) {
        int length = word.length();
        // ��¼��ĸ����Ƶ�εĹ�ϵ
        Map<Character, Integer> charToFrequencyMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character key = word.charAt(i);
            charToFrequencyMap.put(key, charToFrequencyMap.getOrDefault(key, 0) + 1);
        }
        // charToFrequencyMap �� key �� value ��ת, ��¼Ƶ�������Ӧ����ĸ
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
        // word ��ÿ����ĸ���ֵ�Ƶ�ζ�һ��, "a"��"aa"��"aaabbb"��"aabbcc"��"abcd"
        if (frequencyToCharMap.size() == 1) {
            for (Map.Entry<Integer, List<Character>> entry : frequencyToCharMap.entrySet()) {
                if (entry.getKey() == 1) {
                    // ������е���ĸ��ֻ������һ��, "abcd"��"a"
                    return true;
                } else {
                    // ��ĸ������ 2 �μ�����, "aa"��"aaabbb"��"aabbcc"
                    if (entry.getValue().size() == 1) {
                        // ͬһ����ĸ�����˶��, "aa"
                        return true;
                    } else {
                        // �����ĸ�����˶��, "aaabbb"��"aabbcc"
                        return false;
                    }
                }
            }
        }
        // word �е���ĸ������Ƶ��, "abbb"��"aabbc"��"aabbcccddd"
        if (frequencyToCharMap.size() == 2) {
            // ��¼����Ƶ��
            int[] keyCountArray = new int[2];
            int i = 0;
            for (Map.Entry<Integer, List<Character>> entry : frequencyToCharMap.entrySet()) {
                keyCountArray[i++] = entry.getKey();
            }
            // keyCountArray[0] Ƶ�ν�С��, keyCountArray[1] Ƶ�νϴ���
            Arrays.sort(keyCountArray);
            // �������Ƶ�ε�ֵ��� 1 , "aab"��"aabbc"��"abccddee"
            if (keyCountArray[1] - keyCountArray[0] == 1) {
                // ��������һ��Ƶ�ζ�Ӧ����ĸ����Ϊ 1, "aab"��"aabbc"
                if (frequencyToCharMap.get(keyCountArray[1]).size() == 1) {
                    return true;
                }
            }
            if (keyCountArray[0] == 1 && frequencyToCharMap.get(keyCountArray[0]).size() == 1) {
                // Ƶ�ν�С�ߵ��� 1, "abbb"
                return true;
            }
            // "aabbbb"
            return false;
        }
        // ��� frequencyToCharMap �Ĵ�С���� 2, ������ 3 ����ͬƵ�ε���ĸ, ��"abbccc"
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
