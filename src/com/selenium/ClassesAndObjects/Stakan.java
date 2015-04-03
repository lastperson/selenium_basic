package com.selenium.ClassesAndObjects;



public class Stakan {

    public String name;
    public static String material = "Bumaga";
    public static int height = 10;
    public int fillPercent = 0;

    public Stakan (String name) {
        this.name = name;
    }

    public int fillPercent() {
        return fillPercent;
    }

    public void fill (int fill) {
//        this.fillPercent = this.fillPercent + fill;
        this.fillPercent += fill;
        if (this.fillPercent > 100) {
            this.fillPercent = 100;
            System.out.println(this.name +" perepolnen. Lishnee vylilos.");
        }
    }

    public int pour (){
        int vtemp = this.fillPercent;
        this.fillPercent = 0;
        return vtemp;
    }

    public String name (){
        return this.name;
    }

    public static int volume(int v) {
        return v*v;
    }







}
