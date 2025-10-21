package com.pre.cg.ev1;

public class Singleton {

    public static Singleton INSTANCE = null;

    private Singleton(){

    }

    public static Singleton getInstance(){

        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
