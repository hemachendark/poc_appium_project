package org.mobile.framework.pageObjects;

import io.appium.java_client.ios.IOSDriver;

import org.mobile.framework.appiumSetCapabilities.AppiumSetCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetPageObjects {

    PageObjectsInterface pageObjectsInterface;
    String pageObjectName;

    IOSDriver<?> driver;
    WebDriverWait wait;
    AppiumSetCapabilities appiumSetCapabilities = AppiumSetCapabilities.getInstance();


    public SetPageObjects(){
        this.driver= null;
        this.wait = null;
        this.pageObjectsInterface = null;
    }

    public SetPageObjects(String objectName) {
        this();
        this.pageObjectName = objectName;

    }

    private void setPageObject(PageObjectsEnum objName) {
        switch (objName) {
            case LOGINPAGE:
                this.pageObjectsInterface = new LoginPage(this.appiumSetCapabilities.getAndroidDriver(),this.appiumSetCapabilities.getWait());
                break;
            case HOMEPAGE:
                this.pageObjectsInterface =  new HomePage(this.appiumSetCapabilities.getAndroidDriver(), this.appiumSetCapabilities.getWait());
                break;
            case CustomerPage:
                this.pageObjectsInterface = new CustomerPage(this.appiumSetCapabilities.getAndroidDriver(),this.appiumSetCapabilities.getWait());
                break;
            default:

        }
    }

    public PageObjectsInterface  getPageObject(  ){

        switch(pageObjectName.toLowerCase().trim()) {

            case "login_page":
                this.setPageObject(PageObjectsEnum.LOGINPAGE);
                break;
            case "home_page":
                this.setPageObject(PageObjectsEnum.HOMEPAGE);
                break;
            case "customer_page":
                this.setPageObject(PageObjectsEnum.CustomerPage);
            default:
                this.pageObjectsInterface = null;
        }
         assert this.pageObjectsInterface != null;
        return this.pageObjectsInterface;


        }

    }


