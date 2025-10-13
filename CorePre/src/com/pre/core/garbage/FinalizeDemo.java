package com.pre.core.garbage;

public class FinalizeDemo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called before GC deletes object");
    }

    public static void main(String[] args) {
        FinalizeDemo obj = new FinalizeDemo();
        obj = null; // Make object eligible for GC

        System.gc(); // Suggest JVM to run GC

        System.out.println("End of main method");
    }
}
