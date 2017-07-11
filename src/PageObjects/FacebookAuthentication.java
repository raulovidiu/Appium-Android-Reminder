package PageObjects;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FacebookAuthentication extends BaseDriver {
    @FindBy(id = "com.anydo:id/login_main_fb_btn")
    public WebElement facebookBtn;

    @FindBy(className = "android.widget.EditText")
    public WebElement fbUsername;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[3]/android.widget.EditText[2]")
    public WebElement fbPassword;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.view.View[3]/android.widget.Button[1]")
    public WebElement fbLogInButton;


    public void chooseFacebook() {
        facebookBtn.click();
    }


    public void authenticate(String username, String password) {
        fbUsername.sendKeys(username);
        fbPassword.sendKeys(password);
        fbLogInButton.click();
    }
}
