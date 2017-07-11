package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskCreation extends BaseDriver {
    @FindBy(id = "com.anydo:id/add_task")
    public WebElement addTaskButton;

    @FindBy(id = "com.anydo:id/autocomplete_textview")
    public WebElement writeSomething;

    @FindBy(id = "com.anydo:id/category_menu")
    public WebElement submitTodoBtn;

    @FindBy(id = "com.anydo:id/snackbar_text")
    public WebElement taskSuccessfullyCreated;

    public void createNewTodo(String value) {
        addTaskButton.click();
        writeSomething.sendKeys(value);
        submitTodoBtn.click();
    }
}
