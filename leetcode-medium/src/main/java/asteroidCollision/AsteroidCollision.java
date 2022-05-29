package asteroidCollision;

import java.util.Stack;

/**
 * @ClassName: AsteroidCollision
 * @Author: jiaoxian
 * @Date: 2022/5/20 15:15
 * @Description: leetCode-735: 行星碰撞
 */
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            // 是否入栈标识, true-入栈, false-不入栈
            Boolean flag = true;
            // 如果栈不为空且当前元素为负数, 则判断
            while (!tempStack.isEmpty() && asteroids[i] < 0) {
                // 如果当前元素为负数且栈顶元素也为负数, 则 break 掉 while 循环, 当前元素入栈, 进行下一个元素的比较
                // 如果两个数都为负数, 永远也不会发生碰撞
                if (tempStack.peek() < 0) {
                    break;
                }
                // 如果栈顶元素的绝对值小于当前元素的绝对值, 则栈顶元素出栈, 表示栈顶元素已经被碰撞掉
                if (Math.abs(tempStack.peek()) < Math.abs(asteroids[i])) {
                    tempStack.pop();
                } else if (Math.abs(tempStack.peek()) > Math.abs(asteroids[i])) {
                    // 如果栈顶元素的绝对值大于当前元素的绝对值, 则 break 掉 while 循环, 表示当前元素已经被碰撞掉, 进行下一个元素的比较
                    flag = false;
                    break;
                } else {
                    // 如果栈顶元素的绝对值等于当前元素的绝对值, 则栈顶元素出栈, 同时 break 掉 while 循环, 表示栈顶元素和当前元素均被碰撞掉, 进行下一个元素的比较
                    tempStack.pop();
                    flag = false;
                    break;
                }
            }
            // 入栈
            if (flag) {
                tempStack.push(asteroids[i]);
            }
        }
        // 将栈中的元素倒序赋值, 返回
        int[] resultArray = new int[tempStack.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[resultArray.length - i - 1] = tempStack.pop();
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] asteroids = {-2, -1, 1, 2, -3, 4, 1};
        int[] result = asteroidCollision(asteroids);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%3d", result[i]);
        }
        System.out.println();
    }

}
