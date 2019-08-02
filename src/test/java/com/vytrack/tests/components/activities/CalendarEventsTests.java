package com.vytrack.tests.components.activities;

import com.vytrack.pages.activities.CalendarEventsPage;
import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.testng.annotations.Test;

public class CalendarEventsTests extends TestBase {


    @Test
      public void verifyTitleColumn(){
        LoginPage loginPage = new LoginPage();

        CalendarEventsPage calendarPage =new CalendarEventsPage();

        String username=ConfigurationReader.getProperty("storemanagerusername");
        String password=ConfigurationReader.getProperty("storemanagerpassword");

          loginPage.login(username,password);

        VYTrackUtils.navigateToModule(driver,"Activities","Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear();

        calendarPage.selectGridSetting("Title",false);
        SeleniumUtils.waitPlease(15);

      }

}
