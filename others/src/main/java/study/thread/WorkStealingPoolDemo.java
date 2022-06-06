package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: WorkStealingPoolDemo
 * @Author: jiaoxian
 * @Date: 2022/6/2 09:51
 * @Description:
 */
public class WorkStealingPoolDemo {

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = Executors.newWorkStealingPool();
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
            });
        }
        // 确保任务执行完成
        while (!threadPool.isTerminated()) {
        }
    }

}
