package com.pre.java17.sealed;


final class Square extends Shape{

    @Override
    public void area(){
        System.out.println("This is a area of Square");
    }
}

final class Circle extends Shape{
    public void area(){
        System.out.println("This is a area of Circle");
    }
}

public class SealedDemo {


}
