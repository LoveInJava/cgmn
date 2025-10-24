package com.pre.core.overloadding;

public class CgAssessment {

    public static void main(String[] args) {
        CgAssessment assessment = new CgAssessment();
        assessment.m1("param1", "param2");
        assessment.m1(2, 2);
       // assessment.m1(null, null); // ambiguity bcoz both parameter accept null values when signature like public void m1(Integer a, Integer b)
       assessment.m1(null,4); // resolve second method
       assessment.m1(5,null); // resolve second method
    }

    public void m1(String s1, String s2){

        System.out.println("s1 = " + s1 + ", s2 = " + s2);
    }

    public void m1(Integer a, Integer b){

        System.out.println("Integer a = " + a + ", b = " + b);
    }

    public void m1(int a, int b){

        System.out.println("int a = " + a + ", b = " + b);
    }

    public void m1(Object objA, Object objB){

        System.out.println("objA = " + objA + ", objB = " + objB);
    }
}
