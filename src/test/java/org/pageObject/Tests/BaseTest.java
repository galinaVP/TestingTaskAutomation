package org.pageObject.Tests;

import WDM.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static WDM.Driver.getDriver;

public class BaseTest {

    public static final String URL = "https://www.google.com/";

    @BeforeMethod(alwaysRun = true)
    public void webDriverManager() {
        getDriver().get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(ITestResult result) {
        if (!result.isSuccess()) {
            screenCapture();
        }
        Driver.killDriver();
    }

    @Attachment(type = "image/png")
    private byte[] screenCapture() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

