package isValid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: IsValid
 * @Author: jiaomubai
 * @Date: 2021/9/13 10:13
 * @Description: 有效的括号, LeetCode 题库第20题
 */
public class IsValid {

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        int length = s.length() / 2;
        while (length > 0) {
            s = s.replace("{}", "").replace("[]", "").replace("()", "");
            length --;
            //System.out.println(s);
        }
        return s.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.empty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        boolean result = isValid2("{[()]}");
        System.out.println("result = " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

}
