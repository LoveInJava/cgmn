package com.pre.java17.sealed;

public sealed class Shape permits Circle, Square{
    
    public void area(){
        System.out.println("This is area() method of Shape");
    }
}
