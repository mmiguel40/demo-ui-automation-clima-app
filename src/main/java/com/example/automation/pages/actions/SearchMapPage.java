package com.example.automation.pages.actions;

import com.example.automation.base.BasePage;
import com.example.automation.pages.locators.SearchMapLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchMapPage extends BasePage {

    public void enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchMapLocators.CITY_INPUT));
        driver.findElement(SearchMapLocators.CITY_INPUT).clear();
        driver.findElement(SearchMapLocators.CITY_INPUT).sendKeys(city);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchMapLocators.SEARCH_BUTTON));
        driver.findElement(SearchMapLocators.SEARCH_BUTTON).click();
    }

    public void clickClearButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchMapLocators.CLEAR_BUTTON));
        driver.findElement(SearchMapLocators.CLEAR_BUTTON).click();
    }

    public boolean isMapDisplayed() {
        try {
            // Initial attempt with short timeout
            try {
                new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(SearchMapLocators.MAP_CONTAINER));
                return driver.findElement(SearchMapLocators.MAP_CONTAINER).isDisplayed();
            } catch (Exception e) {
                // Retry clicking search button (handling potential missed clicks or lack of
                // reaction)
                System.out.println("Map NOT found on first attempt, retrying search click...");
                if (isSearchButtonEnabled()) {
                    clickSearchButton();
                }
            }

            // Second attempt with longer timeout
            new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(SearchMapLocators.MAP_CONTAINER));
            return driver.findElement(SearchMapLocators.MAP_CONTAINER).isDisplayed();

        } catch (Exception e) {
            System.out.println("Map NOT found after retry. Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Source Snippet: "
                    + driver.getPageSource().substring(0, Math.min(driver.getPageSource().length(), 2000)));
            return false;
        }
    }

    public boolean isSearchButtonEnabled() {
        return driver.findElement(SearchMapLocators.SEARCH_BUTTON).isEnabled();
    }
}
