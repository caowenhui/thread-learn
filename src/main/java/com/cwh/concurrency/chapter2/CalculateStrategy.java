package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
@FunctionalInterface
public interface CalculateStrategy {

     double calculate(double salary, double bonus);
}
