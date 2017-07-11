package Tests;


import PageObjects.ApplicationAccess;
import PageObjects.BaseDriver;
import PageObjects.TaskCreation;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateTodo extends BaseDriver {
    TaskCreation taskCreation = new TaskCreation();
    ApplicationAccess appAccess = new ApplicationAccess();

    @Test
    public void createTodo() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        PageFactory.initElements(new AppiumFieldDecorator(driver), taskCreation);
        PageFactory.initElements(new AppiumFieldDecorator(driver), appAccess);

        appAccess.alreadyApplicationMember();

        wait.until(ExpectedConditions.visibilityOf(taskCreation.addTaskButton));
        taskCreation.createNewTodo("This is the Newly Created TODO!");

        wait.until(ExpectedConditions.visibilityOf(taskCreation.taskSuccessfullyCreated));
        Assert.assertEquals(true, taskCreation.taskSuccessfullyCreated.isDisplayed());
    }
}
