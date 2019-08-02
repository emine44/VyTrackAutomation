package com.vytrack.tests.components.activities;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.vytrack.utilities.VYTrackUtils;

public class DateAndTimeTests extends TestBase {

 //   LoginPage loginPage =new LoginPage();
//
//    @Test
//    public void loginTests1(){
//        //DEMO
//        String username = ConfigurationReader.getProperty("storemanagerusername");
//        String password =ConfigurationReader.getProperty("storemanagerpassword");
//        loginPage.login(username,password);
//    }


    @Test
    public void DateTimeTest1(){
        String create ="//a[@title='Create Calendar event']";
        String startDate="//input[starts-with(@id, 'date_selector_oro_calendar_event_form_start')]";
        String endDate="//input[starts-with(@id, 'date_selector_oro_calendar_event_form_end-uid')]";
        String title ="//input[starts-with(@id, 'oro_calendar_event_form_title')]";
        String saveClose="btn btn-success action-button";
        VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(create)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath(title)).sendKeys("Team Meeting");
        SeleniumUtils.waitPlease(3);

        WebElement dateBox = driver.findElement(By.xpath(startDate));
        dateBox.click();



    }



    @Test
    public void DateTimeTest2(){

    }


    @Test
    public void DateTimeTest3(){

    }




}
