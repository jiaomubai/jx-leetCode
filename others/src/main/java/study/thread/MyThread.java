package study.thread;

/**
 * @ClassName: MyThread
 * @Author: jiaoxian
 * @Date: 2022/6/3 17:48
 * @Description:
 */
public class MyThread {

    public static class MyThreadTest1 extends Thread {
        @Override
        public void run() {
            System.out.println("继承 Thread 类");
        }
    }

    public static void main(String[] args) {
        MyThreadTest1 myThreadTest1 = new MyThreadTest1();
        myThreadTest1.run();

    }

}
