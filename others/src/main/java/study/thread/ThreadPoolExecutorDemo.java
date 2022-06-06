package study.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolExecutorDemo
 * @Author: jiaoxian
 * @Date: 2022/6/2 19:51
 * @Description:
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
            });
        }
    }

}
