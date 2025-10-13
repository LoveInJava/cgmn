package com.pre.core.exception;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {

        ExceptionHandlingDemo ex = new ExceptionHandlingDemo();

        ex.specificExceptionDeclaration();
        System.out.println("Return Value : "+ ex.tryWithReturnStatement());
        //ex.tryBlockWithoutCatch();


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

    private String tryWithReturnStatement() {

        try {
            int x= 9;
            int y = 0;
            int z = x/y;
            return "A";
        }catch (Exception e){
            e.printStackTrace();
            return "B";
        }finally {
            return "C";
        }

    }

    private void tryBlockWithoutCatch() {

        try {
            System.out.println("Inside Try Block");
        } finally {
            System.out.println("Inside Finally Block");
        }
    }
}
