package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author cwh
 * @date 2019/5/6
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
        //两个线程同时执行一个futureTask第二个线程不会执行call方法
//        new Thread(futureTask, "BB").start();
        new Thread(futureTask2, "BB").start();

        System.out.println(Thread.currentThread().getName()+"\t ************");
        while (!futureTask.isDone()){

        }
        //获取Callable线程的计算结果，如果没有计算完成就调用，线程会阻塞
        System.out.println(futureTask.get());

    }
}

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "******come ing");
        TimeUnit.SECONDS.sleep(2L);
        return 1024;
    }
}