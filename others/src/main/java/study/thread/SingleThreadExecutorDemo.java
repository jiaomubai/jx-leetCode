package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SingleThreadExecutorDemo
 * @Author: jiaoxian
 * @Date: 2022/6/1 19:57
 * @Description:
 */
public class SingleThreadExecutorDemo {

    public static void main(String[] args) {

        // 创建线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 执行任务
        for (int i = 0; i < 10; i++) {
            int index = i;
            threadPool.execute(() -> {
                System.out.println(index + ": 任务被执行: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
