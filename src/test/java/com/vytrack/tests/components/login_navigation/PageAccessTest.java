package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PageAccessTest {
    WebDriver driver;
    String userName, userName1;


    @BeforeMethod
    public void beforeMethod() {
        //Login	to	Vytrack	as	a	store manager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");


    }

    @Test

    public void VehicleContractsTestStore() {
        //1.Login	to	Vytrack	as store manager
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();

        SeleniumUtils.waitPlease(3);;

       String actual= driver.getCurrentUrl();
       String expected ="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        System.out.println(actual.equals(expected));


    }

    @Test
    public void VehicleContractsTestSalesManager(){

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager104");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();

        SeleniumUtils.waitPlease(3);

        String actual= driver.getCurrentUrl();
        String expected ="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        System.out.println(actual.equals(expected));

    }

    @Test
    public void VehicleContractsTesTruckDriver(){

        driver.findElement(By.id("prependedInput")).sendKeys("user39");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();

        SeleniumUtils.waitPlease(3);

   String actual= driver.findElement(By.xpath("//div[contains(text(),'permission')]")).getText();
   String expected ="You do not have permission to perform this action.";
   System.out.println(actual.equals(expected));

    }


    @AfterMethod
    public void afterMethod(){
        driver.close();
    }

}
