package findWordsContaining;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindWordsContaining
 * @Description: leetCode-2942:查找包含给定字符的单词
 * @Author: jiaoxian
 * @Date: 2025-05-24 16:01:36
 * @Version: 1.0
 **/

public class FindWordsContaining {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"leet", "code"};
        System.out.println(new FindWordsContaining().findWordsContaining(words, 'e'));
    }

}
