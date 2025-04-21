package Ilya_S.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterComponent {
    WebDriver driver;

    @FindBy(className = "text-muted")
    private WebElement textMuted;

    @FindBy(xpath = "//a[@href = 'https://bonigarcia.dev/']")
    private WebElement link;

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get muted text")
    public String getText() {
        return textMuted.getText();
    }

    @Step("Click to link")
    public void clickLink() {
        link.click();
    }

    @Step("Getting current url")
    public String getCurrentUrlInformationPage() {
        return driver.getCurrentUrl();
    }

}
