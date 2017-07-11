package Tests;

import PageObjects.BaseDriver;
import PageObjects.FacebookAuthentication;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FacebookLogin extends BaseDriver {
    FacebookAuthentication facebookAuthentication = new FacebookAuthentication();

    @Test
    public void theFirstTest() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        PageFactory.initElements(new AppiumFieldDecorator(driver), facebookAuthentication);

        wait.until(ExpectedConditions.visibilityOf(facebookAuthentication.facebookBtn));
        facebookAuthentication.chooseFacebook();

        wait.until(ExpectedConditions.visibilityOf(facebookAuthentication.fbUsername));
        facebookAuthentication.authenticate("user@gmail.com", "password");
    }
}
