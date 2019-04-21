package com.cwh.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 is running");
                Thread.sleep(10_000);
                System.out.println("t1 is done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t1.join(1000, 19);

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));*/

        //start httpServer
        //Thread.currentThread().join();//线程一直等待main线程结束

        Thread t1 = new Thread(() -> {
            System.out.println("t1 is running.");
            while (true) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10_000);
                t1.interrupt();
                System.out.println("interrupt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        t1.join();


    }
}
