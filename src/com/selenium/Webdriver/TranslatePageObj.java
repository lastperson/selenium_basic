package com.selenium.Webdriver;

import org.apache.xpath.SourceTree;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 29.04.15.
 */
public class TranslatePageObj {

    public static void open (){ TestHelper.driver.get("https://translate.google.ru/"); }

    public static void sleepTime (int Timer) {
        try {
        Thread.sleep(Timer);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }}

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
    //Кнопка перевода
    TestHelper.driver.findElement(By.id("gt-submit")).isDisplayed();
//    Поле для ввода текста
    TestHelper.driver.findElement(By.id("gt-src-wrap")).isDisplayed();
//    Поле результата
    TestHelper.driver.findElement(By.id("result_box")).isDisplayed();
}
    @Test
    public void resultBoxEnterTest_4 (){
        Assert.assertEquals(TestHelper.driver.findElement(By.id("result_box")).getTagName(), "span");
    }

    @Test
    public void langsPresentCheck_5 () {



        //нажимаем кнопку для открытия языков
        TestHelper.driver.findElement(By.id("gt-sl-gms")).click();


        List<WebElement> langs = TestHelper.driver.findElements(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[@class=\"goog-menuitem goog-option\"]"));

        String[] arrayId = new String[langs.size()];
        String[] languages = new String[langs.size()];

        for (int i = 0; i < langs.size(); i++) {
            System.out.print(i + ": id = '" + langs.get(i).getAttribute("id") + "' text = '");
            System.out.println(langs.get(i).getText() + "'");
            arrayId[i] = langs.get(i).getAttribute("id");
            languages[i] = langs.get(i).getText();


        }

        System.out.println(Arrays.toString(arrayId));
        System.out.println(Arrays.toString(languages));


//
//        for (WebElement tmp:langs)
//            System.out.println("1: "+tmp.getText());

//
//       Assert.assertEquals(TestHelper.driver.findElement(By.xpath("//*[@id=\":i\"]/div")).getText(), "греческий");
//       Assert.assertEquals(TestHelper.driver.findElement(By.xpath("//*[@id=\":1f\"]/div")).getText(), "немецкий"); // мальтийский
//        Assert.assertEquals(TestHelper.driver.findElement(By.xpath(".//*[@id=':1x']/div")).getText(), "суданский"); //словацкий


        /*
        Конечный элемент - div class=goog-menuitem-checkbox
        Start - div id=gt-sl-gms-menu
        //div[@id=\"gt-sl-gms-menu\"]//div[@class=\"goog-menuitem-checkbox\"]


         */

    }
        @Test
        public void playButton_6 (){
//            Вводим Hello
            TestHelper.driver.findElement(By.xpath("//textarea[@id=\"source\"]")).sendKeys("Hello");
//            Смотрим, что отобразилась иконка прослушки
            TestHelper.driver.findElement(By.xpath("//span[@class=\"jfk-button-img\"]")).isDisplayed();
        }

    @Test
    public void linkTranslate_7 () {
//        Вводим ссылку https://translate.google.com/#en/ru/hello
        TestHelper.driver.get("https://translate.google.com/#en/ru/hello");
//        Ищем поле результата и сверяем значение
        Assert.assertEquals(TestHelper.driver.findElement(By.id("result_box")).getText(), "здравствуйте");
    }

    @Test
    public void checkSpanish_8 () {

        //нажимаем кнопку для открытия языков слева
        TestHelper.driver.findElement(By.id("gt-sl-gms")).click();
//        выбираем испанский язык слева
        TestHelper.driver.findElement(By.xpath(".//*[@id=':x']")).click();

       sleepTime(1000);

        //нажимаем кнопку для открытия языков справа
        TestHelper.driver.findElement(By.xpath(".//div[@id='gt-tl-gms']")).click();
//        Выбираем  Английский справа
        sleepTime(2000);
        TestHelper.driver.findElement(By.xpath(".//div[@id='goog-menuitem-group-1']/div[5]")).click();

        sleepTime(5000);
    }
       








}
