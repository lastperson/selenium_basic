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
import java.lang.*;


public class TranslatePage {

    private String mainLink = "https://translate.google.ru/";
    private String submitButton = "//input[@id='gt-submit']";
    private String inputField = ".//*[@id='source']";
    private String resultField = ".//*[@id='result_box']";
    private String playButton = "//span[@class='jfk-button-img']";
    private String langSwitch = ".//*[@id='gt-swap']";
    private String clearButton = ".//*[@id='gt-clear']";

    public String getRightLangDivButton() {
        return rightLangDivButton;
    }

    public String getLeftLangDivButton() {

        return leftLangDivButton;
    }

    private String leftLangDivButton = ".//*[@id='gt-sl-sugg']/div[3]";
    private String rightLangDivButton = ".//*[@id='gt-tl-sugg']/div[3]";

    public String getClearButton() {
        return clearButton;
    }

    public String getLangSwitch() {
        return langSwitch;
    }

    public String getPlayButton() {
        return playButton;
    }

    public String getMainLink() {
        return mainLink;
    }

    public String getSubmitButton() {
        return submitButton;
    }

    public String getInputField() {
        return inputField;
    }

    public String getResultField() {
        return resultField;
    }

    public void open() {
        TestHelper.getDriver().get(getMainLink());
    }

    public void sleepTime(int Timer) {
        try {
            Thread.sleep(Timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean isPresend(String xpath) {
        sleepTime(1000);
        return TestHelper.getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    public Boolean langIsPresent(String language) {
        TestHelper.getDriver().findElement(By.id("gt-sl-gms")).click();
        return TestHelper.getDriver().findElement(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[contains(text(),'" + language + "')]")).isDisplayed();
    }

    public void langSelectionLeft(String language) {
        //нажимаем кнопку для открытия языков
        TestHelper.getDriver().findElement(By.id("gt-sl-gms")).click();
        TestHelper.getDriver().findElement(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[contains(text(),'" + language + "')]")).click();
    }

    public void langSelectionRight(String language) {
        //нажимаем кнопку для открытия языков справа
        TestHelper.getDriver().findElement(By.xpath(".//div[@id='gt-tl-gms']")).click();
        TestHelper.getDriver().findElement(By.xpath(".//div[@id=\"gt-tl-gms-menu\"]//div[contains(text(),'" + language + "')]")).click();
    }

    public void submit() {
        TestHelper.getDriver().findElement(By.id("gt-submit")).click();
    }

    public String resultBox() {
        return TestHelper.getDriver().findElement(By.id("result_box")).getText();
    }

    public Boolean titleCheck(String title, String ulr) {
        TestHelper.getDriver().get(ulr);
        String siteTitle = TestHelper.getDriver().getTitle();
        if (title.equals(siteTitle)) {
            return true;
        } else {
            return false;
        }
    }

    public void enterText(String text) {
        TestHelper.getDriver().findElement(By.xpath(getInputField())).sendKeys(text);
    }

    public void linkTranslation(String firstLanguage, String secondLanguage, String text) {
        TestHelper.getDriver().get(getMainLink() + "#" + firstLanguage + "/" + secondLanguage + "/" + text);
    }


    public void checkTranslationCorrect(String etalonText) {
     Assert.assertEquals(TestHelper.getDriver().findElement(By.xpath(getResultField())).getText(), etalonText);
//        return TestHelper.getDriver().findElement(By.xpath(getResultField())).getText().equals(etalonText);
    }

    public Boolean checkInputFieldCorrect(String etalonText) {
        return TestHelper.getDriver().findElement(By.xpath(getInputField())).getAttribute("value").equals(etalonText);
    }


    public void langSwitch() {
        TestHelper.getDriver().findElement(By.xpath(getLangSwitch())).click();
    }

    public void clickClearButton() {
        TestHelper.getDriver().findElement(By.xpath(getClearButton())).click();
    }

    public Boolean langButtonCheck(String xpath, String language) {
        if (TestHelper.getDriver().findElement(By.xpath(xpath)).getText().equals(language))
        return true;
        else
            return false;

    }

    public String getText (WebElement e) {
        String tmp = e.getText();
        return new String(tmp.getBytes(Charset.forName("utf-8")));
    }


/*

public static boolean verifyPresent(String xpath) throws Exception {

        int counter = 0;
        while (driver.findElements(By.xpath(xpath)).size() == 0) {
            Thread.sleep(100);
            counter += 100;
            if (counter > WAIT_COUNTER) {
                return false;
            }
        }
        return true;
    }


public static boolean verifyNotEditable(String xpath) {

        WebElement element = getElement(xpath);
        String test = "test";

        try {
            element.sendKeys(test);
        } catch (WebDriverException e) {
            System.out.println("Cannot focus element");
            return true;
        }
        if (element.getAttribute("value").equals(test)) return false;
        return true;
    }


 */


}
