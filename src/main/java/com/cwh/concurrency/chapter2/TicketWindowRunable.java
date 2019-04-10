package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class TicketWindowRunable implements Runnable {
    private int index = 1;
    private final static int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + "，当前号码是：" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
