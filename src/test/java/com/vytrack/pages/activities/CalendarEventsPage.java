package com.vytrack.pages.activities;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage {

    WebDriver driver = Driver.getDriver();

    @FindBy(css = "[title ='Create Calendar event']")
    public WebElement createCalendarEventBtn;

    @FindBy(css = "[id^='oro_calendar_event_form_title']")
    public WebElement titleInputLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startdate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "a[title='Grid Settings']")
    public WebElement gridSettingsElement;

    @FindBy(css = "a[title='Reset']")
    public WebElement resetBtnElement;

    @FindBy(className = "grid-header-cell__label")
    public List<WebElement> headers;


    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void selectGridSetting(String name, boolean yesOrNo){

        //click on grid options
        gridSettingsElement.click();
        //create locator for grid option based on the name
        String locator = "//td/label[text()='"+name+"']/../following-sibling::td/input";

        //find element
        WebElement gridOption = driver.findElement(By.xpath(locator));
        //if param yesOrNo is true, and checkbox is not selected yet
        //click on it
        //or
        //ckeckbox is selected and you want to unselect it
        if(yesOrNo && !gridOption.isSelected() ||
                yesOrNo ==false && gridOption.isSelected()){
            gridOption.click();
        }

    }

    //let's write a method
    //that will take a headername as parameter
    //and will try to look up for header name in the collection of headers
    // if header name was not found
    //return false
    // otherwise return true

    public boolean verifyHeaderExists(String headerNameOrColumnName){
        for(WebElement tableHeader: headers){
            if(tableHeader.getText().equals(headerNameOrColumnName)){
                return true;
            }
        }
        return false;
    }

}