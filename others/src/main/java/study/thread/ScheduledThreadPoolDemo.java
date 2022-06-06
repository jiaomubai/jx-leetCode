package study.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ScheduledThreadPoolDemo
 * @Author: jiaoxian
 * @Date: 2022/6/2 09:35
 * @Description:
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        // 创建线程池
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        // 添加定时执行任务(1s 后执行)
        System.out.println("添加任务,时间:" + new Date());
        threadPool.schedule(() -> {
            System.out.println("任务被执行,时间:" + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, TimeUnit.SECONDS);
    }

}
