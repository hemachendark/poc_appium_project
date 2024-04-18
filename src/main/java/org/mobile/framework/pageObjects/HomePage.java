package org.mobile.framework.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.core.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage implements PageObjectsInterface {

    static final Logger logger = (Logger) LogManager.getLogger(HomePage.class.getName());

//    WebDriver driver;

    AppiumDriver<MobileElement> driver;
    Wait<WebDriver> wait;

    By agentID = By.xpath("//h3[@class='text-light']");
    By buyNowButton = By.xpath("//button[@class='create-order bg-primary text-light']");

    public HomePage(AndroidDriver<AndroidElement> androidDriver, WebDriverWait wait){
        this.driver = null;
        this.wait =null;


    }


    @Override
    public WebElement getWebElement(String productPurchaseScreenItems) throws InterruptedException {
        WebElement el = null;


        switch (productPurchaseScreenItems.toLowerCase()) {
            case "agentID_textfield":
                el = this.wait.until(ExpectedConditions.visibilityOfElementLocated(agentID));
                break;
            case "buyNow_button":
                el = this.wait.until(ExpectedConditions.visibilityOfElementLocated(buyNowButton));
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
            if(action.equals("contains")){
                return actualValue.contains(expectedValue.trim());
            } else if (action.equals("is_equal_to")) {
                return actualValue.equals(expectedValue);
            }
            return false;

    }
}
