package com.selenium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 01.04.15.
 */
public class MainLists {
    public static void main(String[] args) {
        String[] strarr = {"Hello", "Selemiun", "The", "Best", "Ever"};

        List<String> lst = new ArrayList<String>();

        lst.add("Hello");
        lst.add("Selenium");

        for (String s:strarr)
        System.out.println(s);

        System.out.println("");

        System.out.println(lst.get(0));
        System.out.println(lst.get(1));

        System.out.println(strarr.length);
        System.out.println(lst.size());

        for (String s:lst)
            System.out.println(s);

    }

}
