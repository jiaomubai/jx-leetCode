package capitalizeTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CapitalizeTitle
 * @Description: leetCode-2129: ����������ĸ��д
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
                // �����ǰ�ַ�Ϊ�ո�, �����ʴ�Ž� wordList ��
                wordList.add(stringBuilder.toString());
                // �ָ� stringBuilder
                stringBuilder = new StringBuilder();
            }
        }
        if (stringBuilder.toString().length() > 0) {
            wordList.add(stringBuilder.toString());
        }
        StringBuilder result = new StringBuilder();
        // �������ʼ��� wordList
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            // ����ո�
            if (i != 0) {
                result.append(" ");
            }
            // ������ʵĳ���С�� 3, ��ȫ��ΪСд
            if (word.length() < 3) {
                result.append(word.toLowerCase());
            } else {
                // ������ʳ��ȴ��ڵ��� 3, ������ĸ��д, ������ĸСд
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
