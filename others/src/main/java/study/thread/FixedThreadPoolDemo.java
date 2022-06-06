package study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: FixedThreadPoolDemo
 * @Author: jiaoxian
 * @Date: 2022/6/1 18:29
 * @Description:
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {

        // 创建 2 个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        // 创建任务
        Runnable runnable = () -> System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
        // 线程池执行任务(一次添加 8 个任务)
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
        threadPool.execute(runnable);
    }

}
