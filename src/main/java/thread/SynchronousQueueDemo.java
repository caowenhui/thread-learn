package thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author cwh
 * @date 2019/5/2
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                //线程暂停会
                TimeUnit.SECONDS.sleep(5L);
                System.out.println(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(5L);
                System.out.println(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(5L);
                System.out.println(Thread.currentThread().getName()+"\t"+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
