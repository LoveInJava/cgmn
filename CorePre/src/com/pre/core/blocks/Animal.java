package com.pre.core.blocks;

class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}

class Cat extends Animal {
    double whiskerLength;

    // Instance initializer block
    {
        whiskerLength = 4;
        System.out.println("Instance initializer block executed");
    }

    // Constructor
    Cat() {
        super(); // Calls the parent class constructor
        System.out.println("Cat constructor executed");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}
