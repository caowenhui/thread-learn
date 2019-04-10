package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow tw1 = new TicketWindow("一号柜台");
        tw1.start();
        TicketWindow tw2 = new TicketWindow("二号柜台");
        tw2.start();
        TicketWindow tw3 = new TicketWindow("三号柜台");
        tw3.start();
    }
}
