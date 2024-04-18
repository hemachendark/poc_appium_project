package org.mobile.framework.StepDefinations;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mobile.framework.appiumSetCapabilities.AppiumSetCapabilities;
import org.mobile.framework.pageObjects.CustomerPage;
import org.mobile.framework.pageObjects.HomePage;
import org.mobile.framework.pageObjects.LoginPage;
import org.mobile.framework.pageObjects.SetPageObjects;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.text.MessageFormat;

public class StepDefinitions {
    private static final Logger logger = LogManager.getLogger(StepDefinitions.class.getName());
    SetPageObjects setPageObjects;
    LoginPage loginPage;
    HomePage homePage;
    CustomerPage customerPage;
    AndroidDriver<AndroidElement> androidDriver;
    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    AppiumSetCapabilities appiumSetCapabilities = AppiumSetCapabilities.getInstance();


    @Given("^the user opens \"([^\"]*)\"  with appium$")
    public void theUserOpensWithAppium(String deviceName) throws MalformedURLException {

        logger.debug(MessageFormat.format("Loading \"{0}\" device", deviceName));
        this.appiumSetCapabilities.setDriver(deviceName);
        this.androidDriver = appiumSetCapabilities.getAndroidDriver();
        this.wait = this.appiumSetCapabilities.getWait();
        this.loginPage = new LoginPage(this.androidDriver, this.appiumSetCapabilities.getWait());
        this.homePage = new HomePage(this.androidDriver, this.appiumSetCapabilities.getWait());
        this.customerPage =new CustomerPage(this.androidDriver, this.appiumSetCapabilities.getWait());

    
    }

    @And("the user navigate to the {string} url")
    public void theUserNavigateToTheUrl() {
        try {
            Thread.sleep(10000);
            this.driver.get("https://isa-qa.jdg.co.za");

        } catch (Exception e) {
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }

    }

    @And("the user types {string} into  the {string} textField on {string} page")
    public void theUserTypesIntoTheTextFieldOnPage(String elementName, String value, String objectName) {

        try {
            Thread.sleep(10000);
            this.setPageObjects = new SetPageObjects(objectName);
            this.setPageObjects.getPageObject().typeText(elementName,value);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while typing text into \"{0}\"", elementName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }
        
    }

    @And("the user clicks the {string} button on {string} page")
    public void theUserClicksTheButtonOnPage(String elementName, String objectName) {

        try {
            Thread.sleep(10000);

            this.setPageObjects = new SetPageObjects(objectName);
            this.setPageObjects.getPageObject().clickWebElement(elementName);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while attempting to tap  \"{0}\"", elementName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }
        
    }

    @And("the verify that web element attribute {string} action {string} text {string} on {string} page")
    public void theVerifyThatThatExistOnThePage(String attributeName, String action, String expectedValue, String objectName) {

        try {
            this.setPageObjects = new SetPageObjects(objectName);
            this.setPageObjects.getPageObject().verifyWebElementAttribute(attributeName,action,expectedValue);
        } catch (Exception e) {
            logger.error(MessageFormat.format("An unexpected exception occurred while attempting verify \"{0}\"", attributeName));
            logger.debug(MessageFormat.format("Error message: \"{0}\"", e.getMessage()));
            logger.debug(MessageFormat.format("Error cause: \"{0}\"", e.getCause()));
            logger.debug(MessageFormat.format("Error localized message: \"{0}\"", e.getLocalizedMessage()));
            e.printStackTrace();
        }

    }
}
