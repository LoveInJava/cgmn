package com.credit.prep.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTestOperation {

    record Person(String name, List<String> hobbies) {

        public Person(String name, List<String> hobbies){
            this.name = name;
            this.hobbies = List.copyOf(hobbies);
        }

    }

    public static void main(String[] args) {
        question1();

    }

    public  static void question1() {

        //1.
        //Stops when condition becomes false.
        Stream.of(1,2,3,4,1)
                .takeWhile(i -> i < 3)
                .forEach(System.out::print);

        // 2. Nothing Printed because name is null and ofNullable will return empty stream
        String name = null;
        Stream.ofNullable(name)
                .forEach(System.out::println);

        //3. Unsupporetedoperation exception because of unmodifiable list
//        List<String> list =
//                Stream.of("A","B")
//                        .collect(Collectors.toUnmodifiableList());
//
//        list.add("C");  // 💥 UnsupportedOperationException

        //4.
        Stream.of("A", 1, "B")
                .filter(o -> o instanceof String s && s.length() == 1)
                .forEach(System.out::println);

        //5.
        record Person(String name, int age) {}

        List<Person> list = List.of(
                new Person("Aasif", 30),
                new Person("Java", 25)
        );

        list.stream()
                .map(person -> {
                   return person.name.length();
                })
                .forEach(System.out::println);
    }
}
