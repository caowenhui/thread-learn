package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cwh
 * @date 2019/4/14
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, "thread name").start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("number=" + myData.number);
        System.out.println("atomic number=" + myData.atomicInteger);
    }

    //volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come it");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addTo60();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
        }).start();

        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "main " + myData.number);
    }
}

class MyData {
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
