package stringMatching;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoxian
 * @name stringMatching
 * @date 2023/5/10 15:00
 * @description leetCode-1408: 数组中的字符串匹配
 */
public class StringMatching {

    public List<String> stringMatching(String[] words) {
        List<String> resultList = new ArrayList<>();
        for (String wordi : words) {
            for (String wordj : words) {
                if (wordi.equals(wordj)) {
                    continue;
                }
                if (wordi.length() > wordj.length()) {
                    continue;
                }
                if (wordj.contains(wordi)) {
                    if (!resultList.contains(wordi)) {
                        resultList.add(wordi);
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] words = {"leetcode", "tc", "code", "ct"};
        List<String> resultList = new StringMatching().stringMatching(words);
        System.out.println(resultList.toString());
    }


}
