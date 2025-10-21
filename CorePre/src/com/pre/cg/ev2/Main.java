package com.pre.cg.ev2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Convert each words first character into upper case
        String name = "count the frequency of each character and";

        String collect = Arrays.stream(name.split(" ")).map(str -> {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }).collect(Collectors.joining(" "));

        System.out.println("Converted : "+ collect);

    }
}
