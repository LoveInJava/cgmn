package com.pre.core.exception.inheritance;

class Test {
    static int test() {
//        int x = 0;
//        try {
//            x = 10;
//            return x;
//        } finally {
//            x = 20;
//        }

        try {
            int y = 10 / 0;
            return 1;
        } catch (RuntimeException e) {
            return 2;
        } catch (Exception t) {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}