package groupAnagrams;

import java.util.*;

/**
 * @ClassName: GroupAnagrams
 * @Description: leetCode-49: 字母异位词分组
 * @Author: jiaoxian
 * @Date: 2022/9/27 10:54
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 使用 hashMap 来存储每个单词的字母异位词列表, key 为每个单词排序后的新单词, value 即为该新单词的字母异位词列表
        // 如: "tea"、"eat"、"ate" 这三个单词互为字母异位词, 它们相同的 key 为 "aet"
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            // 将字符串驻足中每个子字符串转换成数组并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // hashMap 的 key 为排序之后的单词
            String key = new String(charArray);
            // 如果 hashMap 中已存在此 key, 则将当前单词 add 到 value 中
            if (hashMap.containsKey(key)) {
                List<String> wordsList = hashMap.get(key);
                wordsList.add(str);
            } else {
                // 如果 hashMap 中不存在此 key, 则 put
                List<String> wordsList = new ArrayList<>();
                wordsList.add(str);
                hashMap.put(key, wordsList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"ate", "eat", "tea", "ban", "cat", "dog", "girl"};
        List<List<String>> resultList = groupAnagrams.groupAnagrams(strs);
        System.out.println();
    }

}
