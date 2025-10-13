package com.pre.core.overloadding;

class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

// only Return type will not affect overloading
        //    public double add(int a, int b, int c) {
        //        return a + b + c;
        //    }

// Autoboxing not work incase of overloading
        //    public void display(Integer a) {  }
        //    public void display(int a) {  }



}

public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Sum of 2 integers: " + calc.add(5, 3));            // Calls add(int, int)
        System.out.println("Sum of 3 integers: " + calc.add(5, 3, 2));         // Calls add(int, int, int)
        System.out.println("Sum of 2 doubles: " + calc.add(5.5, 3.3));        // Calls add(double, double)
    }
}
