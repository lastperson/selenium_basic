package com.selenium.Webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 22.04.15.
 */
public class TestHelper {

    public static WebDriver driver;

    public static void init (){
//        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 768));
    }

    public static void tearDown(){driver.quit();}


}
