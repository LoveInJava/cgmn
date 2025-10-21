package com.pre.java8.stream.commonQ;

import com.pre.java8.stream.utils.Fruit;
import com.pre.java8.stream.utils.TestData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonQues {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,6,7,8,9,10,11,12,14,13,15,16,17);

        //*********************************************************************************
        //1. to find sum of list through Stream
        //Integer sum = list.stream().reduce(0, Integer::sum);
        Integer sumByReduce = list.stream().reduce(0, (a,b)->a+b);
        Integer maxByReduce = list.stream().reduce(0, Integer::max);
        Integer minByReduce = list.stream().reduce(1, Integer::min);

        System.out.println("Sum of List Element By Reduce : "+sumByReduce);
        System.out.println("Avg List Element By Reduce : "+ (double)sumByReduce/ list.size());
        System.out.println("Max of List Element By Reduce : "+maxByReduce);
        System.out.println("Min of List Element By Reduce : "+minByReduce);

        //*********************************************************************************
        int sum = list.stream().mapToInt(Integer::valueOf).sum();
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        int max = list.stream().mapToInt(Integer::valueOf).max().orElse(-1);
        int min = list.stream().mapToInt(Integer::intValue).min().orElse(-1);

        System.out.println("Sum of List Element By mapToInt : "+sum);
        System.out.println("Avg List Element By mapToInt : "+ average);
        System.out.println("Max of List Element By mapToInt : "+max);
        System.out.println("Min of List Element By mapToInt : "+min);

        //*********************************************************************************
        Integer max1 = list.stream().max(Integer::compareTo).orElse(-1);
        System.out.println("Max : "+ max1);
        Integer min1 = list.stream().min(Comparator.comparing(Integer::intValue)).orElse(-1);
        System.out.println("Min : "+ min1);

        //*********************************************************************************
        System.out.println();
        System.out.println("Max Calories Fruit name: ");
        List<Fruit> allFruits = TestData.getAllFruits();
        Fruit fruit = allFruits.stream().max(Comparator.comparing(Fruit::getCalories)).orElse(null);
        System.out.println(fruit.getName());

        //*********************************************************************************
        System.out.println();
        System.out.println("3. count number of Strings that start with certain character.");
        //3. count number of Strings that start with certain character.
        List<String> fruits = Arrays.asList("apple", "grapes","banana","Orange");
        long count = fruits.stream().filter(s -> s.startsWith("g")).count();
        System.out.println(count);

        //*********************************************************************************
        System.out.println();
        System.out.println("5. to find even numbers from a list and also print the count for them using stream");
        long evenCount = list.stream().filter(integer -> integer % 2 == 0).peek(System.out::println).count();
        System.out.println(evenCount);

        //*******************************************************************************
        System.out.println();
        System.out.println("7. use streams to concatenate them");
        //7. Given Strings, use streams to concatenate them
        List<String> fruits2 = Arrays.asList("apple", "grapes","banana","Orange");

        String collect = fruits2.stream().collect(Collectors.joining(", "));
        System.out.println(collect);


        //*******************************************************************************
        System.out.println();
        System.out.println("8. Program using stream to find duplicate of elemets");
        //8.Program using stream to find duplicate of elemets
        List<Integer> list1 = Arrays.asList(1,33,55,44,33,55,6,55,7,55,44,3);

        Set<Integer> seen = new HashSet<>();

        List<Integer> collect1 = list1.stream().filter(i -> !seen.add(i)).collect(Collectors.toList());
        System.out.println(collect1);

        //*******************************************************************************
        System.out.println();
        System.out.println("9. To find biggest String ");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        String s = words.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println(s);


        //*******************************************************************************
        System.out.println();
        System.out.println("10. To find biggest Number from Given number ");
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer i = numbers.stream().filter(num -> num > 15).max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println("i = " + i);

        //*******************************************************************************
        System.out.println();
        System.out.println("11. To filter even and odd ");
        List<Integer> numbers1 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> collect2 = numbers1.stream().collect(Collectors.groupingBy((nm )-> (nm % 2 == 0) ? "Even" : "ODD"));
        System.out.println("collect2 = " + collect2);

        //*******************************************************************************
        System.out.println();
        System.out.println("13. count occurrence of words ");
        String sentence = "Java is fun and Java is powerful";
        Map<String, Long> collect3 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("collect3 = " + collect3);

        //*******************************************************************************
        System.out.println();
        System.out.println("16.From a String, count the number of letters it has ");
        String lStr = "Hello";
        Map<String, Long> collect5 = Arrays.stream(lStr.split("")).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println("collect5 = " + collect5);
        Map<Character, Long> collect4 = lStr.chars().mapToObj(value -> (char) value).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("collect4 = " + collect4);
        
        //
        String str = "aaabbcccdddd";

        Map<String, Long> collect6 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(
                        chh -> chh,
                        LinkedHashMap::new, // correct map supplier
                        Collectors.counting()
                ));

        //Arrays.stream(str.split("")).collect(Collectors.groupingBy(chh -> chh, LinkageError::new, Collectors.counting()));
        System.out.println("collect6 = " + collect6);


    }


}
