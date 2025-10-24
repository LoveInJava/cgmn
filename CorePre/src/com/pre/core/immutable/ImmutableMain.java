package com.pre.core.immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableMain {

    public static void main(String[] args) {
        // create a map and adding data
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");

        // create an immutable Student object
        Student s = new Student("GFG", 101, map);

        // accessing data
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());

        // try to modify the original map
        map.put("3", "third");
        System.out.println(s.getMetadata());

        // try to modify the map returned by getMetadata()
        s.getMetadata().put("4", "fourth");
        System.out.println(s.getMetadata());
    }
}
