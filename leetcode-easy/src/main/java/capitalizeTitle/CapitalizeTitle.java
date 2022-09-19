package capitalizeTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CapitalizeTitle
 * @Description: leetCode-2129: 将标题首字母大写
 * @Author: jiaoxian
 * @Date: 2022/9/19 15:47
 **/
public class CapitalizeTitle {

    public String capitalizeTitle(String title) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                // 如果当前字符为空格, 将单词存放进 wordList 中
                wordList.add(stringBuilder.toString());
                // 恢复 stringBuilder
                stringBuilder = new StringBuilder();
            }
        }
        if (stringBuilder.toString().length() > 0) {
            wordList.add(stringBuilder.toString());
        }
        StringBuilder result = new StringBuilder();
        // 遍历单词集合 wordList
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            // 处理空格
            if (i != 0) {
                result.append(" ");
            }
            // 如果单词的长度小于 3, 则全部为小写
            if (word.length() < 3) {
                result.append(word.toLowerCase());
            } else {
                // 如果单词长度大于等于 3, 则将首字母大写, 其余字母小写
                String firstChar = word.substring(0, 1);
                String othersChar = word.substring(1);
                result.append(firstChar.toUpperCase()).append(othersChar.toLowerCase());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CapitalizeTitle capitalizeTitle = new CapitalizeTitle();
        String title = "I lOvE tHe WorLD";
        System.out.println(capitalizeTitle.capitalizeTitle(title));
    }

}
