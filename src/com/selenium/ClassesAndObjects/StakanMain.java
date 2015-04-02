package com.selenium.ClassesAndObjects;


public class StakanMain {

    public static void main(String[] args) {
        Stakan s = new Stakan("Super");
        Stakan k = new Stakan("Bigger");
        System.out.println("s: " + s.name);
        System.out.println("k: " + k.name);
        System.out.println("Stakan: " + Stakan.material);
        System.out.println("Stakan: " + Stakan.height);
        System.out.println("s: " + s.fillPercent());
// s: Super
// k: Bigger
// Stakan: Bumaga
// Stakan: 10
// s: 0
        s.fill(30);
        System.out.println("s: " + s.fillPercent());
// s: 30
        int v = s.pour();
        System.out.println("v: " + v);
        System.out.println("k: " + k.fillPercent());
// v: 30
// k: 0
        k.fill(v);
        System.out.println("k: " + k.fillPercent());
// k: 30
        s.fill(k.pour());
        System.out.println("s: " + s.fillPercent());
        System.out.println("k: " + k.fillPercent());
// s: 30
// k: 0
        s.fill(50);
        System.out.println("s: " + s.fillPercent());
// s: 80
        s.fill(45);
// Super perepolnen. Lishnee vylilos.
        System.out.println("s: " + s.fillPercent());
// s: 100
        s.name = "ReSuper";
        System.out.println("s: " + s.name());
        System.out.println("k: " + k.name());
        System.out.println("volume Stakana vysotoy 20: " + Stakan.volume(20));
// s: ReSuper
// k: Bigger
// volume Stakana vysotoy 20: 400


    }

}
