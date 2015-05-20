package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Admin on 18.05.15.
 */
public class BookingTest {

    BookingPage functions = new BookingPage();

    private String trainNumber = "043 К";
    private String vagonType = "Купе";
    private String city1Name = "Киев";
    private String city2Name = "Ивано-Франковск";
    private String month = "Июнь 2015";
    private String exactDate = "20";
    private String place = "Место: 31";
    private String vagonNumber = "#5";
    private String price = "212,70";
    private String lastName = "Селениум";
    private String firstName = "Василич";

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPrice() {
        return price;
    }

    public String getVagonNumber() {
        return vagonNumber;
    }

    public String getPlace() {
        return place;
    }

    public String getMonth() {
        return month;
    }

    public String getExactDate() {
        return exactDate;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getVagonType() {
        return vagonType;
    }

    public String getCity1Name() {
        return city1Name;
    }

    public String getCity2Name() {
        return city2Name;
    }

    @Before
    public void init() {
        TestHelper.init();
        functions.open(functions.getMainLink());
    }


    @After
    public void tearDown() {
        TestHelper.tearDown();
    }


    @Test
    public void open() {
        functions.sleepTime(2000);
    }

    @Test
    public void smokeTest() {


        functions.selectCity(functions.getFromField(), getCity1Name());
        functions.selectCity(functions.getToField(), getCity2Name());
        functions.selectDate(functions.getDepartureDate(getMonth(), getExactDate()));
        functions.clickSearch();
        functions.scrollDown(1);
        functions.selectTrain(getTrainNumber());
        functions.closeTrainRoute();
        functions.clickBuy(getTrainNumber(), getVagonType());
        functions.checkVagonAndPlace(getVagonNumber(), getPlace());
        functions.selectPlace(getPlace());
        functions.checkPrice(getPrice());
        functions.inputNames(getLastName(), getFirstName());



    }


}
