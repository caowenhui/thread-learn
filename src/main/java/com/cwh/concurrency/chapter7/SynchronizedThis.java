package com.cwh.concurrency.chapter7;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class SynchronizedThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread(){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }
}

class ThisLock{
    private final Object LOCK = new Object();

    public void m1() {
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
