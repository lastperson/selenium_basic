package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by Admin on 29.04.15.
 */
public class TranslatePageObj {

    public static void open (){ TestHelper.driver.get("https://translate.google.ru/"); }

    @Before
    public void init(){
        TestHelper.init();
        TranslatePageObj.open();
    }


    @After
    public void tearDown() {
        TestHelper.tearDown();
    }

@Test
    public void blankTranslate_1 (){
        TestHelper.driver.findElement(By.id("gt-submit")).click();
        Assert.assertEquals(TestHelper.driver.findElement(By.id("result_box")).getText(), "");
    }

@Test
    public void titleCheck_2 (){
    String titleEtalon = "Переводчик Google";
    Assert.assertEquals(titleEtalon, TestHelper.driver.getTitle());
    }


@Test
    public void fieldsCheck_3 (){
    TestHelper.driver.findElement(By.id("gt-submit")).isDisplayed();
    TestHelper.driver.findElement(By.id("gt-src-wrap")).isDisplayed();
    TestHelper.driver.findElement(By.id("result_box")).isDisplayed();
}
    @Test
    public void resultBoxEnterTest_4 (){
        Assert.assertEquals(TestHelper.driver.findElement(By.id("result_box")).getTagName(), "span");
    }

    @Test
    public void langsPresentCheck () {
        //нажимаем кнопку для открытия языков
        TestHelper.driver.findElement(By.id("gt-sl-gms")).click();
       Assert.assertEquals(TestHelper.driver.findElement(By.xpath("//*[@id=\":i\"]/div")).getText(), "греческий");
       Assert.assertEquals(TestHelper.driver.findElement(By.xpath("//*[@id=\":1f\"]/div")).getText(), "немецкий"); // мальтийский
        Assert.assertEquals(TestHelper.driver.findElement(By.xpath(".//*[@id=':1x']/div")).getText(), "суданский"); //словацкий


       

    }






}
