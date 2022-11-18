package mixingOperation;

import java.util.Stack;

public class MixingOperation {

    public static int mixingOperation(String infixExpression) {
        System.out.println("ԭʼ��׺���ʽΪ: " + infixExpression);
        // 1. ���������ź�С����
        String newInfixExpression = handlerParentheses(infixExpression);
        System.out.println("�������ź���µ���׺���ʽΪ: " + newInfixExpression);
        // 2. ��׺���ʽת��Ϊ��׺���ʽ
        String[] postfixExpressionArray = transformExpression(newInfixExpression);
        StringBuffer postfixExpressionBuffer = new StringBuffer();
        for (int i = 0; i < postfixExpressionArray.length; i++) {
            if (null == postfixExpressionArray[i] || postfixExpressionArray[i].isEmpty()) {
                break;
            }
            postfixExpressionBuffer.append(postfixExpressionArray[i]).append(" ");
        }
        System.out.println("��׺���ʽΪ: " + postfixExpressionBuffer.toString());
        // ��׺���ʽ��ֵ
        int result = calculateResultByPostfixExpression(postfixExpressionArray);
        System.out.println("���ʽ: " + infixExpression + " = " + result);
        return 0;
    }

    private static int calculateResultByPostfixExpression(String[] postfixExpressionArray) {
        // �������������ջ
        Stack<String> calculateStack = new Stack<>();
        // ������׺���ʽ����
        for (int i = 0; i < postfixExpressionArray.length; i++) {
            if (null == postfixExpressionArray[i] || postfixExpressionArray[i].isEmpty()) {
                break;
            }
            String currentStr = postfixExpressionArray[i];
            switch (currentStr) {
                // ����������, ��ջ��Ԫ����Ϊ�ڶ�������������ջ, Ȼ���µ�ջ��Ԫ����Ϊ��һ������������ջ,
                // Ȼ��ʹ�� ������1���������������2 ��������, ���������ջ
                case "+" :
                case "-" :
                case "*" :
                case "/" :
                    if (!calculateStack.empty()) {
                        // ջ��Ԫ����Ϊ������2����ջ
                        int operand2 = Integer.valueOf(calculateStack.pop());
                        // �µ�ջ��Ԫ����Ϊ������1
                        int operand1 = Integer.valueOf(calculateStack.pop());
                        // ������
                        int result = calculateResult(operand1, currentStr, operand2);
                        // �������ջ
                        calculateStack.push(String.valueOf(result));
                    }
                    break;
                default:
                    // ����ǲ�����, ��ֱ����ջ
                    calculateStack.push(currentStr);
            }

        }
        // �������֮�����ջ��Ԫ�ؼ�Ϊ���ս��
        return Integer.valueOf(calculateStack.pop());
    }

    private static int calculateResult(int operand1, String currentStr, int operand2) {
        int result = 0;
        switch (currentStr) {
            case "+" :
                result =  operand1 + operand2;
                break;
            case "-" :
                result =  operand1 - operand2;
                break;
            case "*" :
                result =  operand1 * operand2;
                break;
            case "/" :
                if (operand2 == 0) {
                    return 0;
                }
                result =  operand1 / operand2;
                break;
            default:
        }
        return result;
    }

    private static String[] transformExpression(String newInfixExpression) {
        // �����ջ
        Stack<String> operatorStack = new Stack<>();
        // ������������
        StringBuffer tempOperandBuffer = new StringBuffer();
        // ��׺���ʽ
        String postfixExpression = null;
        // ��׺���ʽ����
        String[] postExpressionArray = new String[newInfixExpression.length()];
        // �����±�
        int index = 0;
        // �洢����ı�ʶ
        boolean flag = false;

        // ������׺���ʽ
        for (int i = 0; i < newInfixExpression.length(); i++) {
            // ��ǰ�ַ�ת��Ϊ�ַ���, �洢ջ
            String currentStr = String.valueOf(newInfixExpression.charAt(i));
//            System.out.println("��ǰ�ַ�Ϊ: " + currentStr);
            switch (currentStr) {
                // ����ǼӺ���������߼��������
                // ����ת������, ���жϵ�ǰ�������ջ��Ԫ������������ȼ�, ������ǰ�������ջ
                case "+":
                case "-":
                    // ջ��Ԫ��������������� "(", �����γ�ջ�����
                    while (!operatorStack.empty()) {
                        if (!"(".equals(operatorStack.peek())) {
                            postExpressionArray[index++] = operatorStack.peek();
                            operatorStack.pop();
                        } else {
                            break;
                        }
                    }
                    // �������ս���߼�����ջΪ��, �򽫵�ǰ�������ջ
                    operatorStack.push(currentStr);
                    flag = true;
                    break;

                // ����ǳ˺���������߳��������
                // ����ת������, ���жϵ�ǰ�������ջ��Ԫ������������ȼ�, ������ǰ�������ջ
                case "*":
                case "/":
                    while (!operatorStack.empty()) {
                        // ���ջ��Ԫ�ص����ȼ��뵱ǰ����������ȼ���ͬ, ��ջ��Ԫ��Ϊ "*" �� "/", ��ջ��Ԫ�س�ջ�����
                        if ("*".equals(operatorStack.peek()) || "/".equals(operatorStack.peek())) {
                            postExpressionArray[index++] = operatorStack.peek();
                            operatorStack.pop();
                        } else {
                            break;
                        }
                    }
                    operatorStack.push(currentStr);
                    flag = true;
                    break;

                // �����������, ֱ����ջ
                case "(":
                    operatorStack.push(currentStr);
                    flag = true;
                    break;

                // �����������, ��ƥ��������
                case ")":
                    while (!operatorStack.empty()) {
                        if (!tempOperandBuffer.toString().isEmpty()) {
                            postExpressionArray[index++] = tempOperandBuffer.toString();
                            tempOperandBuffer = new StringBuffer();
                            flag = false;
                        }
                        // ������ջ��Ԫ�������������֮ǰ�������ȫ����ջ�����, ����������Ҳ���
                        if (!"(".equals(operatorStack.peek())) {
                            postExpressionArray[index++] = operatorStack.peek();
                            operatorStack.pop();
                        } else {
                            operatorStack.pop();
                            break;
                        }
                    }
                    break;

                // ���������, ��ֱ�Ӽ�¼����׺���ʽ��������
                default:
                    if (flag) {
                        if (!tempOperandBuffer.toString().isEmpty()) {
                            postExpressionArray[index++] = tempOperandBuffer.toString();
                        }
                        tempOperandBuffer = new StringBuffer(currentStr);
                        flag = false;
                    } else {
                        tempOperandBuffer.append(currentStr);
                    }
            }
        }
        // ���������������������
        if (!tempOperandBuffer.toString().isEmpty()) {
            postExpressionArray[index++] = tempOperandBuffer.toString();
        }
        // ��������׺���ʽ֮��, ��ջ��Ԫ���������
        while (!operatorStack.empty()) {
            postExpressionArray[index++] = operatorStack.peek();
            operatorStack.pop();
        }
        return postExpressionArray;
    }

    private static String handlerParentheses(String infixExpression) {
        return infixExpression.replace("[", "(")
                .replace("]", ")").replace("{", "(")
                .replace("}", ")");
    }

    public static void main(String[] args) {
//        String infixExpression = "6*8";
        String infixExpression = "800/{5*[(34+46)/8]}";
        mixingOperation(infixExpression);
    }

}
