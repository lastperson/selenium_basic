package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Admin on 18.05.15.
 */
public class BookingTest {

    BookingPage functions = new BookingPage();

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
        System.out.println(TestHelper.getDriver().getTitle());
        functions.sleepTime(2000);
    }

    @Test
    public void smokeTest() {
        functions.selectCity(functions.getFromField(), functions.getCity1Name());
        functions.selectCity(functions.getToField(), functions.getCity2Name());
        functions.selectDate(functions.getDepartureDate());
        functions.clickSearch();
        functions.scrollDown(1);

    }


}
