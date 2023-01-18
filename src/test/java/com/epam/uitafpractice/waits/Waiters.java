package com.epam.uitafpractice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {
    private static WebElement waitForPresenceElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForVisibilityElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static List <WebElement> waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> webElements) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public static List<WebElement> waitForPresenceOfAllElementsLocatedBy(WebDriver driver, By by) {
         return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
     }

    public static WebElement waitForElementTobeClickable(WebDriver driver, WebElement element){
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }


//             new WebDriverWait(driver, 10)
//            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("md-input-container")));

 }
