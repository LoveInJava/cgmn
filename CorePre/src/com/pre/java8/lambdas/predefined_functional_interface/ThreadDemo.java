package com.pre.java8.lambdas.predefined_functional_interface;

public class ThreadDemo {


    public static void main(String[] args) {

        Runnable runnable = ()->{

            for (int i = 0; i <10; i++) {
                System.out.println("User : "+i+" | "+Thread.currentThread().getName());
            }
        };

        Thread thread = new Thread(runnable, "Worker Thread");
        thread.start();
    }
}
