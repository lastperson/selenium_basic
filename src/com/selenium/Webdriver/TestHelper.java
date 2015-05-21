package com.selenium.Webdriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 22.04.15.
 */
public class TestHelper {

    private static WebDriver driver;


    public static void init() {

//        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1500, 900));
    }

    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }



    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


}
