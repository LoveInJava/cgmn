package com.pre.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ListDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        ArrayList<String> list = new ArrayList<>();
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);

        Object[] elementData = (Object[]) field.get(list);
        System.out.println("Initial Capacity "+ elementData.length);

        for (int i = 0; i < 16; i++) {
            list.add("Item " + i);
        }

        Object[] newElementData = (Object[]) field.get(list);
        System.out.println("Capacity New "+ newElementData.length);

    }
}
