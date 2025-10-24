package com.pre.java8.assesment.a3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ThirdHighest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 7, 8, 2, 4, 1, 5);

        Optional<Integer> thirdHighest = numbers.stream()
            .distinct()                      // Remove duplicates
            .sorted(Comparator.comparingInt(Integer::intValue).reversed()) // Sort in descending order
            .skip(2)                         // Skip first two highest
            .findFirst();                    // Get the third highest

        thirdHighest.ifPresent(num -> System.out.println("Third highest number is: " + num));
    }
}
