package com.epam.uitafpractice.test;

import com.epam.uitafpractice.page.GoogleCloudHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;



public class GCloudSearchTest extends CommonConditions {

    private final String GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT =
        "Google Cloud Pricing Calculator";
    private final Logger logger = LogManager.getRootLogger();

    @Test(testName = "Search for Google Cloud Pricing Calculator Test")
    public void searchForPricingCalculatorTest() {
        List<WebElement> searchItemsList =
            new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculator()
                .getSearchItemsList();
        Assert.assertTrue(
            searchItemsList.stream()
                           .anyMatch(element -> element.getText().contains(GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT)),
            "Error! Search for pricingCalculator FAILED !");
    }

}
