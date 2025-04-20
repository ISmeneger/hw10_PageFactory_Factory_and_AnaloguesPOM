package Ilya_S.pageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormPage extends BasePage {
    private static final String LOGIN_FORM_URL = "login-form.html";
    public static final String LOGIN_FORM_TITLE = "Login form";

    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInputField;

    @FindBy(css = "button")
    WebElement submitButton;

    @FindBy(id = "success")
    WebElement successBox;

    @FindBy(id = "invalid")
    WebElement invalidCredentialsBox;

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get login form page url")
    public String getUrl() {
        return LOGIN_FORM_URL;
    }

    @Step("Input login")
    public void inputLogin(String login) {
        usernameInput.sendKeys(login);;
    }

    @Step("Input password")
    public void inputPassword(String password) {
        passwordInputField.sendKeys(password);;
    }

    @Step("Click submit button")
    public void submitButton() {
        submitButton.click();
    }

    @Step("Get successful message")
    public String getSuccessfulMessage() {
        return successBox.getText();
    }

    @Step("Get invalid message")
    public String getInvalidMessage() {
        return invalidCredentialsBox.getText();
    }
}
