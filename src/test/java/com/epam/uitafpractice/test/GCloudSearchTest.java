package com.epam.uitafpractice.test;

import com.epam.uitafpractice.page.GoogleCloudHomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GCloudSearchTest extends CommonConditions {

    public static final String GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT =
        "Google Cloud Pricing Calculator";

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
        //
        // driver.findElement(By.xpath("//*[contains(@data-cturl,'/products/calculator')]")).click();
    }

}
