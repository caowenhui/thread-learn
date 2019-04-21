package com.cwh.concurrency.chapter7;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class TicketWindowRunable implements Runnable {
    private int index;
    private final static int MAX = 500;
    private final Object LOCK = new Object();


    @Override
    public void run() {
        while (true){
           synchronized (LOCK){
               if(index > MAX){
                   break;
               }

               try {
                   Thread.sleep(5);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread()+"的号码："+index++);
           }
        }
    }

    private boolean ticket(){
        if(index > MAX){
            return false;
        }

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"的号码："+index++);
        return true;
    }
}
