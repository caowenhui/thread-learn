package com.cwh.concurrency.containerChapter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cwh
 * @date 2019/4/21
 */
public class ReenterLockDemo {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();
        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("------------------------------------");
        new Thread(new Phone(), "t3").start();
        new Thread(new Phone(), "t4").start();
    }
}

class Phone implements Runnable {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\tsend SMS");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\tsend Email");
    }

    @Override
    public void run() {
        get();
    }

    Lock lock = new ReentrantLock();

    private void get() {
        try {
            lock.lock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t invocked get()");
            set();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    private void set() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t invocked set()");
        } finally {
            lock.unlock();
        }
    }
}