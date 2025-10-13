package com.pre.core.exception.inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

class ParentMethodWithDeclaringException {
    void show() throws IOException {
        System.out.println("Parent show");
    }
    void display() throws IOException {
        System.out.println("Parent display ");
    }
    void shape() throws IOException{
        System.out.println("Parent shape ");
    }

    void cool() throws IOException{
        System.out.println("Parent shape ");
    }
}

class Child2 extends ParentMethodWithDeclaringException {
    // Allowed (Not declared exception)
    @Override
    void show() {
        System.out.println("Child");
    }

    // Allowed (Same Exception exception)
    @Override
    void display() throws IOException {
        System.out.println("Parent display ");
    }
    // Allowed (Subclass exception)
    @Override
    void shape() throws FileNotFoundException {
        System.out.println("Parent shape ");
    }

    // Not Allowed (Parent exception)
//    @Override
//    void cool() throws Exception{
//        System.out.println("Parent shape ");
//    }
}
