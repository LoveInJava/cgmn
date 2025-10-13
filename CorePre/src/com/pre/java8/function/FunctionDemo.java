package com.pre.java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        //1
        Function<String, Integer> functionLength = (str) -> str.length();
        System.out.println("Length of str : " + functionLength.apply("Aasif"));

        //2
        Function<String, String> functionSubString = (str) -> str.substring(0, 3);
        System.out.println("SubString of str : " + functionSubString.apply("Elephant"));

        //3
        List<Student> list = Arrays.asList(
                new Student(1, "vipin"),
                new Student(2, "vimal"),
                new Student(3, "vipul"),
                new Student(4, "amna")

        );

        Function<List<Student>, List<Student>> function = (std1) -> {
            List<Student> filterdStudent = std1.stream().filter(student -> student.getName().toLowerCase().substring(0, 3).equals("vip")).toList();
            return filterdStudent;
        };

        System.out.println(" Filtered List : " + function.apply(list));

        //4
        Function<Integer, Integer> function1 = (x) -> x * 2;
        Function<Integer, Integer> function2 = (x) -> x * x * x;

        System.out.println(function1.andThen(function2).apply(2)); //64
        System.out.println(function2.andThen(function1).apply(2)); //512
        System.out.println(function1.compose(function2).apply(2)); //512


    }
}
