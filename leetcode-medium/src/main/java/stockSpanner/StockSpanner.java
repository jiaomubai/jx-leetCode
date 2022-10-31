package stockSpanner;

import java.util.*;

/**
 * @ClassName: StockSpanner
 * @Description: leetCode-901: 股票价格跨度
 * @Author: jiaoxian
 * @Date: 2022/10/21 10:20
 **/
public class StockSpanner {

    private Stack<int[]> stack;

    private int idx;

    public StockSpanner() {
        stack = new Stack<>();
        // 初始化栈(可理解为栈中存的是键值对, idx 位置存的是 price 元素)
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            // 弹栈
            stack.pop();
        }
        int result = idx - stack.peek()[0];
        // 下标为 idx 的位置存的是 price
        stack.push(new int[]{idx, price});
        return result;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

}
