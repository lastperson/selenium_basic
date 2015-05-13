package com.selenium.Webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Timer;

/**
 * Created by Admin on 22.04.15.
 */
public class TestHelper {

    public static WebDriver driver;

    public static void init (){
//        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1600, 768));
    }

    public static void tearDown(){driver.quit();}

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        TestHelper.driver = driver;
    }


}
