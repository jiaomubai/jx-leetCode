package findTheWinner;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: FindTheWinner
 * @Author: jiaoxian
 * @Date: 2022/6/6 19:14
 * @Description: leetCode-1823: 找出游戏的获胜者
 */
public class FindTheWinner {

    public int findTheWinner(int n, int k) {
        // 初始化队列
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; ++i) {
            queue.add(i);
        }
        // 计数器
        int tmp = k;
        // 剩余1位小伙伴则停止循环
        while (queue.size() > 1) {
            int num = queue.poll();
            if (--tmp != 0){
                // 不是当次的输家，从新入队
                queue.add(num);
            } else {
                // 重置计数器
                tmp = k;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        FindTheWinner findTheWinner = new FindTheWinner();
        System.out.println(findTheWinner.findTheWinner(5, 2));
    }

}
