package PageObjects;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseDriver {
    public AppiumDriver<WebElement> driver;

    @Before
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium-version", "1.6.5");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("app", "/Users/usource/Desktop/todo/todo.apk");

        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        if(driver != null) {
            driver.quit();
        }
    }

    public void captureScreenShots() throws IOException {
        // Framework's root directory
        String folderName = "Screenshots";
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Date format for screenshot file name
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        // Create directory with the given folder name
        new File(folderName).mkdir();

        // Setting file name
        String file_name = df.format(new Date())+".png";

        // Copy the screenshot to the Screenshots folder
        FileUtils.copyFile(file, new File(folderName + "/" + file_name));
    }
}
