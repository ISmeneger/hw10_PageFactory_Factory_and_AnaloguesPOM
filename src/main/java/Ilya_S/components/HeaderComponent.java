package Ilya_S.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {
    WebDriver driver;

    @FindBy(className = "display-4")
    private WebElement title;

    @FindBy(xpath = "//h5[text()='Practice site']")
    private WebElement subTitle;

    @FindBy(className = "img-fluid")
    @CacheLookup
    private WebElement logo;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get title")
    public String getTitleText() {
        return title.getText();
    }

    @Step("Get subtitle")
    public String getSubTitleText() {
        return subTitle.getText();
    }

    @Step("Click to logo icon")
    public void clickLogo() {
        logo.click();
    }

    @Step("Getting current url")
    public String getCurrentUrlGitPage() {
        return driver.getCurrentUrl();
    }


}
