package cQueue;

import java.util.Stack;

/**
 * @author jiaoxian
 * @name CQueue
 * @date 2022/12/14 13:47
 * @description leetCode-剑指 Offer 09: 用两个栈实现队列
 */
public class CQueue {

    public static Stack<Integer> stack1 = null;
    public static Stack<Integer> stack2 = null;

//    public LinkedList<Integer> linkedList = new LinkedList<>();

    public CQueue() {
        //初始化两个栈
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        // 尾插-入栈
        stack1.push(value);
//        linkedList.add(value);
    }

    public int deleteHead() {
        int value = 0;
        // 头删-出栈
        if (stack1.empty()) {
            return -1;
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.empty()) {
            return -1;
        } else {
            value = stack2.pop();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return value;

//        if (linkedList.isEmpty()) {
//            return -1;
//        }
//        return linkedList.pop();

    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
//        System.out.println(cQueue.deleteHead());
    }

}
