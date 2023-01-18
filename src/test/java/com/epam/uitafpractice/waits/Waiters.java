package com.epam.uitafpractice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Waiters {

    public static final int DEFAULT_TIME_OUT_IN_SECONDS = 10;

    private static WebElement waitForPresenceElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS)
            .until(presenceOfElementLocated(by));
    }

    public static WebElement waitForVisibilityElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS)
            .until(visibilityOfElementLocated(by));
    }

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS).until(visibilityOf(webElement));
    }

    public static List<WebElement> waitForVisibilityOfAllElements(
        WebDriver driver, List<WebElement> webElements) {
        return new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS)
            .until(visibilityOfAllElements(webElements));
    }

    public static List<WebElement> waitForPresenceOfAllElementsLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS)
            .until(presenceOfAllElementsLocatedBy(by));
    }

    public static WebElement waitForElementTobeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS)
            .until(elementToBeClickable(element));
    }
}
