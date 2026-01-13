package com.example.automation.pages.locators;

import org.openqa.selenium.By;

public class SearchMapLocators {
    public static final By CITY_INPUT = By.cssSelector("form.search-bar input");
    public static final By SEARCH_BUTTON = By.xpath("//button[text()='Buscar']");
    public static final By CLEAR_BUTTON = By.xpath("//button[text()='Limpiar']");
    
    // Assuming Leaflet map container class based on "Leaflet" mention in page source
    public static final By MAP_CONTAINER = By.className("leaflet-container");
    
    // Assuming some result text or weather info appears
    // We will use a generic locator for any result container if map is not enough
    // But for now, let's stick to map presence as the primary success criteria
}
