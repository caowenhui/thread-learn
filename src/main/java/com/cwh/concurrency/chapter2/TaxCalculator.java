package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class TaxCalculator {

    private final double salary;
    private final double bonus;

    private final CalculateStrategy calculateStrategy;

    public TaxCalculator(double salary, double bonus, CalculateStrategy calculateStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.calculateStrategy = calculateStrategy;
    }

    public double calcTax() {
        return calculateStrategy.calculate(salary, bonus);
    }

    public double calculate() {
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public CalculateStrategy getCalculateStrategy() {
        return calculateStrategy;
    }
}
