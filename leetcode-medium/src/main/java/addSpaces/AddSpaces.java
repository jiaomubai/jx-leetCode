package addSpaces;

import java.util.Random;

/**
 * @ClassName: AddSpaces
 * @Description: leetCode-2109: 向字符串添加空格
 * @Author: jiaoxian
 * @Date: 2025-03-31 21:35:39
 * @Version: 1.0
 **/

public class AddSpaces {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder ans = new StringBuilder(s.length() + spaces.length);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                stringBuilder.append(' ');
                j++;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {

        Random random = new Random();
        int randomNumber = 10000000 + random.nextInt(90000000); // 生成8位数字
        System.out.println(randomNumber);

        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {0};
        System.out.println(new AddSpaces().addSpaces(s, spaces));

    }

}
