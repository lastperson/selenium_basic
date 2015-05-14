package com.selenium.Webdriver;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class GmailTest {

    GmailPage functions = new GmailPage();

    @Before
    public void init() {
        TestHelper.init();
        functions.open();
    }


    @After
    public void tearDown() {
        TestHelper.tearDown();
    }

    @Test
    public void open () {
        System.out.println(TestHelper.getDriver().getTitle());
        functions.sleepTime(2000);
    }

    @Test
    public void emailLogin () {
        functions.login("polikarpov.art", "svenoptima");
    }

    @Test
    public void createTextEmail () {
        functions.login("polikarpov.art", "svenoptima");
        functions.sleepTime(5000);
        functions.createTextEmail("artpol@ukr.net", "", "Проверка связи", "Тестовое письмо \n Хотелось бы изложить причину этого письма, но его нет \n Видимо тест прошёл, поздравляю");
        functions.sleepTime(5000);
        Assert.assertTrue(functions.emailIsSent());
    }


}
