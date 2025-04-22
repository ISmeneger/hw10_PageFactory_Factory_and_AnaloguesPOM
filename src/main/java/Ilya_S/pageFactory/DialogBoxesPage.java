package Ilya_S.pageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogBoxesPage extends BasePage {
    private static final String DIALOG_BOXES_FORM_URL = "dialog-boxes.html";
    public static final String DIALOG_BOXES_FORM_TITLE = "Dialog boxes";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @FindBy(id = "my-alert")
    WebElement launchAlert;

    @FindBy(id = "my-confirm")
    WebElement launchConfirm;

    @FindBy(id = "confirm-text")
    WebElement launchConfirmText;

    @FindBy(id = "my-prompt")
    WebElement launchPrompt;

    @FindBy(id = "prompt-text")
    WebElement launchPromptText;

    @FindBy(id = "my-modal")
    WebElement launchModal;

    @FindBy(xpath = "//button[normalize-space() = 'Save changes']")
    WebElement chooseSaveChanges;

    @FindBy(id = "modal-text")
    WebElement modalText;

    @FindBy(xpath = "//button[text() = 'Close']")
    WebElement chooseClose;

    public DialogBoxesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get dialog boxes page url")
    public String getUrl() {
        return DIALOG_BOXES_FORM_URL;
    }

    @Step("Click to launch alert")
    public void clickToLaunchAlert() {
        launchAlert.click();
    }

    @Step("Get text in launch alert")
    public String getLaunchAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        String launchAlertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return launchAlertText;
    }

    @Step("Click to launch confirm")
    public void clickToLaunchConfirm() {
        launchConfirm.click();
    }

    @Step("Get text in launch confirm")
    public String getLaunchConfirmText() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert launchConfirmText = driver.switchTo().alert();
        return launchConfirmText.getText();
    }

    @Step("Click accept in launch confirm")
    public void acceptConfirm() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert launchConfirmAccept = driver.switchTo().alert();
        launchConfirmAccept.accept();
    }

    @Step("Get text after click confirm")
    public String getConfirmText() {
        return launchConfirmText.getText();
    }

    @Step("Click cancel in launch confirm")
    public void cancelConfirm() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert launchConfirmDismiss = driver.switchTo().alert();
        launchConfirmDismiss.dismiss();
    }

    @Step("Click to launch prompt")
    public void clickToLaunchPrompt() {
        launchPrompt.click();
    }

    @Step("Get text in launch confirm")
    public String getLaunchPromptText() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert launchPromptText = driver.switchTo().alert();
        return launchPromptText.getText();
    }

    @Step("Input launch prompt text")
    public void inputLaunchPromptText(String text) {
        Alert launchPromptSendText = driver.switchTo().alert();
        launchPromptSendText.sendKeys(text);
    }

    @Step("Click accept in launch confirm")
    public void acceptPrompt() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert launchPromptAccept = driver.switchTo().alert();
        launchPromptAccept.accept();
    }

    @Step("Get text after click confirm")
    public String getPromptText() {
        return launchPromptText.getText();
    }

    @Step("Click cancel in launch confirm")
    public void cancelLaunchPrompt() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert launchPromptDismiss = driver.switchTo().alert();
        launchPromptDismiss.dismiss();
    }

    @Step("Click to launch modal")
    public void clickToLaunchModal() {
        launchModal.click();
    }

    @Step("Click to save changes")
    public void clickToSaveChanges() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseSaveChanges));
        chooseSaveChanges.click();
    }

    @Step("Get text after click launch modal")
    public String getLaunchModalText() {
        return modalText.getText();
    }

    @Step("Click to close")
    public void clickToClose() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseClose));
        chooseClose.click();
    }
}
