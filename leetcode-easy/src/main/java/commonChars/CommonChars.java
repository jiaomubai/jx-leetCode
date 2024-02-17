package commonChars;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoxian
 * @name commonChars
 * @date 2023/5/15 14:16
 * @description leetCode-1002: 查找共用字符
 */
public class CommonChars {

    public List<String> commonChars(String[] words) {
        List<String> resultList = new ArrayList<>();
        String firstWord = words[0];
        out:for (int i = 0; i < firstWord.length(); i++) {
            String temp = String.valueOf(firstWord.charAt(i));
            for (int j = 1; j < words.length; j++) {
                    if (words[j].contains(temp)) {
                        words[j] = words[j].replaceFirst(temp, "");
                    } else {
                        continue out;
                    }
            }
            resultList.add(temp);
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] words = {"cool","lock","cook"};
        System.out.println(new CommonChars().commonChars(words));
    }

}
