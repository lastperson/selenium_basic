package com.selenium.Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 06.04.15.
 */
public class WebDriverPassGenerator {

    public static String WebDriverPassGenerator(WebDriver chromeDriver, String master, String site) {
        chromeDriver.findElement(By.name("master")).clear();
        chromeDriver.findElement(By.name("master")).sendKeys(master);
        chromeDriver.findElement(By.name("site")).clear();
        chromeDriver.findElement(By.name("site")).sendKeys(site);
        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();

        return chromeDriver.findElement(By.name("password")).getAttribute("value");

    }

    public static void compare (String genPass, String etalon) {
        if (genPass.equals(etalon)) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }
    }


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");

       WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://angel.net/~nic/passwd.current.html");

        System.out.println(WebDriverPassGenerator(chromeDriver, "12345678", "example@gmail.com"));
        System.out.println(WebDriverPassGenerator(chromeDriver, "987654", "tratata@ukr.net"));
        System.out.println(WebDriverPassGenerator(chromeDriver, "sdvsdgvsdgv", "ololo@mail.ru"));


        compare(WebDriverPassGenerator(chromeDriver, "12345678", "example@gmail.com"), "HjK5swsJTgkQ/@1a");
        compare(WebDriverPassGenerator(chromeDriver, "987654", "tratata@ukr.net"), "qQF9gaYo2e3Xu@1a");
        compare(WebDriverPassGenerator(chromeDriver, "sdvsdgvsdgv", "ololo@mail.ru"), "eeIAx1TSumF0P@1a");




    chromeDriver.quit();
    }
}
