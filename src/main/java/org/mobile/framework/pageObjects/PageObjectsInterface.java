package org.mobile.framework.pageObjects;

import org.openqa.selenium.WebElement;

public interface PageObjectsInterface {


    public WebElement getWebElement(String elementName)throws InterruptedException;


    public void typeText(String element, String text) throws InterruptedException;
    public void clickWebElement(String elementName) throws InterruptedException;
    public boolean verifyWebElementAttribute(String attributeName,String action,String expectedValue) throws InterruptedException;


}

