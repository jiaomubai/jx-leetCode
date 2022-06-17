package study.thread;

import java.util.stream.Stream;

/**
 * @ClassName: SleepDemo
 * @Author: jiaoxian
 * @Date: 2022/6/11 15:27
 * @Description:
 */
public class WaitDemo {

    public static final Object LOCK = new Object();

    public static void main1(String[] args) {
        Stream.of("线程1", "线程2").forEach(a -> new Thread(a) {
            @Override
            public void run() {
                WaitDemo.testWait();
            }
        }.start());
    }

    private static void testWait() {
        synchronized (LOCK) {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行: " + System.currentTimeMillis() / 1000);
                // 等待 2 s
                LOCK.wait(2000);
                System.out.println(Thread.currentThread().getName() + "恢复执行: " + System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private void testWait1() {
        synchronized (LOCK) {
            try {
                System.out.println(Thread.currentThread().getName() + "开始执行: " + System.currentTimeMillis() / 1000);
                LOCK.wait();
                System.out.println(Thread.currentThread().getName() + "恢复执行: " + System.currentTimeMillis() / 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void testNotify() {
        synchronized (LOCK) {
            try {
                Thread.sleep(2000);
                LOCK.notify();
                System.out.println(Thread.currentThread().getName() + "唤醒另一线程: " + System.currentTimeMillis() / 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                new WaitDemo().testWait1();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                new WaitDemo().testNotify();
            }
        }.start();
    }

}
