package Ilya_S.pageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    @Step("Open homepage")
    private void open() {
        driver.get(BASE_URL);
    }

    @Step("Get web title")
    public String getWebTitle() {
        return driver.getTitle();
    }

    //method -> open another Page Object
    @Step("Open Login form page")
    public LoginFormPage openLoginFormPage() {
        driver.findElement(By.linkText("Login form")).click();
        return new LoginFormPage(driver);
    }

    @Step("Open Dialog boxes page")
    public DialogBoxesPage openDialogBoxesPage() {
        driver.findElement(By.linkText("Dialog boxes")).click();
        return new DialogBoxesPage(driver);
    }
}
