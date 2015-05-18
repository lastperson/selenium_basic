package com.selenium.Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Admin on 18.05.15.
 */
public class BookingPage {

    private String mainLink = "http://booking.uz.gov.ua/ru/";
    private String fromField = ".//*[@id='station_from']/input";
    private String toField = ".//*[@id='station_till']/input";
    private String dateField = ".//*[@id='date_dep']";
    private String searchButton = ".//*[@id='content']/form/p/button";
    private String departureDate = "html/body/div[2]/div/table/tbody/tr/td[2]/table/tbody/tr[3]/td[6]";
    private String city1Name = "Киев";
    private String city2Name = "Ивано-Франковск";

    public String getDepartureDate() {
        return departureDate;
    }

    public String getCity1Name() {
        return city1Name;
    }

    public String getCity2Name() {
        return city2Name;
    }

    public String getFromField() {
        return fromField;
    }

    public String getToField() {
        return toField;
    }

    public String getDateField() {
        return dateField;
    }

    public String getSearchButton() {
        return searchButton;
    }

    public String getMainLink() {
        return mainLink;
    }

    public void open(String xpath) {
        TestHelper.getDriver().get(xpath);
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

    public void selectCity(String xpath, String cityName) {
        System.out.println(get(xpath).getTagName());
        get(xpath).sendKeys(cityName);
        sleepTime(3000);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        sleepTime(3000);

    }

    public void clickSearch () {
        get(getSearchButton()).click();
        sleepTime(6000);

    }

    public void selectDate (String xpath) {
        get(getDateField()).click();
        sleepTime(2000);
        get(xpath).click();
    }

    public void scrollDown (int howmanyscrols) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        for (int i=1; i <= howmanyscrols; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }

        sleepTime(1000);
    }



}

