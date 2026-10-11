package com.pre.core.equals_hashcode_contract;

import java.util.HashMap;

class Person {

    String name;
    int age;

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {

        return age;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Person)obj).name) && this.age==((Person)obj).age;
    }
}

public class EqualsHashcodeContract {

    public static void main(String[] args) {
        Person person1 = new Person("John",25);
        Person person2 = new Person("John",25);
        System.out.println("person2.hashCode() = " + person2.hashCode());
        System.out.println("person1.hashCode() = " + person1.hashCode());
        System.out.println(" person1 == person2 "  + (person1.equals(person2)) );

        HashMap<Person,Integer> hashMap = new HashMap<>();

        hashMap.put(person1,1);
        hashMap.put(person2,2);

        System.out.println("hashMap.size() = " + hashMap.size());


    }
}
