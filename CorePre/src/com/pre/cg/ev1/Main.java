package com.pre.cg.ev1;

import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //Create a functional interface com.pre.cg.ev1.MyInterface having one abstract
    // method pubic int multiply (int a, int b).
    // Now define this multiply method using lambda expression.



    public static void main(String[] args) {

        MyInterface myInterface = (a, b) -> a*b;
        System.out.println("Multiply of given numbers : "+ myInterface.multiply(5, 6));

        checkString(null);

    }

    //Write a method checkString(String name),
    // call the method by passing null and
    // check if name is not null then print name ELSE print
    // the message "null value is not allowed". (Use Optional Class).
    public static void checkString(String name){

        Optional<String> nameOptional = Optional.ofNullable(name);

        if(nameOptional.isPresent()){
            System.out.println("Name is "+ name);
        }else{
            System.out.println("null value is not allowed");
        }


    }
}