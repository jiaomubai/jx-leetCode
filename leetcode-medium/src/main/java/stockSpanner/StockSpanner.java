package stockSpanner;

import java.util.*;

/**
 * @ClassName: StockSpanner
 * @Description: leetCode-901: ��Ʊ�۸���
 * @Author: jiaoxian
 * @Date: 2022/10/21 10:20
 **/
public class StockSpanner {

    private Stack<int[]> stack;

    private int idx;

    public StockSpanner() {
        stack = new Stack<>();
        // ��ʼ��ջ(�����Ϊջ�д���Ǽ�ֵ��, idx λ�ô���� price Ԫ��)
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            // ��ջ
            stack.pop();
        }
        int result = idx - stack.peek()[0];
        // �±�Ϊ idx ��λ�ô���� price
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
