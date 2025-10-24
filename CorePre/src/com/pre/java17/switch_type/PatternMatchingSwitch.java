package com.pre.java17.switch_type;

public class PatternMatchingSwitch {

    // static String testPatternSwitch(Object obj) {
    static String testPatternSwitch(String obj) {
        return switch (obj) {
//            case String s -> "A string: " + s;
//            case Integer i -> "An integer: " + i;
//            case null -> "It's null!";
            default -> "Something else: " + obj;
        };
    }

    public static void main(String[] args) {
        System.out.println(testPatternSwitch("hello"));   // A string: hello
        //System.out.println(testPatternSwitch(42));        // An integer: 42

        sun.misc.Unsafe unsafe = sun.misc.Unsafe.getUnsafe();
    }
}
