package com.cwh.concurrency.containerChapter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * @author cwh
 * @date 2019/4/19
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa1", "bbb2", "ccc3", "ddd4", "eee5", "fff6");
        list.stream()
            .filter(s -> s.startsWith("c"))
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        System.out.println(pool.getParallelism());

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));

    }
}
