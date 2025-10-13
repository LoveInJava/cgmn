package com.pre.core.exception.inheritance;

class ParentMethodWithoutDeclaringException {
    void show() {
        System.out.println("Parent");
    }
    void display() {
        System.out.println("Parent");
    }
}

class Child extends ParentMethodWithoutDeclaringException {
    @Override
    void show() throws NullPointerException { // Allowed (unchecked)
        System.out.println("Child");
    }

//    @Override
//    void display() throws IOException { // Not Allowed (unchecked)
//        System.out.println("Child");
//    }
}
