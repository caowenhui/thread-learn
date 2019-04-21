package com.cwh.concurrency.containerChapter;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author cwh
 * @date 2019/4/18
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        //List<String> list = new Vector<>();//new ArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        /*
        * 1.故障现象
        *   java.util.concurrentModificationException
        * 2.导致原因
        *   并发争抢修改导致，参考花名册签名情况
        *   一个同学正在写入，另一个同学过来争抢，导致数据不一致异常。并发修改异常
        *
        * 3.解决方案
        *   3.1 new Vector()
        *   3.2 Collects.synchronizedList(new ArrayList())
        *   3.3 new CopyOnWriteArrayList() 写时复制，读写分离
        * 4.优化建议（同样的错误不犯第二次）
        *
        * */
    }
}
