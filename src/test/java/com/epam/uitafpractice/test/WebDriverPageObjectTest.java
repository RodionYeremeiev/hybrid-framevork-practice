//package com.epam.uitafpractice.test;
//
//import com.epam.uitafpractice.page.GoogleCloudHomePage;
//import com.epam.uitafpractice.page.GooglePricingCalculatorPage;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.assertj.core.api.Assertions;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class WebDriverPageObjectTest extends CommonConditions {
//
//    public static final String GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT =
//        "Google Cloud Pricing Calculator";
//
////    private WebDriver driver;
//
////    @BeforeTest
////    public void setup() {
////        WebDriverManager.chromedriver().setup();
////        this.driver = new ChromeDriver();
////        driver.manage().window().maximize();
////    }
//
//    @Test(testName = "Search for Google Cloud Pricing Calculator Test")
//    public void searchForPricingCalculatorTest() {
//        List<WebElement> searchItemsList =
//            new GoogleCloudHomePage(driver)
//                .openPage()
//                .searchForPricingCalculator()
//                .getSearchItemsList();
//        Assert.assertTrue(
//            searchItemsList.stream()
//                           .anyMatch(element -> element.getText().contains(GOOGLE_CLOUD_PRICING_CALCULATOR_TEXT)),
//            "Error! Search for pricingCalculator FAILED !");
//        //
//        // driver.findElement(By.xpath("//*[contains(@data-cturl,'/products/calculator')]")).click();
//    }
//
//  @Test(testName = "Pricing Calculator Form Test")
//  public void pricingCalculatorFromTest() {
//    GooglePricingCalculatorPage pricingCalculatorPage =
//        new GooglePricingCalculatorPage(driver).openPage().fillForm();
//    List<String> calculatedValues = pricingCalculatorPage.getTotalEstimatedCostValues();
//    Assertions.assertThat(calculatedValues)
//        .as("Calculated values is not as expected")
//        .contains(
//            "Region: Frankfurt",
//            "Commitment term: 1 Year",
//            "Local SSD: 2x375 GiB",
//            "Estimated Component Cost: USD 4,024.56 per 1 month",
//            "Instance type: n1-standard-8");
//    String totalPrice = pricingCalculatorPage.getTotalEstimatedCost();
//    Assert.assertEquals(
//        totalPrice,
//        "Total Estimated Cost: USD 4,024.56 per 1 month",
//        "Error! calculated totall price is not as expected");
//  }
//
////    @AfterTest(alwaysRun = true)
////    public void tearDown() {
////        this.driver.quit();
////        this.driver = null;
////    }
//}
