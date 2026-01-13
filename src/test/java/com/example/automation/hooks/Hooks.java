package com.example.automation.hooks;

import com.example.automation.base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (DriverFactory.getDriver() != null) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "step_screenshot");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Optional: Take screenshot on failure specifically if needed, 
        // though AfterStep covers it mostly.
        if (scenario.isFailed() && DriverFactory.getDriver() != null) {
             final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.attach(screenshot, "image/png", "failure_screenshot");
        }
        DriverFactory.quitDriver();
    }
}
