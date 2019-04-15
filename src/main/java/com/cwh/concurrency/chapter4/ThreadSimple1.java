package com.cwh.concurrency.chapter4;

import java.util.Optional;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadSimple1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
        Optional.of(Thread.currentThread().getId()).ifPresent(System.out::println);
        Optional.of(Thread.currentThread().getPriority()).ifPresent(System.out::println);

    }
}
