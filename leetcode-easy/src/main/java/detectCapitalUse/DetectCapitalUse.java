package detectCapitalUse;

/**
 * @ClassName: DetectCapitalUse
 * @Author: jiaoxian
 * @Date: 2022/4/29 10:01
 * @Description: leetCode-520: 检测大写字母
 */
public class DetectCapitalUse {

    public static boolean detectCapitalUse1(String word) {
        boolean flag = true;
        if (word.length() == 1) {
            return flag;
        }
        // 如果第一个字母为大写
        if (isUpperCase(word.charAt(0))) {
            // 如果第二个字母为大写
            if (isUpperCase(word.charAt(1))) {
                // 判断剩下的字母是否全为大写
                for (int i = 2; i < word.length(); i++) {
                    if (!isUpperCase(word.charAt(i))) {
                        // 如果有其中一个字母为小写,则结束循环,返回false
                        flag = false;
                        break;
                    }
                }
            } else {
                // 如果第二个字母为小写
                // 判断剩下的字母是否全为小写
                for (int i = 2; i < word.length(); i++) {
                    if (isUpperCase(word.charAt(i))) {
                        // 如果有其中一个字母为大写,则结束循环,返回false
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            // 如果第一个字母为小写
            // 判断剩余字母是否全为小写
            for (int i = 1; i < word.length(); i++) {
                if (isUpperCase(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static boolean isUpperCase(Character character) {
        return character >= 65 && character <= 90;
    }

    public static void main(String[] args) {
        String word = "GooGle";
        System.out.println(detectCapitalUse1(word));
    }

}
