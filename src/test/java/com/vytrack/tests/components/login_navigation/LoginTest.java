package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
        WebDriver driver;
        String userName,userName1;



        @BeforeMethod
        public void beforeMethod() {
     //Login	to	Vytrack	as	a	store manager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("http://qa2.vytrack.com/user/login");

        }

        @Test(priority = 2)

        public void verifyPositiveLoginTest() {
            //1.Login	to	Vytrack	as store manager
            driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
            driver.findElement(By.id("_submit")).click();
            SeleniumUtils.waitPlease(3);

            //Verify	name	of	the	store	manageris	displayed	on	top
            userName = driver.findElement(By.id("user-menu")).getText();
            boolean isThere = userName.isEmpty();
            System.out.println("User name is on top " +userName + isThere);

            //Verify	Dashboad	page
            String actual = driver.getTitle();
            String expected = "Dashboard";
            boolean isDisplayed = actual.equals(expected);
            System.out.println("Is dashboard opened? "+isDisplayed);

            //Log out
            driver.findElement(By.id("user-menu")).click();
            driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
            System.out.println("We logged out");

        //5.Login	to	Vytrack	as sales manager
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager104");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
            System.out.println("We logged in as sales manager");
            SeleniumUtils.waitPlease(3);


        //6.Verify	Dashboad	page
        String actual1 = driver.getTitle();
        String expected1 = "Dashboard";
        boolean isDisplayed1 = actual1.equals(expected1);
        System.out.println("Is dashboard opened? "+isDisplayed1);

        //7. A	different	name	should	be	displayed	on
        userName1 = driver.findElement(By.id("user-menu")).getText();
        boolean isThere2 = !(userName1.equals(userName));
        System.out.println("Are user names different" + userName +"-"+userName1 +"-"+ isThere2);

        //8.Log	out
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
        System.out.println("We logged out");

         //9.Login	to	Vytrack	as truck driver
        driver.findElement(By.id("prependedInput")).sendKeys("user39");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
            SeleniumUtils.waitPlease(3);
            System.out.println("we logged in as a driver");

        //10.Verify	Dashboad	page
             String actual2 = driver.getTitle();
             String expected2= "Dashboard";
             boolean isDisplayed2 = actual2.equals(expected2);
             System.out.println("Is dashboard opened? "+isDisplayed2);


     //11. A	different	name	should	be	displayed	on
             String userName2 = driver.findElement(By.id("user-menu")).getText();

             boolean isDifferent = !(userName2.equals(userName) && userName2.equals(userName1));

             System.out.println("Driver's username is different than others? " + userName2+ "-"+userName1 + userName +"-"+isDifferent);

    }


    @Test(priority = 3)

    public void verifyNegativeLoginTest() {

        //1.Login	to	Vytrack	as store manager
        String expectedT = driver.getTitle();
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
        driver.findElement(By.id("prependedInput2")).sendKeys("User123");//invalid
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

        //Message	Invalid user name or password.should	be	displayed
        String actualT = driver.getTitle();
        String expected ="Invalid user name or password.";
        String actual =driver.findElement(By.xpath("//fieldset/div/div")).getText();
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expectedT,actualT);



    }

    @AfterMethod
    public void afterMethod(){
            driver.close();
    }






}

