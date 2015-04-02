package com.selenium.ClassesAndObjects;



public class Stakan {

    public String name;
    public static String material = "Bumaga";
    public static int height;
    public int fillPercent = 0;

    public Stakan (String name) {
        this.name = name;
    }

    public int fillPercent() {
        return fillPercent;
    }

    public void fill (int fill) {
        fill = this.fillPercent;
    }

    public int pour (){
        this.fillPercent = 0;
        return this.fillPercent;
    }








}
