package thread;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author cwh
 * @date 2019/4/28
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //3个车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i < 6; i++) {
            final int tempI = i * 3;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(tempI);
                    System.out.println(Thread.currentThread().getName() + "\t 停车" + tempI + "秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
