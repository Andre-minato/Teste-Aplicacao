package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/apps/ToDo_1.24_APKPure.apk");
        capabilities.setCapability("skipDeviceInitialization", "true");
        capabilities.setCapability("appium:noReset", "true");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "16.2");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app",
                System.getProperty("user.dir")+"/apps/DailyCheck.zip");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}

