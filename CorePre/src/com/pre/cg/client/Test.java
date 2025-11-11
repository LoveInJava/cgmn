package com.pre.cg.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "b", "c");

        HashMap<String, Integer> hashMap = getStringIntegerHashMap(list);
        System.out.println("map:"+hashMap);
        System.out.println("Generic :"+getStringIntegerHashMapGen(list));
    }


    private static <T> HashMap<T, Integer> getStringIntegerHashMapGen(List<T> list) {
        HashMap< T, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i), hashMap.getOrDefault(list.get(i),0)+1);
        }
        return hashMap;
    }


    private static HashMap<String, Integer> getStringIntegerHashMap(List<String> list) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i), hashMap.getOrDefault(list.get(i),0)+1);
        }
        return hashMap;
    }
}
