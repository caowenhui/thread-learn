package com.cwh.concurrency.chapter4;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(1_000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //innerThread.setDaemon(true);
            innerThread.start();
        });

        //t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(1_000);
            System.out.println("T thread finish done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

