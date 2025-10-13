package com.pre.java8.interface_enhancements.static_methods;

interface A{

    static void m1(){
        System.out.println("Inside static m1()");
    }
}
public class StaticMethodsInInterface implements A{

    public static void main(String[] args) {
        StaticMethodsInInterface staticMethodsInInterface = new StaticMethodsInInterface();
        //staticMethodsInInterface.m1(); // Not Compile
        //StaticMethodsInInterface.m1(); // Not Compile
        A.m1(); // We can call static interface method by Interface name
    }
}
