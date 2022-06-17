package study.thread;

import java.util.stream.Stream;

/**
 * @ClassName: SleepDemo
 * @Author: jiaoxian
 * @Date: 2022/6/11 15:27
 * @Description:
 */
public class SleepDemo {

//    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        Stream.of("线程1", "线程2").forEach(a -> new Thread(a) {
            @Override
            public void run() {
                new SleepDemo().testSleep();
            }
        }.start());
    }

    private void testSleep() {
//        synchronized (LOCK) {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行: " + System.currentTimeMillis() / 1000);
                // 休眠 2 s
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "恢复执行: " + System.currentTimeMillis() / 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
//        }
    }

}
