package com.selenium.Webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class WebDriverEntry {
    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://www.google.com");

        String title = chromeDriver.getTitle();

        System.out.println(title);

        WebElement str = chromeDriver.findElement(By.name("q"));
        str.sendKeys("qa factory", Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebElement button = chromeDriver.findElement(By.name("btnG"));
//        button.click();

        WebElement res = chromeDriver.findElement(By.id("rso")).findElement(By.tagName("a"));
        System.out.println(res.getText());

        List<WebElement> as = chromeDriver.findElements(By.tagName("a"));

        for (WebElement str1:as)
            System.out.println(str1.getAttribute("href"));

        str.clear();
        str.sendKeys("FPV Kyiv");
        WebElement button = chromeDriver.findElement(By.name("btnG"));
        button.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//
//
//
//        System.out.println(chromeDriver.getTitle());
//
//        if (chromeDriver.getTitle().contains("qa"))
//            System.out.println("----- Title check - OK");
//        else
//            System.out.println("----- Title check - FALSE");

        chromeDriver.quit();

    }
}
