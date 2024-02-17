package rotateString;

/**
 * @author jiaoxian
 * @name rotateString
 * @date 2023/6/2 16:21
 * @description leetCode-796: Ðý×ª×Ö·û´®
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder stringBuilder = new StringBuilder(s.substring(i + 1)).append(s.substring(0, i + 1));
            if (stringBuilder.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "deabc";
        System.out.println(new RotateString().rotateString(s, goal));
    }

}
