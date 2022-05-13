package longestValidParentheses;

import java.util.Stack;

/**
 * @ClassName: LongestValidParentheses
 * @Author: jiaoxian
 * @Date: 2022/5/13 10:19
 * @Description: leetCode-32: 最长有效括号
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        Stack<Integer> invalidParenthesesIndexStack = new Stack<Integer>();
        invalidParenthesesIndexStack.push(-1);
        for (int i = 0; i < charArray.length; i++) {
            // 如果是 ')', 并且栈顶元素对应的数据为 '(', 并且栈中至少有两个元素, 则将栈顶元素出栈
            if (charArray[i] == ')' && invalidParenthesesIndexStack.size() > 1 && charArray[invalidParenthesesIndexStack.peek()] == '(') {
                invalidParenthesesIndexStack.pop();
            } else {
                invalidParenthesesIndexStack.push(i);
            }
        }
        int result = 0;
        if (invalidParenthesesIndexStack.peek() != s.length() - 1) {
            result = s.length() - 1 - invalidParenthesesIndexStack.peek();
        }
        // 遍历栈
        if (invalidParenthesesIndexStack.size() == 1) {
            return s.length();
        }
        if (invalidParenthesesIndexStack.size() > 1) {
            for (int i = 1; i < invalidParenthesesIndexStack.size(); i++) {
                result = Math.max(result, invalidParenthesesIndexStack.get(i) - invalidParenthesesIndexStack.get(i - 1) - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = ")()()(()";
        System.out.println("字符串为:" + s);
        int result = longestValidParentheses(s);
        System.out.println("最长有效括号为:" + result);
    }

}
