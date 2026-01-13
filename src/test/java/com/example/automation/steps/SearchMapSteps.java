package com.example.automation.steps;

import com.example.automation.pages.actions.SearchMapPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchMapSteps {

    private SearchMapPage searchMapPage = new SearchMapPage();

    @When("I enter city {string}")
    public void i_enter_city(String city) {
        searchMapPage.enterCity(city);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        searchMapPage.clickSearchButton();
    }

    @Then("I should see the city map")
    public void i_should_see_the_city_map() {
        Assert.assertTrue("Map should be displayed after search", searchMapPage.isMapDisplayed());
    }
    
    @Then("the search button should be disabled")
    public void the_search_button_should_be_disabled() {
        Assert.assertFalse("Search button should be disabled when input is empty", searchMapPage.isSearchButtonEnabled());
    }
    
    @Then("the search button should be enabled")
    public void the_search_button_should_be_enabled() {
        Assert.assertTrue("Search button should be enabled when text is entered", searchMapPage.isSearchButtonEnabled());
    }
}
