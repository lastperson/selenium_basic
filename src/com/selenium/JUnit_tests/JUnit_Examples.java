package com.selenium.JUnit_tests;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Admin on 08.04.15.
 */
@RunWith(JUnit4.class)
public class JUnit_Examples {

@Test
    public void Test1(){
    Assert.fail();
}

    @Test
    public void Test2(){
        int a = 10;
        int b = 5;
        int expectedRes = 16;
        Assert.assertEquals("Expected result is wrong!", expectedRes, a + b);
        //Assert.assertTrue (expectedRes == (a + b));
    }

}
