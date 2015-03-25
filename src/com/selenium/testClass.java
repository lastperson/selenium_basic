package com.selenium;

/**
 * Created by Admin on 25.03.15.
 */
public class testClass {

    public static void main(String[] args) {
        //System.out.println("TestClass output");
        if (args[0].equals("Hello") && args[1].equals("Class")) {
            System.out.println("Success");
        }
        else {
            System.out.println("Good bye");
        }
    }
}
