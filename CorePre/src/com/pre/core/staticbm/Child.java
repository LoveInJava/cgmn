package com.pre.core.staticbm;

public class Child extends Parent{

    public static void m1(){
        System.out.println("Inside Child m1() ");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.m1();
    }
}
