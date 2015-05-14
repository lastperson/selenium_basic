package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;


public class GmailPage {

    private String mainLink = "https://mail.google.com/mail/";
    private String inputEmail = ".//*[@id='Email']";
    private String nextButton = ".//*[@id='next']";
    private String inputPass = ".//*[@id='Passwd']";
    private String signInButton = ".//*[@id='signIn']";
    private String createEmailButton = ".//*[@gh='cm']"; //   .//*[@id=':8f']/div/div
    private String toField = ".//textarea[@aria-label='Кому']";
    private String ccFieldLink = ".//span[contains(text(),'Копия')]";
    private String ccField = ".//textarea[@aria-label='Копия']";
    private String subjectField = ".//input[@placeholder='Тема']";
    private String bodyField = ".//div[@aria-label='Тело письма']";
    private String sendButton = ".//div[contains(text(),'Отправить')]";
    private String mailSentText = ".//*[@class='vh']"; //Письмо отправлено

    public String getMailSentText() {
        return mailSentText;
    }

    public String getCcFieldLink() {
        return ccFieldLink;
    }

    public String getSendButton() {
        return sendButton;
    }

    public String getSubjectField() {
        return subjectField;
    }

    public String getBodyField() {
        return bodyField;
    }

    public String getCcField() {
        return ccField;
    }

    public String getToField() {
        return toField;
    }

    public String getCreateEmailButton() {
        return createEmailButton;
    }

    public String getSignInButton() {
        return signInButton;
    }

    public String getInputPass() {
        return inputPass;
    }

    public String getNextButton() {
        return nextButton;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void login(String login, String pass) {
        get(getInputEmail()).sendKeys(login);
        get(getNextButton()).click();
        sleepTime(2000);
        get(getInputPass()).sendKeys(pass);
        sleepTime(2000);
        get(getSignInButton()).click();
        sleepTime(2000);
    }

    public String getMainLink() {
        return mainLink;
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

    public WebElement get(String xpath) {
        return TestHelper.getDriver().findElement(By.xpath(xpath));
    }

    public void createTextEmail(String to, String cc, String subject, String body) {
        get(getCreateEmailButton()).click();
        sleepTime(2000);
        get(getToField()).sendKeys(to);
        get(getSubjectField()).sendKeys(subject);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_C);
        sleepTime(2000);
//        get(getCcFieldLink()).click();
        get(getCcField()).sendKeys(cc);
        get(getSubjectField()).sendKeys(subject);
        get(getBodyField()).sendKeys(body);
        get(getSendButton()).click();


        sleepTime(2000);
    }

    public Boolean emailIsSent() {
        return get("div[contains(text(),'" + "Письмо отправлено" + "')]").isDisplayed();
    }



    public void clickCcField () {
        get(".//span[contains(text(),'Копия')]").click();
    }
 /*

    public void setCcField (String cc) {
        get("div[contains(text(),'" + "Получатели" + "')]").sendKeys(cc);
    }

*/


}
