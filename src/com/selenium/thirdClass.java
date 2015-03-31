package com.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class thirdClass {
    public static void main(String[] args) {
   // System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200,768));
        chromeDriver.get("http://www.google.com");
        chromeDriver.findElement(By.className("gsfi")).sendKeys("Selenium works!!!");
        chromeDriver.findElement(By.name("btnG")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        chromeDriver.quit();

    }
}
