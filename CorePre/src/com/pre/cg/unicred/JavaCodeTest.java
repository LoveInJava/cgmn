package com.pre.cg.unicred;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaCodeTest {

    private static boolean isProductNotExpired(String dataInizioCollocamento, String dataFineCollocamento) {
        //startdate -> dataInizioCollocamento
        //enddate -> dataFineCollocamento
        if (dataFineCollocamento == null || dataFineCollocamento.trim().isEmpty()) {
            //log.warn("dataFineCollocamento is null or empty, considering product as expired");
            return false;
        }

        try {
            // Parse the date portion from the string "2999-07-01T00:00:00.000+0200"
            // Extract only the date part before 'T'

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

            //var datePart = dataFineCollocamento.split("T")[0];
            var satrtDate = OffsetDateTime.parse(dataInizioCollocamento, formatter).toLocalDate();
            var endDate = OffsetDateTime.parse(dataFineCollocamento, formatter).toLocalDate();
            var currentDate = LocalDate.now(ZoneId.systemDefault());

            boolean isPastOrCurrent = satrtDate.isBefore(currentDate) || satrtDate.isEqual(currentDate);
            boolean isFuture = endDate.isAfter(currentDate); // endDate > currentDate
            //log.info("isPastOrCurrent : {}, StartDate :{}, TodayDate :{}", isPastOrCurrent, satrtDate, currentDate);
            //log.info("isFuture : {}, EndDate :{}, TodayDate :{}", isFuture, endDate, currentDate);

            return isPastOrCurrent && isFuture;
        } catch (DateTimeParseException e) {
            //log.error("Failed to parse dataFineCollocamento: {}. Error: {}", dataFineCollocamento, e.getMessage());
            return false;
        } catch (Exception e) {
            //log.error("Unexpected error while checking product expiration for dataFineCollocamento: {}. Error: {}",dataFineCollocamento, e.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {

        System.out.println(" is ----- "+ isProductNotExpired("2026-07-17T00:00:00.000+0200", "2026-07-16T00:00:00.000+0200"));
        Integer x = 200;
        Integer y = 200;
        System.out.println(x == y); // false because 200 is outside the Integer caching range, so x and y refer to different objects


        Integer  a = 100;
        Integer  b = 100;
        System.out.println(a == b); // true because of Integer caching for values between -128 and 127


//        question3();
//        question5("A");
//        System.out.println(tryWithReturnStatement("123"));
//        System.out.println(tryWithReturnStatement());
//        question10(null, List.of(")", " ", "John", "Doe", "Jane"));
//        question11();
 //       question12();
        //m(null);
       // q1();
       // q2();
        System.out.println(q3(1));
        System.out.println(q4(1));
        q4();
        q4(2);
        System.out.println(q5(null));
        System.out.println(q5("abcd"));
        System.out.println(q5(5));

    }

    record P(int x, int y) {}

    public static void q4() {
        System.out.println(new P(1, 2));
        System.out.println(new P(1, 2).equals(new P(1, 2)));
    }
    //only 21
    private static int q4(Object x) {
        return switch (x) {
            case Integer i when i == 1 -> 10;
            case Integer i when i == 2 -> 20;
            case String s when s.equals("A") -> 30;
            default -> throw new IllegalArgumentException("Unexpected value: " + x);
        };
    }

    private static int q3(int x) {
        return switch (x) {
            case 1 -> 10;
            case 2 -> 20;
            case 3 -> 30;
            default -> -1;
        };
    }

    static String q5(Object o) {
        return switch (o) {
            case null -> "NULL";
            case Integer i -> "INT " + i;
            case String s -> "STR " + s.length();
            default -> "OTHER";
        };
    }

    static String q6(Object o) {
        String result = null;
        switch (o) {
            case null -> result =  "NULL";
            case Integer i -> result = "INT " + i;
            case String s -> result = "STR " + s.length();
            default -> result = "OTHER";
        };

        return result;
    }

    private static void q2() {
        int a = 1;
        System.out.println(a++ + ++a + a);
    }

    private static void q1() {

        // not supported because List.of returns an immutable list, which does not allow modifications after creation.
        //List<String> listof = List.of("a", "b", null, "c");
        List<String> listof = List.of("a", "b", "c");
        //listof.add("d");
        //listof.set(1,"d");
        System.out.println(listof);

        // this works because Arrays.asList returns a fixed-size list backed by the original array, allowing modifications to existing elements but not adding new ones.
        List<String> list = Arrays.asList("a", "b", "c");
        list.set(1,"d");
        //list.add("d");
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        list1.remove(1);
        System.out.println(list1);
    }

    private static  void question3() {
        int i = 243;
        byte b = (byte) i;
        i=b;
        System.out.println("Value of i "+ i);
        System.out.println("Value of  b: " + b);

    }

    private static  boolean question5(final String input) {

        if(input.equals("A")) {
            return true;
        }else {
            return false;
        }

        //refactored code:
        //return "A".equals(input)
    }

    private static int tryWithReturnStatement(String s) {

        try {
            System.out.println("Try ME");
            return Integer.parseInt(s);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        } finally {
            System.out.println();
            return 3;
        }

    }

    private static  String tryWithReturnStatement() {

        try {
            int x= 9;
            int y = 0;
           // int z = x/y;
            return "A";
        }catch (Exception e){
            e.printStackTrace();
            return "B";
        }finally {
            return "C";
        }
    }

    private void specificExceptionDeclaration() {

        try {
            int x= 9;
            int y = 0;
            int z = x/y;
        }catch (Exception e){
            e.printStackTrace();
        }
        // It has no significance if Exception in top
//        catch (ArithmeticException e){
//            e.printStackTrace();
//        }
        finally {
            System.out.println("ExceptionHandlingDemo.specificExceptionDeclaration " + "Inside Finally");
        }
    }

    private static  void question10(Math m, List<String> names) {

        List< String > validNames  = names.stream().filter(String::isBlank).toList();
        List< String > validNames1  = names.stream().filter(String::isBlank).collect(Collectors.toList());

//        validNames.add("sdsdd");
        validNames1.add("dsdsd");
        System.out.println("Valid Names : " + validNames);
        System.out.println("Valid Names : " + validNames1);

    }

    // is it compile or not ? if compile what will be the output
//    private void question18(List names) {
//        final int i= 0;
//        names.stream().map(name -> i++).forEach(e ->
//                System.out.println(e));
//        );
//    }

    // How can you print to the console all the Person name before the condition is met
    private static  void question11() {

        var persons = List.of(new Person("John", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Victor", "Blame"));


        var mCount = persons.stream().peek(person -> System.out.println("First  Name: "+person.getFirstName())).
                filter(person -> person.getLastName().length() < 4).count();

        System.out.println("Met With Condition: "+mCount);
    }

    private static  void question12() {

        var input = List.of("AAA", "A", "AB", "BBB", "CCC");

        final Stream<String> stream = input.stream();
       // System.out.println("Before Stream : " + stream.count());

        List<String> result = stream
                .filter(s -> s.length() > 2)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        //System.out.println("After Stream : " + stream.count());

                 stream
                .filter(s -> s.length() > 2)
                .peek(System.out::println)
                .map(String::toLowerCase)
                .collect(Collectors.toList());


        System.out.println("Result: " + result);

    }
    static void m(String s) { System.out.println("String"); }
    static void m(Integer i) { System.out.println("Integer"); }


}
