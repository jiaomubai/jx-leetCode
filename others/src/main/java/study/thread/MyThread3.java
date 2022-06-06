package study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: MyThread3
 * @Author: jiaoxian
 * @Date: 2022/6/3 18:09
 * @Description:
 */
public class MyThread3 implements Callable {

    @Override
    public Object call() throws Exception {
        return "实现 Callable 接口";
    }

    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> task=new FutureTask<String>(new MyThread3());
        //启动线程
        new Thread(task).start();
        try {
            //等待执行完成，并获取返回结果
            String result = task.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
