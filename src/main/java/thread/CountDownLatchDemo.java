package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author cwh
 * @date 2019/4/25
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t ,被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEachCountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println("秦，统一六国");
    }

    private static void closeDoor() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习回家");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t **********班长最后关门");
    }
}
