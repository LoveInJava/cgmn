package com.pre.java8.lambdas.predefined_functional_interface;

import java.util.*;

public class ComparatorDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(23, 43, 5, 46, 4, 13);
        Collections.sort(list);
        System.out.println("Ascending : " + list);

        // sort list in descending order
        Comparator<Integer> comparator = (a, b) -> {
            return b - a;
        };

        Collections.sort(list, comparator);
        System.out.println("Manual Sorting : " + list);
    }
}
