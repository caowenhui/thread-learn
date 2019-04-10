package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class BankVersion2 {
    private final static int MAX = 50;

    public static void main(String[] args) {
//        final TicketWindowRunable ticketWindowRunable = new TicketWindowRunable();
        final Runnable runnable = () -> {
            int index = 1;
            while (index <= MAX) {
                System.out.println(Thread.currentThread().getName() + "，当前号码是：" + index++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable, "一号柜台");
        Thread t2 = new Thread(runnable, "二号柜台");
        Thread t3 = new Thread(runnable, "三号柜台");

        t1.start();
        t2.start();
        t3.start();
    }
}
