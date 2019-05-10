package com.cwh.design.observer;

/**
 * @author cwh
 * @date 2019/5/7
 */
public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer2 has received");
    }
}
