package com.pre.core.exception;

public class FinallyExceptionExample {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            throw new RuntimeException("Exception in try");
        } catch (Exception e) {
            System.out.println("Inside catch block");
            throw new RuntimeException("Exception in catch");
        } finally {
            System.out.println("Inside finally block");
            throw new RuntimeException("Exception in finally");
        }
    }
}
