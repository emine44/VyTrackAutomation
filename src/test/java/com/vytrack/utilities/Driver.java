package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }


    public static WebDriver getDriver(){
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Illegal browser name!");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }


    }





}