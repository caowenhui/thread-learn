package com.cwh.concurrency.chapter6;

import javax.sound.midi.Soundbank;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadInterrupt {
    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        /*Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("throw" + isInterrupted());
                        }
                    }
                }
            }
        };
        t.start();
        Thread.sleep(10000);
        System.out.println("t1" + t.isInterrupted());
        t.interrupt();
        System.out.println("t2" + t.isInterrupted());*/

       /* Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(Thread.interrupted());
                        }
                    }
                }
            }
        };

        t.start();
        t.interrupt();*/

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t.start();

        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("interrupt");
            }
        };

        t2.start();
        t.join();
    }
}
