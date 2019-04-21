package com.cwh.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> {
                        System.out.println(Thread.currentThread().getName() + "->" + i);
                    });
        }, "t1");

        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> {
                        System.out.println(Thread.currentThread().getName() + "->" + i);
                    });
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}
