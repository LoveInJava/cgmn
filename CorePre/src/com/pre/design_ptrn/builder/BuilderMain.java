package com.pre.design_ptrn.builder;

public class BuilderMain {
    public static void main(String[] args) {

        try {


        Student student = Student.Builder
                .newInstance()
                .setId(1)
                .setName("Aasif")
                .setAddress("Mandi")
                .build();

        System.out.println("Student : "+student);
        }catch (IndexOutOfBoundsException | NullPointerException | ArithmeticException e){
            e.printStackTrace();
        }
    }
}
