package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class TranslateTest {

    TranslatePage functions = new TranslatePage();

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
    public void blankTranslate_1() {
        functions.submit();
        Assert.assertEquals(functions.resultBox(), "");
    }

    @Test
    public void titleCheck_2() {
        Assert.assertTrue(functions.titleCheck("Переводчик Google", functions.getMainLink()));
    }


    @Test
    public void fieldsCheck_3() {
        functions.isPresend(functions.getSubmitButton());
        functions.isPresend(functions.getInputField());
        functions.isPresend(functions.getResultField());
    }


    @Test
    public void resultBoxEnterTest_4() {
        Assert.assertEquals(TestHelper.getDriver().findElement(By.xpath(functions.getResultField())).getTagName(), "span");
    }


    @Test
    public void langsPresentCheck_5() {
        functions.langIsPresent("греческий");
        functions.langIsPresent("мальтийский");
        functions.langIsPresent("словацкий");

    }

    @Test
    public void playButton_6() {
        functions.enterText("Hello");
        functions.isPresend(functions.getPlayButton());
    }

    @Test
    public void linkTranslate_7() {
        functions.linkTranslation("en", "ru", "hello");
        functions.sleepTime(5000);
        functions.checkTranslationCorrect("здравствуйте");
    }

    @Test
    public void checkSpanish_8() {

        functions.langSelectionLeft("испанский");
        functions.langSelectionRight("английский");
        functions.enterText("hello");
        functions.langSwitch();
        functions.sleepTime(1000);
        functions.checkTranslationCorrect("¡hola");

    }

    @Test
    public void clearResult_9() {
        functions.enterText("hello");
        functions.sleepTime(1000);
        functions.clickClearButton();
        functions.sleepTime(1000);
        functions.checkTranslationCorrect("");
    }

    @Test
    public void chineseTranslate_10() {
        functions.langSelectionLeft("украинский");
        functions.langSelectionRight("китайский (упрощенный)");
        functions.enterText("Слава Україні! Героям Слава!");
        functions.sleepTime(5000);
        functions.checkTranslationCorrect("光荣属于乌克兰！光荣属于英雄！");
    }

    @Test
    public void javanTranslate_11() {
        functions.linkTranslation("uk", "jw", "Hello");
        functions.sleepTime(2000);
        functions.checkTranslationCorrect("Hello");
        Assert.assertTrue(functions.checkInputFieldCorrect("Hello"));
        functions.sleepTime(1000);
        Assert.assertTrue(functions.langButtonCheck(functions.getLeftLangDivButton(), "украинский"));
        Assert.assertTrue(functions.langButtonCheck(functions.getRightLangDivButton(), "яванский"));

    }

    @Test
    public void fastLangButtonsDisplayed_12 () {
        Assert.assertTrue(functions.fastButtonsDisplayed());
    }




}

/*

//        List<String> langs = new ArrayList();
//        langs.add("греческий");
//        langs.add("мальтийский");
//        langs.add("словацкий");
//
//        List<WebElement> allLangs = TestHelper.getDriver().findElements(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[@class=\"goog-menuitem goog-option\"]"));

//        for (WebElement tmp:allLangs)
//
//            System.out.println(tmp.getText());

//        for (Object tmp2:langs)
//            System.out.println(String.valueOf(tmp2));

//        System.out.println(allLangs.containsAll(langs));


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
//       Assert.assertEquals(TestHelper.getDriver().findElement(By.xpath("//*[@id=\":i\"]/div")).getText(), "греческий");
//       Assert.assertEquals(TestHelper.getDriver().findElement(By.xpath("//*[@id=\":1f\"]/div")).getText(), "немецкий"); // мальтийский
//        Assert.assertEquals(TestHelper.getDriver().findElement(By.xpath(".//*[@id=':1x']/div")).getText(), "суданский"); //словацкий


 */
