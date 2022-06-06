package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CachedThreadPoolDemo
 * @Author: jiaoxian
 * @Date: 2022/6/1 18:45
 * @Description:
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {

        // 创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 执行任务
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
            });
        }
    }

}
