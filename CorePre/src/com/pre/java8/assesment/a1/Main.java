package com.pre.java8.assesment.a1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        // Sample skills
        Skill java = new Skill("Java");
        Skill python = new Skill("Python");
        Skill spring = new Skill("Spring");
        Skill docker = new Skill("Docker");


        // Sample employees
        Employee emp1 = new Employee(Arrays.asList(java, python));
        Employee emp2 = new Employee(Arrays.asList(python, spring));
        Employee emp3 = new Employee(Arrays.asList(java));


        // Sample departments
        Department dept1 = new Department(Arrays.asList(emp1, emp2));
        Department dept2 = new Department(Arrays.asList(emp3));

        List<Department> departments = Arrays.asList(dept1, dept2);


        List<Skill> distinctSkills = departments.stream().flatMap(department -> department.getEmployees().stream())
                .flatMap(employee -> employee.getSkills().stream()).distinct().toList();


        // Print result
        System.out.println("Distinct Skills:");
        distinctSkills.forEach(System.out::println);

    }
}
