package com.epam.uitafpractice.test;

import com.epam.uitafpractice.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "test-automation-user";

    @BeforeMethod()
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
