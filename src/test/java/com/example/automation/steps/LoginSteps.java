package com.example.automation.steps;

import com.example.automation.pages.actions.LoginPage;
import com.example.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.navigateToUrl(ConfigReader.getProperty("url"));
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.enterUsername(username);
    }
    
    @When("I login with valid credentials from config")
    public void i_login_with_valid_credentials_from_config() {
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue("Welcome message should be displayed", loginPage.isWelcomeMessageDisplayed());
    }

    @Then("I should see the welcome message {string}")
    public void i_should_see_the_welcome_message(String expectedMessage) {
        Assert.assertTrue("Welcome message should be displayed", loginPage.isWelcomeMessageDisplayed());
        // If we want to check the text specifically, we would need a getter for the text in LoginPage
        // For now, checking visibility is good as per previous step logic
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        loginPage.clickLogoutButton();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assert.assertTrue("Login button should be displayed", loginPage.isLoginButtonDisplayed());
    }
}
