package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;



public class TranslatePage {

    public String mainLink = "https://translate.google.ru/";
    public String submitButton = "//input[@id='gt-submit']";
    public String inputField = "//textarea[@id='source']";
    public String resultField = "//*[@id='result_box']";
    private String playButton = "//span[@class='jfk-button-img']"; //СДЕЛАТЬ ВСЁ КАК ТУТ!!!!!!

    public String getPlayButton() {
        return playButton;
    }

    public void open (){ TestHelper.getDriver().get(mainLink); }

    public void sleepTime (int Timer) {
        try {
        Thread.sleep(Timer);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }}

    public Boolean isPresend (String xpath) {
        sleepTime(1000);
        return TestHelper.getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    public void langSelectionLeft (String language) {
        //нажимаем кнопку для открытия языков
        TestHelper.getDriver().findElement(By.id("gt-sl-gms")).click();
        TestHelper.getDriver().findElement(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[contains(text(),'" + language + "')]")).click();
    }

    public void langSelectionRight (String language) {
        //нажимаем кнопку для открытия языков справа
        TestHelper.getDriver().findElement(By.xpath(".//div[@id='gt-tl-gms']")).click();
        TestHelper.getDriver().findElement(By.xpath(".//div[@id=\"gt-tl-gms-menu\"]//div[contains(text(),'" + language +"')]")).click();
    }

    public void submit () {
        TestHelper.getDriver().findElement(By.id("gt-submit")).click();
    }

    public String resultBox () {
        return TestHelper.getDriver().findElement(By.id("result_box")).getText();
    }

    public Boolean titleCheck (String title, String ulr) {
        TestHelper.getDriver().get(ulr);
        String siteTitle = TestHelper.getDriver().getTitle();
        if (title.equals(siteTitle)) { return true; }
        else {
            return false;
        }
    }
    
    public void enterText (String text) {
        TestHelper.getDriver().findElement(By.xpath(inputField)).sendKeys(text);
    }
    
    public void linkTranslation (String firstLanguage, String secondLanguage, String text) {
        TestHelper.getDriver().get(mainLink + "#" + firstLanguage + "/" + secondLanguage + "/" + text);
    }

    
    public Boolean checkTranslationCorrect (String etalonText) {
        return TestHelper.getDriver().findElement(By.xpath(resultField)).getText().equals(etalonText);
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
