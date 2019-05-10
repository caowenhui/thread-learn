package com.cwh.design.observer;

/**
 * @author cwh
 * @date 2019/5/7
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
