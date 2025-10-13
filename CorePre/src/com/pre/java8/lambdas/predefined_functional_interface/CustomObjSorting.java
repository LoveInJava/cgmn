package com.pre.java8.lambdas.predefined_functional_interface;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Student{

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class CustomObjSorting {



    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student(1,"Aaif"),
                new Student(33,"Kalal"),
                new Student(2,"Namal"),
                new Student(21,"Jamal"),
                new Student(5,"Kamal")
        );

        Collections.sort(list, (a,b)-> b.id-a.id);
        System.out.println("Sort List : "+ list);
    }



}
