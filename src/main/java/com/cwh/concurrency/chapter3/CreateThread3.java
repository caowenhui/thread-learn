package com.cwh.concurrency.chapter3;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class CreateThread3 {
    private int i;
    private byte[] bytes = new byte[1024];
    private static int counter = 0;

    public static void main(String[] args) {
        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(counter);
        }
    }

    public static void add(int i) {
        ++counter;
        add(i + 1);
    }
}
