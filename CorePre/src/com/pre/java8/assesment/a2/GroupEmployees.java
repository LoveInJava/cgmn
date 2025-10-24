package com.pre.java8.assesment.a2;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    // Optional: for printing
    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class GroupEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 120000),
            new Employee(2, "Bob", "HR", 80000),
            new Employee(3, "Charlie", "Engineering", 110000),
            new Employee(4, "David", "Engineering", 115000),
            new Employee(5, "Eve", "HR", 85000),
            new Employee(6, "Frank", "Sales", 90000)
        );

        // Group by department
        Map<String, List<Employee>> grouped = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        // Filter departments with 2 or more employees
        Map<String, List<Employee>> filtered = grouped.entrySet().stream()
            .filter(entry -> entry.getValue().size() >= 2)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(filtered);

        // Print result
        filtered.forEach((dept, emps) -> {
            System.out.println("Department: " + dept);
            emps.forEach(emp -> System.out.println("  - " + emp));
        });
    }
}