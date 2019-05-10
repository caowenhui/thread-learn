package com.cwh.design.observer;

public interface Subject {
    /**
     * 增加观察者
     *
     * @param observer
     */
    void add(Observer observer);

    /**
     * 删除观察者
     *
     * @param observer
     */
    void del(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyObservers();

    /**
     * 自身操作
     */
    void operation();
}
