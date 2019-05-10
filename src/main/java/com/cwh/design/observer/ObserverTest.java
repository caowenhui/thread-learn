package com.cwh.design.observer;

/**
 * @author cwh
 * @date 2019/5/7
 */
public class ObserverTest {
    public static void main(String[] args) {
        MySubject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();
    }
}
