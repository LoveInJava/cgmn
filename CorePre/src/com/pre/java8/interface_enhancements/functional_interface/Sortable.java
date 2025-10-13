package com.pre.java8.interface_enhancements.functional_interface;

@FunctionalInterface
public interface Sortable {
    boolean compare(Sortable s);

    default void sortAll() {
        System.out.println("Inside sortAll");
    }

    static void compareAll() {
        System.out.println("Inside compareAll");
    }
}
