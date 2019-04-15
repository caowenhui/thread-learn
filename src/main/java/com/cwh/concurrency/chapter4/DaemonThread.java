package com.cwh.concurrency.chapter4;

/**
 * 守护进程
 *
 * @author cwh
 * @date 2019/4/10
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "running");
                    Thread.sleep(100_000);
                    System.out.println(Thread.currentThread().getName() + "done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };//new
        t.setDaemon(true);
        t.start();
        //runable -> running| -> dead| -> blocked
        System.out.println("------------------------------------");
        Thread.sleep(50_000);
        System.out.println(Thread.currentThread().getName() + "---------------------");

    }
}
