package com.selenium.ClassesAndObjects;

/**
 * Created by Admin on 30.03.15.
 */
public class doorOperator {
    public static void main(String[] args) {
        Door k = new Door(100);
        Door l = new Door(200);
        Door door = new Door(300);
        int d = k.height;
        d = l.height;

        k.isOpened = true;
        k.height = 500;
        k.close();

//        if (k.isOpened) {
//            System.out.println("Door is opened");
//        }
//        else {
//            System.out.println("Door is closed");
//        }

        door.print(k);


    }
}
