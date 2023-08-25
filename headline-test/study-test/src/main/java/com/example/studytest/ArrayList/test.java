package com.example.studytest.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author hhy
 * @PackageName headline
 * @Package com.example.studytest.ArrayList
 * @Date 2023/8/25 16:03
 * @return
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.add("data01");
        array.add(22);
        array.add(0, 00);
        array.add(1, 00);
        System.out.println(array);
        System.out.println(array.get(0));
        System.out.println(array.size());
        System.out.println(array.contains(11));
        Iterator iterator = array.iterator();
        while (iterator.hasNext()){
            Object element = iterator.next();
            System.out.println(element);
        }




    }
}
