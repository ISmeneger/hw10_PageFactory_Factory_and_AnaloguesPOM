package Ilya_S.fluentPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentLoginFormPage extends FluentBasePage {

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

    public FluentLoginFormPage(WebDriver driver) {
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    @Step("Login")
    public FluentLoginFormPage login(String login, String password) {
        type(usernameInput, login);
        type(passwordInputField, password);
        click(submitButton);
        return this;
    }

    @Step("Check success box present")
    public FluentLoginFormPage checkSuccessBoxPresent() {
        assertThat(isDisplayed(successBox)).isTrue();
        return this;
    }

    @Step("Check success box is not present")
    public FluentLoginFormPage checkSuccessBoxIsNotPresent() {
        assertThat(isDisplayed(successBox)).isFalse();
        return this;
    }

    @Step("Check invalid credentials box is present")
    public FluentLoginFormPage checkInvalidCredentialsBoxPresent() {
        assertThat(isDisplayed(invalidCredentialsBox)).isTrue();
        return this;
    }

    @Step("Check invalid credentials box is not present")
    public FluentLoginFormPage checkInvalidCredentialsBoxIsNotPresent() {
        assertThat(isDisplayed(invalidCredentialsBox)).isFalse();
        return this;
    }
}
