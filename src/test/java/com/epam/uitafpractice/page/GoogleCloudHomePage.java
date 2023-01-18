package com.epam.uitafpractice.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.epam.uitafpractice.waits.Waiters;

public class GoogleCloudHomePage extends AbstractPage{
    public static final String CLOUD_GOOGLE_HOME = "https://cloud.google.com/";
    public static final String GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT =
        "Google Cloud Pricing Calculator";

    @FindBy(xpath = "//devsite-search//input")
    private WebElement homePageSearchInput;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(CLOUD_GOOGLE_HOME);
        return this;
    }

    public GoogleCloudSearchResultsPage searchForPricingCalculator() {
        Waiters.waitForVisibilityOfElement(driver, homePageSearchInput);
        Actions builder = new Actions(driver);
        builder
            .moveToElement(homePageSearchInput)
            .click()
            .sendKeys(GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT)
            .sendKeys(Keys.ENTER)
            .perform();
        return new GoogleCloudSearchResultsPage(driver);
    }
}
