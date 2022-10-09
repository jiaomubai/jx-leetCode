package scoreOfParentheses;

import java.util.Stack;

/**
 * @ClassName: ScoreOfParentheses
 * @Description: leetCode-856: ���ŵķ���
 * @Author: jiaoxian
 * @Date: 2022/10/9 15:18
 **/
public class ScoreOfParentheses {

    // ����
    // ��������, һ��ƽ�������ַ��� s ���Ա��ֽ�Ϊ A + B �� (A) ����ʽ, ������ǿ��Զ� s ���зֽ�, �ֶ���֮.
    // ������ A + B �� (A) ��? �ٸ�����, "()()"-���������ַ����Ϳ������Ϊ�� A + B, Ϊʲô��? ����һ�¾�Ϊ "(A)(A)".
    // �� "(())"-���־�Ϊ A, ����һ�¾�Ϊ "((A))". ��ô�����, ����������������ַ�����һ������, ���� A ����ʽ, ��������ַ������Էֽ�Ļ�, ���� A + B.
    // ����ж� s Ӧ�÷ֽ�Ϊ A + B �� (A) ����һ����? ���ǽ������ż�Ϊ 1, �����ż�Ϊ ?1.
    // ��� s ��ĳ���ǿ�ǰ׺��Ӧ�ĺ� bal = 0, ����ƽ�������ַ������ԴӸ�λ�û���Ϊ A + B, �� "()()", ��ô���ǰ׺ "()" ����һ��ƽ�������ַ���.
    // �����ǰ׺���ȵ��� s �ĳ���, ��ô s ���Էֽ�Ϊ (A) ����ʽ, �� "()" �� "(())"; ���� s ���Էֽ�Ϊ A + B ����ʽ, ���� A Ϊ��ǰ׺.
    // �� s �ֽ�֮��, ���ǵݹ�����������, ���� s �ĳ���Ϊ 2 ʱ, �� "()" �ķ���Ϊ 1.

    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        // ǰ׺�͵ĳ���, �ж�ƽ�������ַ����Ƿ���Ա�����Ϊ A + B ����Ҫ��־
        int bal = 0;
        int n = s.length();
        // �ָ��ַ����ı�־λ
        int len = 0;
        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                // ��� bal ���� 0, �����Ի���Ϊ A + B, �� len λ�÷ָ�
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            // "()" �� "(())" --> (A) ���͵ķ������㷽ʽ
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            // "()()" --> A + B ���͵ķ������㷽ʽ
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }

    // ����ջ(ջ�ǽ���������������)
    // ���ǰ�ƽ���ַ��� s ������һ�����ַ������� s ����, ���Ҷ�����ַ����ķ���Ϊ 0.
    // ʹ��ջ stack ��¼ƽ���ַ����ķ���, �ڿ�ʼ֮ǰҪѹ����� 0, ��ʾ���ַ����ķ���.
    // �ڱ����ַ��� s �Ĺ�����: �������������, ��ô������Ҫ������������ڲ�����ƽ�������ַ��� A �ķ���, ����ҲҪ��ѹ����� 0, ��ʾ A ǰ��Ŀ��ַ����ķ���.
    // ����������, ˵�����������ڲ�����ƽ�������ַ��� A �ķ����Ѿ����������, ���ǽ�������ջ, �����浽���� temp ��.
    // ��� temp = 0, ��ô˵����ƽ�������ַ��� A �ǿմ�, (A) �ķ���Ϊ 1, ���� (A) �ķ���Ϊ 2 * temp, Ȼ�� (A) �ķ����ӵ�ջ��Ԫ����.
    // ����������, ջ��Ԫ�ر���ľ��� s �ķ���.

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

    // ͳ��ƽ�������ַ��������
    // ��������, s �ķ����� 1 �ֵ� () �й�.
    // ����ÿ�� (), �������շ�����������������й�, ������Ϊ deep, ��ô�������շ���Ϊ 2 �� deep �η�. �������ͳ������ () �����շ����ͼ���.

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
