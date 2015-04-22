package com.selenium.Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 22.04.15.
 */
public class GenPassPage {

    public static void generate() {
        TestHelper.driver.findElement(By.xpath("//td/input[@value]")).click();
    }

    public static void setField (String label, String value){
        TestHelper.driver.findElement(By.xpath("//td[text()='"+label+"']/following::input[1]")).clear();
        TestHelper.driver.findElement(By.xpath("//td[text()='" + label + "']/following::input[1]")).sendKeys(value);
    }

    public static String getField (String label){
        return TestHelper.driver.findElement(By.xpath("//td[text()='" + label + "']/following::input[1]")).getAttribute("value");
    }

    public static void open (){
        TestHelper.driver.get("http://angel.net/~nic/passwd.current.html");
    }
}
