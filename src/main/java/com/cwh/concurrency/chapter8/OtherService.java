package com.cwh.concurrency.chapter8;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class OtherService {
    private DeadLock deadLock;
    private final Object lock = new Object();

    /*public OtherService(DeadLock deadLock) {
        this.deadLock = deadLock;
    }*/

    public void s1(){
        synchronized (lock) {
            System.out.println("s1================");
        }
    }

    public void s2(){
        synchronized (lock){
            System.out.println("s2=======================");
            deadLock.m1();
        }
    }


    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
