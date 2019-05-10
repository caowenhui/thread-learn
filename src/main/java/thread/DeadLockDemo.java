package thread;

import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种相互等待的现象
 * 若无外力干涉那他们将无法进行下去
 * @author cwh
 * @date 2019/5/9
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        HoldLockThread holdLockThreadA = new HoldLockThread(lockA, lockB);
        HoldLockThread holdLockThreadB = new HoldLockThread(lockB, lockA);
        new Thread(holdLockThreadA, "AA").start();
        new Thread(holdLockThreadB, "BB").start();
    }
}

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有:" + lockA + "\t 尝试获取" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有:" + lockB + "\t 尝试获取" + lockA);
            }
        }
    }
}
