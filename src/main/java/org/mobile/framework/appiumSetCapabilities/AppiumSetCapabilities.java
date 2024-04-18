package org.mobile.framework.appiumSetCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetCapabilities {

    private static final Logger logger = LogManager.getLogger(AppiumSetCapabilities.class);

    public IOSDriver<IOSElement> iosDriver;
    public AndroidDriver<AndroidElement> androidDriver;
    public WebDriverWait wait;
    private static AppiumSetCapabilities instance;

    private AppiumSetCapabilities() {
        this.androidDriver = null;
        this.wait = null;
    }

    public static synchronized AppiumSetCapabilities getInstance(){
        if(instance == null){
            instance = new AppiumSetCapabilities();
        }
        return instance;
    }

    public void setDriver(String deviceName) throws MalformedURLException {
        if ("android".equals(deviceName.toLowerCase().trim())) {
            this.setAndroidDriver();
        } else {
            this.androidDriver = null;
        }
    }

    public void setAndroidDriver() throws MalformedURLException {
        logger.debug("Loading Android samsung  AppiumSetCapabilities");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10.0");
        caps.setCapability("automationName","Appium");
        caps.setCapability("deviceName", "Samsung 13pro");
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "00008020-000135E60E33002E");
        caps.setCapability("maxTypingFrequency", 30);
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps); //http://localhost:4723/wd/hub

    }

    public AndroidDriver<AndroidElement> getAndroidDriver() {
        assert  this.androidDriver != null;
        return androidDriver;
    }

    public IOSDriver<IOSElement> getIosDriver() {
        assert this.iosDriver !=null;
        return this.iosDriver;
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(this.androidDriver, 20);
    }

}
