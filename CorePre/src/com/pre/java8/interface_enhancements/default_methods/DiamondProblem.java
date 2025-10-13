package com.pre.java8.interface_enhancements.default_methods;

interface  A{
    default void sayHello() {
        System.out.println("A Say Hello!");
    }
}
interface  B{
    default void sayHello() {
        System.out.println("B Say Hello!");
    }
}
public class DiamondProblem implements A,B{

    public static void main(String[] args) {
        DiamondProblem diamondProblem = new DiamondProblem();
        diamondProblem.sayHello();
    }

    @Override
    public void sayHello() {
        B.super.sayHello(); // Works but either A or B
        A.super.sayHello(); // Works but either A or B

        System.out.println("Own Implementation Say Hello!");
    }
}
