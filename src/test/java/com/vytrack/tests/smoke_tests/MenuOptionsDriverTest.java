package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.BrowserFactory;
import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MenuOptionsDriverTest {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod(){

        WebDriverManager.chromedriver().setup();
       driver =new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        //1.Login	to	Vytrack	as driver
        driver.findElement(By.id("prependedInput")).sendKeys("user39");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);}

        @Test(priority=2)
        public void testFleetToVehicle(){

            //Navigate	to	Fleet	àVehicles,	verify	page	title	Car	-Entities	-System	-Car
            // -Entities	-System,	page	name	All	Cars
            String expectedT = "Car - Entities - System - Car - Entities - System";
            driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();

            driver.findElement(By.xpath("//span[contains(text(),'Vehicles')]")).click();
            SeleniumUtils.waitPlease(3);
            String actualT = driver.getTitle();
            Assert.assertEquals(actualT, expectedT);
            SeleniumUtils.waitPlease(3);

        }

          @Test(priority=3)
         public void testCustomersToAccounts() {

        //Navigate	to	Customers	-->Accounts,	verify	page	title	Accounts
        // -Customers,	verify	page	name	Accounts
        String expectedT = "Accounts - Customers";
        driver.findElement(By.xpath("//span[contains(text(),'Customers')][1]")).click();
              SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
              SeleniumUtils.waitPlease(3);
        String actualT = driver.getTitle();
        Assert.assertEquals(expectedT, actualT);
              SeleniumUtils.waitPlease(3);

       }
        //Navigate	to	Customers	àContacts,	verify	page	title	Contacts-Customers,
        // verify	page	name	Contacts
        @Test(priority=4)
        public void testCustomersToContacts() {

            String expectedT = "Contacts - Customers";
            driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.xpath("//span[text()='Contacts']")).click();
            SeleniumUtils.waitPlease(3);
            String actualT = driver.getTitle();
            Assert.assertEquals(actualT, expectedT);
            SeleniumUtils.waitPlease(3);


        }

        //Navigate	to	Activities	àCalendar	Events,	verify	page	title	Calendar	Events	-Activities,
        // page	name	Calendar	Events

        @Test(priority=5)
        public void testActivitiesToCalender() {

       String  expectedT="Calendar Events - Activities";
        driver.findElement(By.xpath("//span[contains(text(),'Activities')][1]")).click();
            SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Calendar Events']")).click();
            SeleniumUtils.waitPlease(3);
       String  actualT =driver.getTitle();
        Assert.assertEquals(expectedT,actualT);
            SeleniumUtils.waitPlease(3);
    }


    @AfterMethod
    public void afterMethod(){
        driver.close();
    }


}
