package countSegments;

/**
 * @ClassName: CountSegments
 * @Author: jiaoxian
 * @Date: 2022/4/29 17:41
 * @Description: leetCode-434: 字符串中的单词数
 */
public class CountSegments {

    public static int countSegments(String s) {
        int result = 0;
        String[] strArray = s.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() != 0) {
                result++;
            }
        }
        return result;
    }

    private static boolean isBlank(Character character) {
        return character == 32;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("   hello   World"));
    }

}
