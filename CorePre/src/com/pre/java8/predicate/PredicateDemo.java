package com.pre.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
//1
        Predicate<Integer> predicate = (x) -> x > 10;
        System.out.println(predicate.test(4));

        //2
        List<Integer> list = Arrays.asList(2,3,5,6,63,2,6,3);
        int sum = list.stream().filter(x -> x%2 == 0).mapToInt(i->i).sum();
        System.out.println("Sum of Even Num: "+sum);

        //3
        Predicate<String> startWithA = (str) -> str.toLowerCase().charAt(0) == 'a';
        Predicate<String> endWithM = (str) -> str.toLowerCase().charAt(str.length()-1) == 'm';

        System.out.println("String start with 'a' : "+startWithA.test("aman"));

        Predicate<String> and = startWithA.and(endWithM);

        System.out.println("And Test: "+and.test("Arham"));
    }
}
