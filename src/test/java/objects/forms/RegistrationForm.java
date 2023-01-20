package objects.forms;

import framework.base.BaseForm;
import framework.base.elements.Button;
import framework.base.elements.InputField;
import framework.utils.WaitUtil;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationForm extends BaseForm {
    private static By locatorRegistrationForm = By.xpath("//*[@id='registration-form-modal']");
    private By fieldFirstName = By.xpath("//*[@id='firstName']");
    private By fieldLastName = By.xpath("//*[@id='lastName']");
    private By fieldEmail = By.xpath("//*[@id='userEmail']");
    private By fieldAge = By.xpath("//*[@id='age']");
    private By fieldSalary = By.xpath("//*[@id='salary']");
    private By fieldDepartment = By.xpath("//*[@id='department']");
    private By buttonSubmit = By.xpath("//*[@id='submit']");

    public RegistrationForm() {
        super(locatorRegistrationForm);
    }

    public void fillRegistrationForm(User user){
        fillInputField(fieldFirstName, user.getFirstName());
        fillInputField(fieldLastName, user.getLastName());
        fillInputField(fieldEmail, user.getEmail());
        fillInputField(fieldAge, Integer.toString(user.getAge()));
        fillInputField(fieldSalary, Integer.toString(user.getSalary()));
        fillInputField(fieldDepartment, user.getDepartment());
    }

    private void fillInputField(By locator, String text){
        InputField inputField = new InputField(locator, "Поле ввода данных на форме регистрации пользователя");
        inputField.setValue(text);
    }

    public void clickButtonSubmit() {
        Button button = new Button(buttonSubmit, "Кнопка Submit");
        button.click();
        button.waitInvisibilityOfElementLocated();
    }
}
