package com.cwh.concurrency.chapter1;

/**
 * @author cwh
 * @date 2019/4/10
 */
public class TemplateMethod {
    public void print(String message) {
        System.out.println("********************");
        wrapPrint(message);
        System.out.println("********************");
    }

    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod tm1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("#" + message + "#");
            }
        };
        tm1.print("Hello Thread");

        TemplateMethod tm2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };
        tm2.print("Hello Thread");
    }
}
