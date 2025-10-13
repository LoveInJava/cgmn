package com.pre.collection;

import com.pre.collection.util.Employee;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {

        Employee e1 = new Employee(1,"Aman");
        Employee e2 = new Employee(1,"Aman");

        HashMap<Employee, String> lhMap = new HashMap<>();
        lhMap.put(e1, "A");
        lhMap.put(e2, "B");

        System.out.println("Size : "+lhMap);
    }
}
