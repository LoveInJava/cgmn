package com.pre.java8.lambdas;

public class Main {

    public static void main(String[] args) {

        // By traditional way
        SoftwareEngineer employee = new SoftwareEngineer();
        System.out.println(employee.getName());

        // lambda expression
        Employee employee1 = () -> {
            return "Software Engineer";
        };
        Employee employee2 = () -> {
            return "Editor";
        };
        System.out.println("By Lambda Expression : "+ employee1.getName());
        System.out.println("By Lambda Expression : "+ employee2.getName());

    }
}
