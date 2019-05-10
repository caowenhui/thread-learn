package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cwh
 * @date 2019/5/5
 */
public class ProdCunsumerBlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue(5));
        new Thread(() -> {
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            try {
                myResource.myCumsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Cumsumer").start();

        //暂停一会线程
        TimeUnit.SECONDS.sleep(1L);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒时间到，main线程叫停，活动结束");
        myResource.stop();

    }
}

class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception {
        String data;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入对列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入对列" + data + "失败");
            }
//            TimeUnit.SECONDS.sleep(1L);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了，表示FLAG=false，生产动作结束");
    }

    public void myCumsumer() throws Exception {
        String data;
        while (FLAG) {
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (data == null || "".equalsIgnoreCase(data)) {
                FLAG = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费对列消费" + data + "成功");
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}
