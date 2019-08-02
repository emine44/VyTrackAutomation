package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuOptionsStoreManagerTest {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod(){

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        //1.Login	to	Vytrack	as driver
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);
    }

    @Test(priority=2)
    public void testDashboard(){
        //Navigate	to	Dashboards	àDashboard,	verify	page	title	Dashboard
        // -Dashboards,	verify	page	name	Dashboard
        String expectedT = "Dashboard";
        String actualT = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(actualT, expectedT);
        SeleniumUtils.waitPlease(3);
    }
    @Test(priority=3)
    public void testFleetToVehicle(){
        //Navigate	to	Fleet	àVehicles,	verify	page	title	Car	-Entities	-System	-Car
        // -Entities	-System,	page	name	All	Cars
        String expectedT = "All - Car - Entities - System - Car - Entities - System";
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Vehicles')]")).click();
        SeleniumUtils.waitPlease(3);
        String actualT = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(actualT, expectedT);
        SeleniumUtils.waitPlease(3);
    }

    @Test(priority=4)
    public void testCustomersToAccounts() {
        //Navigate	to	Customers	àAccounts,	verify	page	title	All-Accounts
        // –Customers,verify	page	name	All	Accounts
        String expectedT = "All - Accounts - Customers";
        driver.findElement(By.xpath("//span[contains(text(),'Customers')][1]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Accounts']")).click();
        SeleniumUtils.waitPlease(3);
        String actualT = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedT, actualT);
        SeleniumUtils.waitPlease(3);

    }
    //Navigate	to	Customers	àContacts,	verify	page	title	All-Contacts-Customers,
    // verify	page	name	All	Contacts
    @Test(priority=5)
    public void testCustomersToContacts() {
        String expectedT = "All - Contacts - Customers";
        driver.findElement(By.xpath("//span[contains(text(),'Customers')][1]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
        SeleniumUtils.waitPlease(3);
        String actualT = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedT, actualT);
        SeleniumUtils.waitPlease(3);

    }

   //Navigate	to	Sales	àOpportunities,	verify	page	title	Open	Opportunities	-Opportunities
   // -Sales,	verify	page	name	Open	Opportunities

    @Test(priority=6)
    public void testSalesToOpportunities() {
        String expectedT = "Open Opportunities - Opportunities - Sales";
        driver.findElement(By.xpath("//span[contains(text(),'Sales')]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
        SeleniumUtils.waitPlease(3);
        String actualT = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedT, actualT);
        SeleniumUtils.waitPlease(3);
    }

//Navigate	to	Activities	àCalls	verify	page	title	All	-Calls-Activities,
// page	name	All	Calls

    @Test(priority=7)
    public void testActivitiesToCalls() { ;
        String  expectedT="All - Calls - Activities";
        driver.findElement(By.xpath("//span[contains(text(),'Activities')][1]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Calls']")).click();
        SeleniumUtils.waitPlease(3);
        String  actualT =driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedT,actualT);
        SeleniumUtils.waitPlease(3);
    }



    //Navigate	to	Activities	àCalendar	Events,	verify	page	title	Calendar	Events	-Activities,
    // page	name	All	Calendar	Event

    @Test(priority=8)
    public void testActivitiesToCalender() {
        String  expectedT="All - Calendar Events - Activities";
        driver.findElement(By.xpath("//span[contains(text(),'Activities')]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Calendar Events']")).click();
        SeleniumUtils.waitPlease(3);
        String  actualT =driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertEquals(expectedT,actualT);
        SeleniumUtils.waitPlease(3);
    }


    @AfterMethod
    public void afterMethod(){
        driver.close();
    }


}