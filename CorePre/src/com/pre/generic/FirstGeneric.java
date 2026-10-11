package com.pre.generic;

public class FirstGeneric<T> {

    T obj;

    public void printObject(T objt){

        obj = objt;

        System.out.println("Object Type is '" + obj.getClass().getName() + "' and Value is '" + obj +"'");



    }


    public <R> void genericDisplay(T obj){

        System.out.println("Object Type is '" + obj.getClass().getName() + "' and Value is '" + obj +"'");
    }


    public static void main(String[] args) {

        FirstGeneric<String> fgs = new FirstGeneric<>();
        fgs.printObject("Abrar");
        FirstGeneric<Integer> fgi = new FirstGeneric<>();
        fgi.printObject(10);
        FirstGeneric<Double> fgd = new FirstGeneric<>();
        fgd.printObject(10.0);


    }
}
