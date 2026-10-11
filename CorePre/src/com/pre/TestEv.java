package com.pre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestEv {

    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 50, 40, 30);
        int nthLargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElseThrow();
        System.out.println(nthLargest);
    }
}
