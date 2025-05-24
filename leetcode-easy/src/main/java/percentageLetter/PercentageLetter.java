package percentageLetter;

/**
 * @ClassName: PercentageLetter
 * @Description: leetCode-2278:字母在字符串中的百分比
 * @Author: jiaoxian
 * @Date: 2025-03-31 21:07:55
 * @Version: 1.0
 **/

public class PercentageLetter {

    public int percentageLetter(String s, char letter) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        result = count * 100 / s.length();
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(new PercentageLetter().percentageLetter("foobar", 'o'));
    }

}
