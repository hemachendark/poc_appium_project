package org.mobile.framework.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;

public class LoginPage implements PageObjectsInterface{


    AppiumDriver<MobileElement> driver;
    Wait<WebDriver> wait;

    static final Logger logger = LogManager.getLogger(PageObjectsInterface.class.getName());


    By usernameTextField = By.xpath("//input[@id='signInFormUsername']");
    By passwordTextField = By.xpath("//input[@id='signInFormPassword']");
    By signInButton = By.xpath("//input[@id='signInFormUsername']");


    public LoginPage(AndroidDriver<AndroidElement> androidDriver, WebDriverWait wait){

        this.driver = null;
        this.wait =null;

    }
    public WebElement getWebElement(String elementName) throws InterruptedException {
        WebElement el = null;
        switch (elementName.toLowerCase()) {
            case "username_textfield":
                el = this.wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextField));
                break;
            case "password_textfield":
                el = this.wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextField));
                break;
            case "signin_button":
                el = this.wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
                break;

        }
        assert el !=null;

        return el;
    }

    public void typeText(String element, String text) throws InterruptedException {

        WebElement webElement = this.getWebElement(element);
        assert webElement != null;
        webElement.sendKeys(text);

    }

    public void clickWebElement(String elementName) throws InterruptedException {
        WebElement webElement = this.getWebElement(elementName);
        assert webElement != null;
        webElement.click();

    }

    public boolean verifyWebElementAttribute(String attributeName, String action, String expectedValue) throws InterruptedException {
        WebElement element = this.getWebElement(attributeName);
        String actualValue = element.getText().trim();
        logger.debug("Actual value = "+ actualValue);
        logger.debug("Expected value = "+ expectedValue);

        if(action.equals("contains")){
            return actualValue.contains(expectedValue.trim());
        } else if (action.equals("is_equal_to")) {
            return actualValue.equals(expectedValue);
        }else {

            logger.error(MessageFormat.format("Comparison type {0} is unsupported",action));
        }
        return false;
    }
}
