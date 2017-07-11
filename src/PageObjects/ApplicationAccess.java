package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationAccess extends BaseDriver {

    @FindBy(id = "com.anydo:id/login_main_already_member")
    public WebElement alreadyMember;

    @FindBy(id = "com.anydo:id/ob_premium_skip")
    public WebElement skipButton;

    @FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    public WebElement denyBtn;

    public void alreadyApplicationMember() {
        alreadyMember.click();

        skipButton.click();

        for (int i = 0; i < 3; i += 1) {
            denyBtn.click();
        }
    }
}
