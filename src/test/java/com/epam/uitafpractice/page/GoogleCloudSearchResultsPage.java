package com.epam.uitafpractice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.epam.uitafpractice.waits.Waiters.waitForVisibilityOfElement;

public class GoogleCloudSearchResultsPage extends AbstractPage {

    @FindBy(className = "gs-title")
    private WebElement searchItem;

    @FindBy(className = "gs-title")
    private List<WebElement> searchItemsList;
    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please input search query on specific page first!");
    }

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchItemsList() {
        waitForVisibilityOfElement(driver, searchItem);
        return searchItemsList;
    }
}
