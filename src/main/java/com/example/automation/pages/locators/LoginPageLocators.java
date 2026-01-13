package com.example.automation.pages.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    // Partition for Locators
    public static final By USERNAME_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.xpath("//button[text()='Ingresar']");
    public static final By WELCOME_MESSAGE = By.xpath("//h1[contains(text(),'Buscador de Clima y Mapas')]");
    public static final By ERROR_MESSAGE = By.xpath("//*[contains(text(), 'Usuario o contraseña incorrectos')]");
    public static final By LOGOUT_BUTTON = By.cssSelector(".logout-button");
}
