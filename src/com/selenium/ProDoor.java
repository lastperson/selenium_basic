package com.selenium;


public class ProDoor {

    public int height;
    public int width;
    public boolean isOpened;
    public boolean isLocked;

    public ProDoor (int height, int width, boolean isOpened, boolean isLocked){
        this.height = height;
        this.width = width;
        this.isOpened = isOpened;
        this.isLocked = isLocked;
    };

    public String toString() {
        String opened;
        String locked;
        if (this.isOpened) {
            opened = "yes";
        }
        else { opened = "no"; }

        if (this.isLocked) {
            locked = "yes";
        }
        else { locked = "no"; }

        return "Size: " + this.height + "x" + this.width + " mm\nOpened: " + opened + "\nLocked: " + locked;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    public void close() {
        if (this.isLocked) {
            System.out.println("Lock is in the way. Cannot close!");
            this.isOpened = true;
        }
        else
            this.isOpened = false;

    }

    public void open() {
        if (this.isLocked) {
            System.out.println("Door is locked. Cannot open!");
            this.isOpened = false;
        }
        this.isOpened = true;
    }

    public boolean isLocked () {
        if (this.isLocked) {return true;}
        else
        return false;
    }

    public boolean isClosed () {
        if (this.isOpened) {return false;}
        else
            return true;
    }




}


// Door info:
// Size: 1900x800 mm
// Opened: no
// Locked: yes