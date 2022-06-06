package study.thread;

/**
 * @ClassName: MyThread2
 * @Author: jiaoxian
 * @Date: 2022/6/3 17:58
 * @Description:
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("实现 Runnable 接口");
    }

    public static void main(String[] args) {
        MyThread2 mythread2 = new MyThread2();
        new Thread(mythread2).run();
    }

}
