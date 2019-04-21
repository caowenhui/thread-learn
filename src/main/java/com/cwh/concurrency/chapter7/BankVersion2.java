package com.cwh.concurrency.chapter7;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class BankVersion2 {
    public static void main(String[] args) {
        final SynchronizedRunable runable = new SynchronizedRunable();
        Thread t1 = new Thread(runable, "一号窗口");
        Thread t2 = new Thread(runable, "二号窗口");
        Thread t3 = new Thread(runable, "三号窗口");
        t1.start();
        t2.start();
        t3.start();
    }
}
