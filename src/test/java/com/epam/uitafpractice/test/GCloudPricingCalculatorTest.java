package com.epam.uitafpractice.test;

import com.epam.uitafpractice.page.GooglePricingCalculatorPage;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GCloudPricingCalculatorTest extends CommonConditions {

  @Test(testName = "Pricing Calculator Form Test")
  public void pricingCalculatorFromTest() {
    GooglePricingCalculatorPage pricingCalculatorPage =
        new GooglePricingCalculatorPage(driver).openPage().fillForm();
    List<String> calculatedValues = pricingCalculatorPage.getTotalEstimatedCostValues();
    Assertions.assertThat(calculatedValues)
        .as("Calculated values is not as expected")
        .contains(
            "Region: Frankfurt",
            "Commitment term: 1 Year",
            "Local SSD: 2x375 GiB",
            "Estimated Component Cost: USD 4,024.56 per 1 month",
            "Instance type: n1-standard-8");
    String totalPrice = pricingCalculatorPage.getTotalEstimatedCost();
    Assert.assertEquals(
        totalPrice,
        "Total Estimated Cost: USD 4,024.56 per 1 month",
        "Error! calculated totall price is not as expected");
  }
}
