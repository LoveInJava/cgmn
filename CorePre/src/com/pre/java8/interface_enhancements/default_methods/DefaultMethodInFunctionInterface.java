package com.pre.java8.interface_enhancements.default_methods;

interface  Parent{

    default void sayHello(){
        System.out.println("Parent Say Hello!");
    }
}

class Child implements  Parent{

    @Override
    public void sayHello() {
        System.out.println("Child Say Hello!");
    }
}
public class DefaultMethodInFunctionInterface {

    public static void main(String[] args) {
        Parent child = new Child();
        child.sayHello();
    }

}
