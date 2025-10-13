package com.pre.core.exception;

public class TryInFinally {
    public static void main(String[] args) {
        try {
            System.out.println("Main try block");
        } catch (Exception e) {
            System.out.println("Caught in main catch");
        } finally {
            System.out.println("In finally block");

            try {
                int[] arr = new int[2];
                System.out.println(arr[5]);  // Will throw ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught exception in finally block");
            }
        }
    }
}
