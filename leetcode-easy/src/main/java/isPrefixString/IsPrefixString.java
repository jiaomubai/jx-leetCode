package isPrefixString;

/**
 * @author jiaoxian
 * @name isPrefixString
 * @date 2023/5/10 16:43
 * @description leetCode-1961: 检查字符串是否为数组前缀
 */
public class IsPrefixString {

    public boolean isPrefixString(String s, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                s = s.substring(words[i].length());
            } else {
                if (s.length() == 0) {
                    return true;
                }
                return false;
            }
        }
        if (s.length() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ccccccccc";
        String[] words = {"c", "cc"};
        System.out.println(new IsPrefixString().isPrefixString(s, words));
    }

}
