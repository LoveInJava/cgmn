package com.pre.kas.cglocal;

import java.util.Arrays;

public class Assesment {


    public static void main(String[] args) {
        Assesment assesment = new Assesment();
        assesment.mergeTwoSortedArray();

    }

    private void mergeTwoSortedArray() {

        int[] odd = {1,3,5,7};
        int[] even = {2,4,6,8};

        int[] merge = new int[even.length + odd.length];

        for (int i = 0; i < merge.length; i++) {

            if(i%2 == 0 ){

                merge[i] = odd[i/2];
            }else{
                merge[i] = even[i/2];
            }

        }

        System.out.println("Merged Array : "+ Arrays.toString(merge));

    }
}
