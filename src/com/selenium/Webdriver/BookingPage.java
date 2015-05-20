package com.selenium.Webdriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    private String departureDate = ".//table[@class='grid']//table[@class='month']/caption[contains(text(), '"; //.//table[@class='grid']//table[@class='month']/caption[contains(text(), 'Июнь 2015')]//following::td[contains (text(), '20')][1]

    private String trainNumber = ".//*[@id='ts_res_tbl']"; // //a[contains(text(), '043 К')]
    private String closeTrainRouteButton = "html/body/div[6]/div[1]/a";

    public String getCloseTrainRouteButton() {
        return closeTrainRouteButton;
    }

    public String getTrainNumber(String train) {
        return trainNumber + "//a[contains(text(), '" + train + "')]";
    }

    public String getDepartureDate(String month, String exactDate) {
        return departureDate + month + "')]//following::td[contains (text(), '" + exactDate + "')][1]";
    }
// .//table[@class='grid']//table[@class='month']/caption[contains (text(), 'Июнь 2015')]//following::td[contains (text(), '20')][1]


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
        get(xpath).sendKeys(cityName);
        sleepTime(2000);
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

        sleepTime(1000);

    }

    public void clickSearch() {
        get(getSearchButton()).click();
        sleepTime(3000);

    }

    public void selectDate(String xpath) {
        get(getDateField()).click();
        sleepTime(2000);
        get(xpath).click();
        sleepTime(2000);
    }

    public void scrollDown(int howmanyscrols) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= howmanyscrols; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }
        sleepTime(1000);

    }

    public void selectTrain(String train) {
        get(getTrainNumber(train)).click();
        sleepTime(2000);
    }

    public void closeTrainRoute() {
        get(getCloseTrainRouteButton()).click();
        sleepTime(2000);
    }

    public void clickBuy(String train, String vagonType) {
        get("(.//td[@class='num']/a[contains(text(), '" + train + "')]/following::div[@title='" + vagonType + "']/button)[1]").click();
//        get("(.//td[@class='num']/a[contains(text(), '043 К')]/following::div[@title='Купе']/button)[1]").click();
    }



    /*
    Assert.assertEquals(2, TestHelpelper.resultCount()); //смотрим что у нас два результата
    WebElement sel = TestHelper.getDriver().findElement(By.name("time_dep"));
    Select s = new Select(sel);
    s.selectByVisibleText ("03:00");


    (.//td[@class='num']/a[contains(text(), '043 К')]/following::div[@title='Купе']/button)[1]

    (.//td[@class='num']/a[contains(text(), '" + train + "')]/following::div[@title='Купе']/button)[1]
    */


}

