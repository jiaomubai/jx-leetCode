package removeOuterParentheses;

/**
 * @ClassName: RemoveOuterParentheses
 * @Author: jiaoxian
 * @Date: 2022/5/28 00:39
 * @Description: leetCode-1021: 删除最外层的括号
 */
public class RemoveOuterParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count == 1) {
                    continue;
                }
            } else {
                count--;
                if (count == 0) {
                    continue;
                }
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "(())(()())";
        String result = removeOuterParentheses(s);
        System.out.println(result);
    }

}
