package com.pre.java8.assesment.a3;

import java.util.*;
import java.util.stream.Collectors;

public class CategorySplitter {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("potato:veg", "mango:fruits", "banana:fruits");

        Map<String, List<String>> grouped = items.stream()
            .map(item -> item.split(":")) // Split into [name, category]
            .collect(Collectors.groupingBy(
                parts -> parts[1], // Group by category
                Collectors.mapping(parts -> parts[0], Collectors.toList()) // Map to item name
            ));

        // Print results
        grouped.forEach((category, names) -> {
            System.out.println(category + ": " + names);
        });
    }
}