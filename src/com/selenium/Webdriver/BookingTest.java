package com.selenium.Webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Admin on 18.05.15.
 */
public class BookingTest {

    BookingPage functions = new BookingPage(); // Если только один єкземляр то почему класс не статический? 
    TestHelper helper = new TestHelper(); // Если только один єкземляр то почему класс не статический? 

    // Если понадобится добавить тестьі с другими поездами/именами/местами/датами, будем создавать еще переменньіе?
    // Єти переменньіе должньі бьіть полезньіми/общими для всех тестов в єтом классе.
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

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getLastName() {
        return lastName;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getFirstName() {
        return firstName;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getPrice() {
        return price;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getVagonNumber() {
        return vagonNumber;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getPlace() {
        return place;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getMonth() {
        return month;
    }
    
    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getExactDate() {
        return exactDate;
    }
    
    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getTrainNumber() {
        return trainNumber;
    }
    
    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getVagonType() {
        return vagonType;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getCity1Name() {
        return city1Name;
    }

    // Зачем єта функция если внутри теста можно обращаться прямо к переменной?
    public String getCity2Name() {
        return city2Name;
    }

    @Before
    public void init() {
        helper.init();
    }


    @After
    public void tearDown() {
        helper.tearDown();
        // Єто сообщение вьіведетеся независимо от того прошли тестьі или упали.
        System.out.println("Congratulations. Tests are passed");
    }


    @Test // Что проверяет тест? Будет всегда проходить независимо не от чего.
    public void open() {
        functions.open(functions.getMainLink());
        functions.sleepTime(2000);
    }

    @Test
    public void smokeTest() {

        functions.open(functions.getMainLink()); // Почему не в ініт?
        functions.selectCity(functions.getFromField(), getCity1Name());
        functions.selectCity(functions.getToField(), getCity2Name());
        functions.selectDate(functions.getDepartureDate(getMonth(), getExactDate())); // selectDate не мог бьі принимать сразу месяц и день?
        functions.clickSearch();
        functions.scrollDown(1); // Для чего скроллим? Вебдрайвер всегда проскролливает за нас.
        functions.selectTrain(getTrainNumber());
        functions.closeTrainRoute();
        functions.clickBuy(getTrainNumber(), getVagonType());
        functions.checkVagonAndPlace(getVagonNumber(), getPlace());
        functions.selectPlace(getPlace());
        functions.checkPrice(getPrice());
        functions.inputNames(getLastName(), getFirstName());


    }


}
