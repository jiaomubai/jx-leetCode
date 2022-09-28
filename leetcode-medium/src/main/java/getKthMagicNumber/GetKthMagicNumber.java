package getKthMagicNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: GetKthMagicNumber
 * @Description: leetCode-面试题 17.09: 第 K 个数
 * @Author: jiaoxian
 * @Date: 2022/9/28 9:44
 **/
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        // set 用来给元素去重
        Set<Long> set = new HashSet<Long>();
        // 使用优先队列实现最小堆, 来存储满足条件的数
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        // 将 1 入队
        heap.offer(1L);
        // 记录结果
        int result = 0;
        for (int i = 0; i < k; i++) {
            // 堆顶元素 curr 为当前堆中最小的数
            long curr = heap.poll();
            result = (int) curr;
            // 堆顶元素 curr 满足条件, 则 curr * 3、curr * 5、k * 7 也是满足条件的, 因此进行入队操作
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        System.out.println(getKthMagicNumber.getKthMagicNumber(5));
    }

}
