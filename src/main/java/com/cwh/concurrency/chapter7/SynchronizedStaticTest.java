package com.cwh.concurrency.chapter7;

/**
 * @author cwh
 * @date 2019/4/15
 */
public class SynchronizedStaticTest {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                SynchronizedStatic.m1();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                SynchronizedStatic.m2();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                SynchronizedStatic.m3();
            }
        }.start();
    }
}
