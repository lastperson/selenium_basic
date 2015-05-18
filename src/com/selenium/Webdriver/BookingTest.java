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

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getVagonType() {
        return vagonType;
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



        functions.selectCity(functions.getFromField(), functions.getCity1Name());
        functions.selectCity(functions.getToField(), functions.getCity2Name());
        functions.selectDate(functions.getDepartureDate());
        functions.clickSearch();
        functions.scrollDown(1);
        functions.selectTrain(getTrainNumber());
        functions.closeTrainRoute();

        functions.clickBuy(getTrainNumber(), getVagonType());


    }


}
