package com.selenium.ClassesAndObjects;

/**
 * Created by Admin on 06.04.15.
 */
public class SumFunc {

    public static int sum (int k, int u) {
        int res = k + u;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sum(5, 7));
        System.out.println(sum(55, 27));
        System.out.println(sum(23, 5));
    }
}
