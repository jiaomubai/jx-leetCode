package groupAnagrams;

import java.util.*;

/**
 * @ClassName: GroupAnagrams
 * @Description: leetCode-49: ��ĸ��λ�ʷ���
 * @Author: jiaoxian
 * @Date: 2022/9/27 10:54
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // ʹ�� hashMap ���洢ÿ�����ʵ���ĸ��λ���б�, key Ϊÿ�������������µ���, value ��Ϊ���µ��ʵ���ĸ��λ���б�
        // ��: "tea"��"eat"��"ate" ���������ʻ�Ϊ��ĸ��λ��, ������ͬ�� key Ϊ "aet"
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            // ���ַ���פ����ÿ�����ַ���ת�������鲢����
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // hashMap �� key Ϊ����֮��ĵ���
            String key = new String(charArray);
            // ��� hashMap ���Ѵ��ڴ� key, �򽫵�ǰ���� add �� value ��
            if (hashMap.containsKey(key)) {
                List<String> wordsList = hashMap.get(key);
                wordsList.add(str);
            } else {
                // ��� hashMap �в����ڴ� key, �� put
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
