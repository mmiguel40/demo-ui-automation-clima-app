package com.example.automation.pages.actions;

import com.example.automation.base.BasePage;
import com.example.automation.pages.locators.LoginPageLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // Partition for Methods/Actions
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_INPUT));
        driver.findElement(LoginPageLocators.USERNAME_INPUT).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.PASSWORD_INPUT));
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.LOGIN_BUTTON));
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    public boolean isWelcomeMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.WELCOME_MESSAGE));
        return driver.findElement(LoginPageLocators.WELCOME_MESSAGE).isDisplayed();
    }
    
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.ERROR_MESSAGE));
        return driver.findElement(LoginPageLocators.ERROR_MESSAGE).getText();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.LOGOUT_BUTTON));
        driver.findElement(LoginPageLocators.LOGOUT_BUTTON).click();
    }

    public boolean isLoginButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.LOGIN_BUTTON));
            return driver.findElement(LoginPageLocators.LOGIN_BUTTON).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
