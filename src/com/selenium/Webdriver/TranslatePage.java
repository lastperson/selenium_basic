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



    public void open (){ TestHelper.driver.get("https://translate.google.ru/"); }

    public void sleepTime (int Timer) {
        try {
        Thread.sleep(Timer);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }}

    public void langSelectionLeft (String language) {
        //нажимаем кнопку для открытия языков
        TestHelper.driver.findElement(By.id("gt-sl-gms")).click();
        TestHelper.driver.findElement(By.xpath(".//div[@id=\"gt-sl-gms-menu\"]//div[contains(text(),'" + language +"')]")).click();
    }

    public void langSelectionRight (String language) {
        //нажимаем кнопку для открытия языков справа
        TestHelper.driver.findElement(By.xpath(".//div[@id='gt-tl-gms']")).click();
        TestHelper.driver.findElement(By.xpath(".//div[@id=\"gt-tl-gms-menu\"]//div[contains(text(),'" + language +"')]")).click();
    }

    public void submit () {
        TestHelper.driver.findElement(By.id("gt-submit")).click();
    }

    public String resultBox () {
        return TestHelper.driver.findElement(By.id("result_box")).getText();
    }

    public Boolean titleCheck (String title, String ulr) {
        TestHelper.driver.get(ulr);
        String siteTitle = TestHelper.driver.getTitle();
        if (title.equals(siteTitle)) { return true; }
        else {
            return false;
        }
    }









}
