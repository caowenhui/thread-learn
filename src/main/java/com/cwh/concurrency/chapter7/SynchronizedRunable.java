package com.cwh.concurrency.chapter7;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class SynchronizedRunable implements Runnable {
    private int index = 1;
    private final static int MAX = 500;


    @Override
    public void run() {
        while (true){
            if(ticket()){
                break;
            }
        }
    }

    private boolean ticket() {
        synchronized (this) {
            if (index > MAX) {
                return true;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "的号码是：" + index++);
            return false;
        }
    }
}
