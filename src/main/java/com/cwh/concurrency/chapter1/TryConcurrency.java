package com.cwh.concurrency.chapter1;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class TryConcurrency {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                println(Thread.currentThread().getName());// main
                readFromDataBase();
            }
        };
        t.start();

        new Thread() {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 30L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(1000 * 20L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("The data handle finish and successfully.");
    }

    private static void println(String message) {
        System.out.println(message);
    }

}
