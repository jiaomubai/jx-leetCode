package mixingOperation;

import java.util.Stack;

public class MixingOperation {

    public static int mixingOperation(String infixExpression) {
        System.out.println("原始中缀表达式为: " + infixExpression);
        // 1. 处理中括号和小括号
        String newInfixExpression = handlerParentheses(infixExpression);
        System.out.println("处理括号后的新的中缀表达式为: " + newInfixExpression);
        // 2. 中缀表达式转换为后缀表达式
        String[] postfixExpressionArray = transformExpression(newInfixExpression);
        StringBuffer postfixExpressionBuffer = new StringBuffer();
        for (int i = 0; i < postfixExpressionArray.length; i++) {
            if (null == postfixExpressionArray[i] || postfixExpressionArray[i].isEmpty()) {
                break;
            }
            postfixExpressionBuffer.append(postfixExpressionArray[i]).append(" ");
        }
        System.out.println("后缀表达式为: " + postfixExpressionBuffer.toString());
        // 后缀表达式求值
        int result = calculateResultByPostfixExpression(postfixExpressionArray);
        System.out.println("表达式: " + infixExpression + " = " + result);
        return 0;
    }

    private static int calculateResultByPostfixExpression(String[] postfixExpressionArray) {
        // 运算符和运算数栈
        Stack<String> calculateStack = new Stack<>();
        // 遍历中缀表达式数组
        for (int i = 0; i < postfixExpressionArray.length; i++) {
            if (null == postfixExpressionArray[i] || postfixExpressionArray[i].isEmpty()) {
                break;
            }
            String currentStr = postfixExpressionArray[i];
            switch (currentStr) {
                // 如果是运算符, 将栈顶元素作为第二个操作数并出栈, 然后新的栈顶元素作为第一个操作数并出栈,
                // 然后使用 操作数1、运算符、操作数2 进行运算, 并将结果入栈
                case "+" :
                case "-" :
                case "*" :
                case "/" :
                    if (!calculateStack.empty()) {
                        // 栈顶元素作为操作数2并出栈
                        int operand2 = Integer.valueOf(calculateStack.pop());
                        // 新的栈顶元素作为操作数1
                        int operand1 = Integer.valueOf(calculateStack.pop());
                        // 计算结果
                        int result = calculateResult(operand1, currentStr, operand2);
                        // 将结果入栈
                        calculateStack.push(String.valueOf(result));
                    }
                    break;
                default:
                    // 如果是操作数, 则直接入栈
                    calculateStack.push(currentStr);
            }

        }
        // 处理完成之后输出栈顶元素即为最终结果
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
        // 运算符栈
        Stack<String> operatorStack = new Stack<>();
        // 操作数缓冲区
        StringBuffer tempOperandBuffer = new StringBuffer();
        // 后缀表达式
        String postfixExpression = null;
        // 后缀表达式数组
        String[] postExpressionArray = new String[newInfixExpression.length()];
        // 数组下标
        int index = 0;
        // 存储数组的标识
        boolean flag = false;

        // 遍历中缀表达式
        for (int i = 0; i < newInfixExpression.length(); i++) {
            // 当前字符转换为字符串, 存储栈
            String currentStr = String.valueOf(newInfixExpression.charAt(i));
//            System.out.println("当前字符为: " + currentStr);
            switch (currentStr) {
                // 如果是加号运算符或者减号运算符
                // 根据转换规则, 需判断当前运算符与栈顶元素运算符的优先级, 并将当前运算符入栈
                case "+":
                case "-":
                    // 栈顶元素如果不是左括号 "(", 则依次出栈并输出
                    while (!operatorStack.empty()) {
                        if (!"(".equals(operatorStack.peek())) {
                            postExpressionArray[index++] = operatorStack.peek();
                            operatorStack.pop();
                        } else {
                            break;
                        }
                    }
                    // 处理完出战的逻辑或者栈为空, 则将当前运算符入栈
                    operatorStack.push(currentStr);
                    flag = true;
                    break;

                // 如果是乘号运算符或者除号运算符
                // 根据转换规则, 需判断当前运算符与栈顶元素运算符的优先级, 并将当前运算符入栈
                case "*":
                case "/":
                    while (!operatorStack.empty()) {
                        // 如果栈顶元素的优先级与当前运算符的优先级相同, 即栈顶元素为 "*" 或 "/", 则栈顶元素出栈并输出
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

                // 如果是左括号, 直接入栈
                case "(":
                    operatorStack.push(currentStr);
                    flag = true;
                    break;

                // 如果是右括号, 则匹配左括号
                case ")":
                    while (!operatorStack.empty()) {
                        if (!tempOperandBuffer.toString().isEmpty()) {
                            postExpressionArray[index++] = tempOperandBuffer.toString();
                            tempOperandBuffer = new StringBuffer();
                            flag = false;
                        }
                        // 将距离栈顶元素最近的左括号之前的运算符全部出栈并输出, 并将左括号也输出
                        if (!"(".equals(operatorStack.peek())) {
                            postExpressionArray[index++] = operatorStack.peek();
                            operatorStack.pop();
                        } else {
                            operatorStack.pop();
                            break;
                        }
                    }
                    break;

                // 如果是数字, 则直接记录进后缀表达式缓冲区中
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
        // 处理操作数缓冲区的内容
        if (!tempOperandBuffer.toString().isEmpty()) {
            postExpressionArray[index++] = tempOperandBuffer.toString();
        }
        // 遍历完中缀表达式之后, 将栈中元素依次输出
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
