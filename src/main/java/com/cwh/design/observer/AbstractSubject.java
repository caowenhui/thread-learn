package com.cwh.design.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cwh
 * @date 2019/5/7
 */
public abstract class AbstractSubject implements Subject {
    private List<Observer> list = new LinkedList<>();

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void del(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : list) {
            observer.update();
        }
    }
}
