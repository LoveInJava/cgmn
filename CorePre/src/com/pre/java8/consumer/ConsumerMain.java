package com.pre.java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {
        //1
        Consumer<String> consumer = (msg)-> System.out.println(msg);
        consumer.accept("Hello Consumer");

        //3
        Consumer<List<Integer>> consumer1 = (listInt)->{

            for (int i : listInt){
                System.out.println(i);
            }

        };
        consumer1.accept(Arrays.asList(1,2,3,4,5));

        //3
        System.out.println("\n\n andThen uses");
        Consumer<List<Integer>> consumer2 = (listInt)->{

            for (int i : listInt){
                System.out.println(i+100);
            }

        };

        Consumer<List<Integer>> listConsumer = consumer1.andThen(consumer2);
        listConsumer.accept(Arrays.asList(1,2,3,4,5));
    }
}
