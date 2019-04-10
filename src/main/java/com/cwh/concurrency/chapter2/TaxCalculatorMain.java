package com.cwh.concurrency.chapter2;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        TaxCalculator tc = new TaxCalculator(10000, 2000, (s, b) -> s * 0.1 + b * 0.15);
        System.out.println(tc.calculate());
    }
}
