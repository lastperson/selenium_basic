package com.selenium.ClassesAndObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by artpol on 20.04.15.
 */
public class PassGeneratorOOP {

    public static WebDriver chromeDriver;

    public static String masterpass;
    public static String sitepath;
    public static String password;


    public static void master(String master) {
    masterpass = master;
    }

    public static void site(String site) {
    sitepath = site;
    }

    public static String master() {
    return masterpass;
    }

    public static String site() {
    return sitepath;
    }

    public static void generate() {
//        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://angel.net/~nic/passwd.current.html");
        chromeDriver.findElement(By.name("master")).clear();
        chromeDriver.findElement(By.name("master")).sendKeys(masterpass);
        chromeDriver.findElement(By.name("site")).clear();
        chromeDriver.findElement(By.name("site")).sendKeys(sitepath);
        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();

        password = chromeDriver.findElement(By.name("password")).getAttribute("value");
    }

    public static String password(){
        return password;
    }

    public static String title() {
        chromeDriver.get("http://angel.net/~nic/passwd.current.html");
        return chromeDriver.getTitle();
    }

    public static String button() {
        chromeDriver.get("http://angel.net/~nic/passwd.current.html");
        return chromeDriver.findElement(By.xpath("//td/input[@value]")).getAttribute("value");
    }
    
    public static void main(String[] args) {
        master("12345678");
        site("gmail.com");
        generate();
        System.out.println(password());
// W3Hdka0clbEI+@1a
        master("12345678");
        site("gmail.com");
        generate();
        System.out.println(password());
// W3Hdka0clbEI+@1a
        System.out.println(master());
// 12345678
        System.out.println(site());
// gmail.com
        System.out.println(title());
// Password generator
        System.out.println(button());
// Generate
        site("");
        generate();
        System.out.println(password());
// 9Ixm2r5Xnm41Q@1a

        chromeDriver.close();
    }
}
