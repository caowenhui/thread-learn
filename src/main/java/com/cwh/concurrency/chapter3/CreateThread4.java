package com.cwh.concurrency.chapter3;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {
        Thread t = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(0);
                } catch (Error e) {
                    e.printStackTrace();
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                ++counter;
                add(i + 1);
            }
        }, "Test", 1 << 24);

    }
}
