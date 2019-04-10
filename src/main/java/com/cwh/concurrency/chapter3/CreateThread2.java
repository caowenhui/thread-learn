package com.cwh.concurrency.chapter3;

import java.util.Arrays;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        /*System.out.println(t1.getThreadGroup().getName());//main
        System.out.println(Thread.currentThread().getName());*/
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        //System.out.println(threadGroup.getName());
        System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);

    }
}
