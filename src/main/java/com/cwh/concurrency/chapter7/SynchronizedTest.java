package com.cwh.concurrency.chapter7;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class SynchronizedTest {
    private final static Object LOCK = new Object();
    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
    }
}
