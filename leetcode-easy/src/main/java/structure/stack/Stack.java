package structure.stack;

/**
 * @ClassName: Stack
 * @Author: jiaomubai
 * @Date: 2022/1/30 14:55
 * @Description: 栈的出栈与入栈操作
 */
public class Stack {

    // 存储数据的数组
    private int[] dataArray;
    // 栈顶元素下标
    private int top;
    // 栈底元素下标
    private int bottom;

    public Stack(int capacity) {
        this.dataArray = new int[capacity];
    }

    /**
     * 入栈
     * @param element
     */
    public void push(Integer element) {
        System.out.println("入栈元素为:" + element);
        if (top == dataArray.length) {
            System.out.println("栈已满");
            return;
        }
        dataArray[top] = element;
        System.out.println("入栈之后栈顶元素为:" + dataArray[top]);
        System.out.println("入栈之后栈底元素为:" + dataArray[bottom]);
        top++;
        System.out.println();
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop() {
        if (top == bottom) {
            System.out.println("栈已空");
            return -1;
        }
        Integer popElement = dataArray[--top];
        System.out.println("出栈元素为:" + popElement);
        if (top == -1) {
            System.out.println("出栈之后栈顶元素为:" + null);
            System.out.println("出栈之后栈底元素为:" + null);
        } else {
            System.out.println("出栈之后栈顶元素为:" + dataArray[top]);
            System.out.println("出栈之后栈底元素为:" + dataArray[bottom]);
        }
        System.out.println();
        return popElement;
    }

    /**
     * 打印
     */
    public void print() {
        for (int i = 0; i < top - 1; i++) {
            System.out.print(dataArray[i] + " --> ");
        }
        if (top == 0) {
            System.out.println("空栈");
        } else {
            System.out.println(dataArray[top - 1]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println();
        stack.print();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();
    }

}
