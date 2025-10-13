package com.pre.core.staticbm;

public class StaticDemo {

    {
        System.out.println("Inside Init Block : 1");
    }

    {
        System.out.println("Inside Init Block : 2");
    }

    public StaticDemo() {
        System.out.println("Inside Default Constructor");
    }

    static {
        System.out.println("Inside static Block : 1");
    }
    static {
        System.out.println("Inside static Block : 2");
    }

    private static void m1(){
        System.out.println("Inside m1()");
    }

    public static void main(String[] args) {

        System.out.println("Inside main method()");

        StaticDemo staticDemo  = new StaticDemo();

    }
}
