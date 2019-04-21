package com.cwh.concurrency.chapter6;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadCloseGraceful {
    private static class Worker extends Thread{
        private volatile boolean state = true;
        @Override
        public void run() {
            while (state){

            }
        }

        public void shutdown(){
            this.state = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.start();

        Thread.sleep(1000);

        worker.shutdown();
    }
}
