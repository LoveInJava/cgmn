package com.pre.java8.interface_enhancements.inhertance;

@FunctionalInterface
interface Parent{
    void sayHello();
}

@FunctionalInterface
public interface InheritanceFunctionalInterface extends Parent {
    void sayHello(); // we can declare the same abstract method as in parent or not
    //void sayBay();// Breaks Functional Interface Rule

    default void m1(){
        System.out.println("Inside Default");
    }

    static void ms1(){
        System.out.println("Inside static");

    }
}
