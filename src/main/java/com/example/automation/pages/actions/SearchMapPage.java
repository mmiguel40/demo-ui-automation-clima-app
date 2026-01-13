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
            wait.until(ExpectedConditions.visibilityOfElementLocated(SearchMapLocators.MAP_CONTAINER));
            return driver.findElement(SearchMapLocators.MAP_CONTAINER).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isSearchButtonEnabled() {
        return driver.findElement(SearchMapLocators.SEARCH_BUTTON).isEnabled();
    }
}
