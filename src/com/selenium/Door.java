package com.selenium;


public class Door {

    public int height;
    public boolean isOpened;

    public Door(int h) {
        height = h;
        isOpened = false;
    }

    public void close(){
        isOpened = false;
        System.out.println("Closing door...");
    }

    public void print (Door door){
        System.out.println("Door height: " + door.height);
        if (door.isOpened)
        {
            System.out.println("Door is opened");
        }
        else
        {
            System.out.println("Door is closed");
        }

    }
}
