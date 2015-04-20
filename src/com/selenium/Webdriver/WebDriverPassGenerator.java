package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
/**
 * Created by Admin on 08.04.15.
 *
 * http://oxogamestudio.com/passwd.current2.htm
 *
 */

@RunWith(JUnit4.class)
public class WebDriverPassGenerator {

    public static WebDriver chromeDriver;
    public static String masterpass;
    public static String sitepath;
    public static String password;

    public static String WebDriverPassGenerator(WebDriver chromeDriver, String master, String site) {

//        ============= BY XPATH FOLLOWING w/o tags ==============
        chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).clear();
        chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).sendKeys(master);
        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).clear();
        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).sendKeys(site);
        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[2]")).click();

        return chromeDriver.findElement(By.xpath("//td[text()='Generated password']/following::input[1]")).getAttribute("value");

//        ============= BY XPATH simple ==============
//        chromeDriver.findElement(By.xpath("//input[@name='master']")).clear();
//        chromeDriver.findElement(By.xpath("//input[@name='master']")).sendKeys(master);
//        chromeDriver.findElement(By.xpath("//input[@name='site']")).clear();
//        chromeDriver.findElement(By.xpath("//input[@name='site']")).sendKeys(site);
//        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();
//        return chromeDriver.findElement(By.xpath("//input[@name='password']")).getAttribute("value");
//        ============= BY Name ==============
//        chromeDriver.findElement(By.name("master")).clear();
//        chromeDriver.findElement(By.name("master")).sendKeys(master);
//        chromeDriver.findElement(By.name("site")).clear();
//        chromeDriver.findElement(By.name("site")).sendKeys(site);




    }

    public static void compare (String genPass, String etalon) {
        if (genPass.equals(etalon)) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }
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

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://angel.net/~nic/passwd.current.html");
    }

    @After
    public void tearDown() {
        chromeDriver.quit();
    }

    //==================================================================
    @Test
    public void passwordIsCorrect() {
        setField ("Your master password", "123456789");
        setField("Site name", "gmail.com");
        generate ();
        String pwd = getField ("Generated password");
        Assert.assertEquals("WH&*YIUU", pwd);
    }
    //==================================================================


    @Test
    public void etalonGenereation(){
     Assert.assertEquals("Password is not matched!", WebDriverPassGenerator(chromeDriver, "12345678", "example@gmail.com"), "HjK5swsJTgkQ/@1a");
    }

    @Test
    public void blankMasterPass(){
        Assert.assertEquals("Password is not matched!", WebDriverPassGenerator(chromeDriver, "", "gmail.com"), "zmcHOAyf2oZm+@1a");
    }

    @Test
    public void blankSite(){
        Assert.assertEquals("Password is not matched!", WebDriverPassGenerator(chromeDriver, "12345678", ""), "9Ixm2r5Xnm41Q@1a");
    }

    @Test
    public void blankStrings(){
        Assert.assertEquals("Password is not matched!", WebDriverPassGenerator(chromeDriver, "", ""), "BaefBs8/Z/cm2@1a");
    }

    @Test
    public void longStrings(){
        Assert.assertEquals("Password is not matched!", WebDriverPassGenerator(chromeDriver, "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasds", "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasds"), "bZyCKVuD+vA3e@1a");
    }

    @Test
    public void specialSymbols(){
        Assert.assertEquals("Password is not matched!", WebDriverPassGenerator(chromeDriver, "%^*&#$^&^???", "%^*&#$^&^???"), "jSFRYvJbm17kb@1a");
    }

    @Test
    public void generateNameButton(){
       Assert.assertEquals("Name Button is not matched!", chromeDriver.findElement(By.xpath("//td/input[@value]")).getAttribute("value"), "Generate");
    }

    //tr[3]/td/input[@value]

    @Test
    public void titleCheck() {
           Assert.assertEquals("Title is not matched!", chromeDriver.getTitle(), "Password generator");
    }





//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\automation\\chromedriver.exe");
//
//       WebDriver chromeDriver = new ChromeDriver();
//        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
//        chromeDriver.get("http://angel.net/~nic/passwd.current.html");
//
//        System.out.println(WebDriverPassGenerator(chromeDriver, "12345678", "example@gmail.com"));
//        System.out.println(WebDriverPassGenerator(chromeDriver, "987654", "tratata@ukr.net"));
//        System.out.println(WebDriverPassGenerator(chromeDriver, "sdvsdgvsdgv", "ololo@mail.ru"));
//
//
//        compare(WebDriverPassGenerator(chromeDriver, "12345678", "example@gmail.com"), "HjK5swsJTgkQ/@1a");
//        compare(WebDriverPassGenerator(chromeDriver, "987654", "tratata@ukr.net"), "qQF9gaYo2e3Xu@1a");
//        compare(WebDriverPassGenerator(chromeDriver, "sdvsdgvsdgv", "ololo@mail.ru"), "eeIAx1TSumF0P@1a");
//
//
//
//
//    chromeDriver.quit();
//    }
}
