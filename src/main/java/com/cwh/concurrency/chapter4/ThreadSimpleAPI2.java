package com.cwh.concurrency.chapter4;

import java.util.Optional;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadSimpleAPI2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        }, "t1");

        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        }, "t2");
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        }, "t3");
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
