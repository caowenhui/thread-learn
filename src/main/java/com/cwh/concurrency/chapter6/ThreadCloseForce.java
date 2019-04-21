package com.cwh.concurrency.chapter6;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class ThreadCloseForce {
    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(() -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadService.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
