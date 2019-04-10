package com.cwh.concurrency.chapter3;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("=====================");
            }
        };
        t1.start();
        t2.start();
        System.out.println(t1.getName());//Thread-0
        System.out.println(t2.getName());//Thread-1

        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(() -> {
            System.out.println("Runable...");
        });

        System.out.println(t3.getName());
        System.out.println(t4.getName());


        Thread t5 = new Thread(() -> {
            System.out.println("Runable.." + Thread.currentThread().getName());
        }, "RunableThread");
        t5.start();
    }
}
