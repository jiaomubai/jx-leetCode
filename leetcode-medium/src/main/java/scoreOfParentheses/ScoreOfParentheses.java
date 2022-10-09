package scoreOfParentheses;

import java.util.Stack;

/**
 * @ClassName: ScoreOfParentheses
 * @Description: leetCode-856: 括号的分数
 * @Author: jiaoxian
 * @Date: 2022/10/9 15:18
 **/
public class ScoreOfParentheses {

    // 分治
    // 根据题意, 一个平衡括号字符串 s 可以被分解为 A + B 或 (A) 的形式, 因此我们可以对 s 进行分解, 分而治之.
    // 如何理解 A + B 和 (A) 呢? 举个例子, "()()"-这种括号字符串就可以理解为是 A + B, 为什么呢? 变形一下就为 "(A)(A)".
    // 像 "(())"-这种就为 A, 变形一下就为 "((A))". 怎么理解呢, 就是如果整个括号字符串是一个整体, 就是 A 的形式, 如果括号字符串可以分解的话, 就是 A + B.
    // 如何判断 s 应该分解为 A + B 或 (A) 的哪一种呢? 我们将左括号记为 1, 右括号记为 ?1.
    // 如果 s 的某个非空前缀对应的和 bal = 0, 即该平衡括号字符串可以从该位置划分为 A + B, 如 "()()", 那么这个前缀 "()" 就是一个平衡括号字符串.
    // 如果该前缀长度等于 s 的长度, 那么 s 可以分解为 (A) 的形式, 如 "()" 或 "(())"; 否则 s 可以分解为 A + B 的形式, 其中 A 为该前缀.
    // 将 s 分解之后, 我们递归地求解子问题, 并且 s 的长度为 2 时, 即 "()" 的分数为 1.

    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        // 前缀和的长度, 判断平衡括号字符串是否可以被划分为 A + B 的重要标志
        int bal = 0;
        int n = s.length();
        // 分割字符串的标志位
        int len = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                // 如果 bal 等于 0, 即可以划分为 A + B, 从 len 位置分割
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            // "()" 或 "(())" --> (A) 类型的分数计算方式
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            // "()()" --> A + B 类型的分数计算方式
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }

    // 借助栈(栈是解决括号问题的利器)
    // 我们把平衡字符串 s 看作是一个空字符串加上 s 本身, 并且定义空字符串的分数为 0.
    // 使用栈 stack 记录平衡字符串的分数, 在开始之前要压入分数 0, 表示空字符串的分数.
    // 在遍历字符串 s 的过程中: 如果遇到左括号, 那么我们需要计算该左括号内部的子平衡括号字符串 A 的分数, 我们也要先压入分数 0, 表示 A 前面的空字符串的分数.
    // 遇到右括号, 说明该右括号内部的子平衡括号字符串 A 的分数已经计算出来了, 我们将它弹出栈, 并保存到变量 temp 中.
    // 如果 temp = 0, 那么说明子平衡括号字符串 A 是空串, (A) 的分数为 1, 否则 (A) 的分数为 2 * temp, 然后将 (A) 的分数加到栈顶元素上.
    // 遍历结束后, 栈顶元素保存的就是 s 的分数.

    public int scoreOfParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int temp = stack.pop();
                int top = stack.pop() + Math.max(2 * temp, 1);
                stack.push(top);
            }
        }
        return stack.peek();
    }

    // 统计平衡括号字符串的深度
    // 根据题意, s 的分数与 1 分的 () 有关.
    // 对于每个 (), 它的最终分数与它所处的深度有关, 如果深度为 deep, 那么它的最终分数为 2 的 deep 次方. 因此我们统计所有 () 的最终分数和即可.

    public int scoreOfParentheses3(String s) {
        int deep = 0;
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            deep += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                result += 1 << deep;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        System.out.println(scoreOfParentheses.scoreOfParentheses3("(()(()))"));
    }

}
