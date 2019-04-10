package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class SimpleCalculateStrategy implements CalculateStrategy {
    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
