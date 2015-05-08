package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;




public class TranslateTest {

TranslatePage functions = new TranslatePage();

    @Before
    public void init(){
        TestHelper.init();
        functions.open();
    }


    @After
    public void tearDown() {
        TestHelper.tearDown();
    }

    @Test
    public void blankTranslate_1 (){
        functions.submit();
        Assert.assertEquals(functions.resultBox(), "");
    }

    @Test
    public void titleCheck_2 (){
        Assert.assertTrue(functions.titleCheck("Переводчик Google", functions.mainLink));
    }


    @Test
    public void fieldsCheck_3 (){
        //Кнопка перевода
        functions.isPresend(functions.submitButton);
//    Поле для ввода текста.
        functions.isPresend(functions.inputField);
//    Поле результата
        functions.isPresend(functions.resultField);
    }


    @Test
    public void resultBoxEnterTest_4 (){
        Assert.assertEquals(TestHelper.driver.findElement(By.xpath(functions.resultField)).getTagName(), "span");
    }



    @Test
    public void langsPresentCheck_5 () {
        //нажимаем кнопку для открытия языков
        TestHelper.driver.findElement(By.id("gt-sl-gms")).click();

        List langs = new ArrayList();
        langs.add("греческий");
        langs.add("мальтийский");
        langs.add("словацкий");

        List<WebElement> allLangs = TestHelper.driver.findElements(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[@class=\"goog-menuitem goog-option\"]"));

        for (WebElement tmp:allLangs)

            System.out.println(tmp.getText());

        for (Object tmp2:langs)
            System.out.println(String.valueOf(tmp2));

        System.out.println(allLangs.containsAll(langs));
//        Assert.assertTrue();


//        String[] arrayId = new String[langs.size()];
//        String[] languages = new String[langs.size()];
//
//        for (int i = 0; i < langs.size(); i++) {
//            System.out.print(i + ": id = '" + langs.get(i).getAttribute("id") + "' text = '");
//            System.out.println(langs.get(i).getText() + "'");
//            arrayId[i] = langs.get(i).getAttribute("id");
//            languages[i] = langs.get(i).getText();
//
//
//        }
//
//        System.out.println(Arrays.toString(arrayId));
//        System.out.println(Arrays.toString(languages));


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
        functions.enterText("Hello");
//            Смотрим, что отобразилась иконка прослушки
       functions.isPresend(functions.getPlayButton());
    }

    @Test
    public void linkTranslate_7 () {
//        Вводим ссылку https://translate.google.com/#en/ru/hello
        functions.linkTranslation("en", "ru", "hello");
//        Ищем поле результата и сверяем значение
        Assert.assertEquals(TestHelper.driver.findElement(By.xpath(functions.resultField)).getText(), "здравствуйте");
    }

    @Test
    public void checkSpanish_8 () {

        //нажимаем кнопку для открытия языков слева
        TestHelper.driver.findElement(By.id("gt-sl-gms")).click();
//        выбираем испанский язык слева
        TestHelper.driver.findElement(By.xpath(".//*[@id=':x']")).click();

        functions.sleepTime(1000);

        //нажимаем кнопку для открытия языков справа
        TestHelper.driver.findElement(By.xpath(".//div[@id='gt-tl-gms']")).click();
//        Выбираем  Английский справа
        functions.sleepTime(2000);
        TestHelper.driver.findElement(By.xpath(".//div[@id='goog-menuitem-group-1']/div[5]")).click();

        functions.sleepTime(5000);
    }

}
