package com.epam.uitafpractice.page;

import com.epam.uitafpractice.waits.Waiters;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.uitafpractice.waits.Waiters.waitForVisibilityOfElement;

public class GooglePricingCalculatorPage extends AbstractPage {
  public static final String CLOUD_PRICING_CALCULATOR_PAGE =
      "https://cloudpricingcalculator.appspot.com/";

  public static final By inputContainer = By.tagName("md-input-container");

  @FindBy(xpath = "//input[contains(@ng-model,'computeServer.quantity')]")
  private WebElement numberOfInstancesInput;

  @FindBy(id = "select_115")
  private WebElement seriesDropDown;

  @FindBy(xpath = "//div[contains(text(),'N1')]")
  private WebElement n1SeriesDropDownValue;

  @FindBy(id = "select_value_label_86")
  private WebElement machineTypeDropDown;

  @FindBy(xpath = "//md-option//div[contains(text(),'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
  private WebElement n1DropDown8Cpu30GbOption;

  @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
  private WebElement addGpuCheckBox;

  @FindBy(xpath = "//md-select[@placeholder='GPU type']")
  private WebElement gpuTypeDropDown;

  @FindBy(xpath = "//*[contains(text(),'NVIDIA Tesla P100')]")
  private WebElement nVidiaTeslaP100Option;

  @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
  private WebElement numberOfGpuDropDown;

  @FindBy(
      xpath = "//md-option[contains(@ng-repeat,'supportedGpuNumbers')]/div[contains(text(),'1')]")
  private WebElement oneGpuOption;

  @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
  private WebElement localSsdDropDown;

  @FindBy(xpath = "//*[contains(text(),'2x375 GB')]")
  private WebElement two375GbOption;

  @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
  private WebElement dataCenterLocationDropDown;

  @FindBy(
      xpath =
          "//*[contains(@ng-repeat,'inputRegionText.computeServer')]/div[contains(text(),'Frankfurt (europe-west3)')]")
  private WebElement frankfurtDatacenterOption;

  @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
  private WebElement committedUsageDropDown;

  @FindBy(xpath = "//*[contains(@class,'md-active md-clickable')]//*[contains(text(),'1 Year')]")
  private WebElement oneYearUsageOption;

  @FindBy(xpath = "//button[contains(text(),'Add to Estimate') and not(@disabled='disabled')]")
  private WebElement addToEstimateButton;

  @FindBy(xpath = "//div[@class='cpc-cart-total']//b")
  private WebElement totalEstimatedCost;

  @FindBy(xpath = "//md-list-item/div")
  private List<WebElement> calculatedEstimatedValues;
  private final Logger logger = LogManager.getRootLogger();


  public GooglePricingCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public GooglePricingCalculatorPage openPage() {
    driver.get(CLOUD_PRICING_CALCULATOR_PAGE);
    logger.info("Google Cloud Pricing Calculator page is opened");
    return this;
  }

  public GooglePricingCalculatorPage fillForm() {
    // TODO consider to separate
    Waiters.waitForPresenceOfAllElementsLocatedBy(driver, inputContainer);

    numberOfInstancesInput.sendKeys("4");

    Waiters.waitForVisibilityOfElement(driver, seriesDropDown);
    seriesDropDown.click();
    Waiters.waitForVisibilityOfElement(driver, n1SeriesDropDownValue);
    n1SeriesDropDownValue.click();

    Waiters.waitForVisibilityOfElement(driver, machineTypeDropDown);
    machineTypeDropDown.click();
    Waiters.waitForVisibilityOfElement(driver, n1DropDown8Cpu30GbOption);
    n1DropDown8Cpu30GbOption.click();

    Waiters.waitForElementTobeClickable(driver, addGpuCheckBox);
    addGpuCheckBox.click();
    Waiters.waitForElementTobeClickable(driver, gpuTypeDropDown);
    gpuTypeDropDown.click();
    Waiters.waitForVisibilityOfElement(driver, nVidiaTeslaP100Option);
    nVidiaTeslaP100Option.click();

    Waiters.waitForElementTobeClickable(driver, numberOfGpuDropDown);
    numberOfGpuDropDown.click();
    Waiters.waitForVisibilityOfElement(driver, oneGpuOption);
    oneGpuOption.click();

    Waiters.waitForElementTobeClickable(driver, localSsdDropDown);
    localSsdDropDown.click();
    Waiters.waitForVisibilityOfElement(driver, two375GbOption);
    two375GbOption.click();

    Waiters.waitForElementTobeClickable(driver, dataCenterLocationDropDown);
    dataCenterLocationDropDown.click();

    Waiters.waitForVisibilityOfElement(driver, frankfurtDatacenterOption);
    frankfurtDatacenterOption.click();

    Waiters.waitForElementTobeClickable(driver, committedUsageDropDown);
    committedUsageDropDown.click();

    Waiters.waitForVisibilityOfElement(driver, oneYearUsageOption);
    oneYearUsageOption.click();

    addToEstimateButton.click();
    return this;
  }

  public List<String> getTotalEstimatedCostValues() {
    waitForVisibilityOfElement(driver, totalEstimatedCost);
    return calculatedEstimatedValues.stream()
        .map(element -> element.getText())
        .map(
            element ->
                element.replaceAll("Committed Use Discount applied", StringUtils.EMPTY).trim())
        .collect(Collectors.toList());
  }

  public String getTotalEstimatedCost() {
    waitForVisibilityOfElement(driver, totalEstimatedCost);
    return totalEstimatedCost.getText();
  }
}
