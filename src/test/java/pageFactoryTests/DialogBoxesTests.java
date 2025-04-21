package pageFactoryTests;

import Ilya_S.pageFactory.DialogBoxesPage;
import Ilya_S.pageFactory.HomePage;
import org.junit.jupiter.api.*;

import static Ilya_S.pageFactory.DialogBoxesPage.DIALOG_BOXES_FORM_TITLE;
import static Ilya_S.pageFactory.HomePage.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DialogBoxesTests extends BaseTest {
    HomePage homePage;
    DialogBoxesPage dialogBoxesPage;

    private static final String ALERT_TEXT = "Hello world!";
    private static final String CONFIRM_TEXT = "Is this correct?";
    private static final String CONFIRM_ACCEPT_TEXT = "You chose: true";
    private static final String CONFIRM_CANCEL_TEXT = "You chose: false";
    private static final String PROMPT_TEXT = "Please enter your name";
    private static final String PROMPT_ACCEPT_TEXT = "You typed: Test";
    private static final String PROMPT_CANCEL_TEXT = "You typed: null";
    private static final String MODAL_ACCEPT_TEXT = "You chose: Save changes";
    private static final String MODAL_CANCEL_TEXT = "You chose: Close";

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
        dialogBoxesPage = homePage.openDialogBoxesPage();
    }

    @Test
    @Order(1)
    @DisplayName("Проверка Dialog boxes")
    void openLoginFormTest() {
        String currentUrl = dialogBoxesPage.getCurrentUrl();
        String title = dialogBoxesPage.getTitle();
        String loginFormPageFormUrl = dialogBoxesPage.getUrl();

        assertEquals(BASE_URL + loginFormPageFormUrl, currentUrl);
        assertEquals(DIALOG_BOXES_FORM_TITLE, title);
    }

    @Test
    @DisplayName("Проверка Launch alert")
    @Order(2)
    void launchAlertTest() {
        dialogBoxesPage.clickToLaunchAlert();
        String launchAlertText = dialogBoxesPage.getLaunchAlertText();

        assertThat(launchAlertText).isEqualTo(ALERT_TEXT);
    }

    @Test
    @DisplayName("Проверка Launch confirm и нажатие на кнопку 'ОК'")
    @Order(3)
    void launchConfirmAcceptTest() {
        dialogBoxesPage.clickToLaunchConfirm();
        String launchConfirmText = dialogBoxesPage.getLaunchConfirmText();

        assertThat(launchConfirmText).isEqualTo(CONFIRM_TEXT);

        dialogBoxesPage.acceptConfirm();

        assertThat(dialogBoxesPage.getConfirmText()).isEqualTo(CONFIRM_ACCEPT_TEXT);
    }

    @Test
    @DisplayName("Проверка Launch confirm и нажатие на кнопку 'Отмена'")
    @Order(4)
    void launchConfirmCancelTest() {
        dialogBoxesPage.clickToLaunchConfirm();
        String launchConfirmText = dialogBoxesPage.getLaunchConfirmText();

        assertThat(launchConfirmText).isEqualTo(CONFIRM_TEXT);

        dialogBoxesPage.cancelConfirm();

        assertThat(dialogBoxesPage.getConfirmText()).isEqualTo(CONFIRM_CANCEL_TEXT);
    }

    @Test
    @DisplayName("Проверка Launch prompt и нажатие на кнопку 'ОК'")
    @Order(5)
    void launchPromptAcceptTest() throws InterruptedException {
        dialogBoxesPage.clickToLaunchPrompt();
        String launchPromptText = dialogBoxesPage.getLaunchConfirmText();

        assertThat(launchPromptText).isEqualTo(PROMPT_TEXT);

        dialogBoxesPage.inputLaunchPromptText("Test");
        Thread.sleep(3000);

        dialogBoxesPage.acceptPrompt();

        assertThat(dialogBoxesPage.getPromptText()).isEqualTo(PROMPT_ACCEPT_TEXT);
    }

    @Test
    @DisplayName("Проверка Launch prompt и нажатие на кнопку 'Отмена'")
    @Order(6)
    void launchPromptCancelTest() {
        dialogBoxesPage.clickToLaunchPrompt();
        String launchPromptText = dialogBoxesPage.getLaunchConfirmText();

        assertThat(launchPromptText).isEqualTo(PROMPT_TEXT);

        dialogBoxesPage.cancelLaunchPrompt();

        assertThat(dialogBoxesPage.getPromptText()).isEqualTo(PROMPT_CANCEL_TEXT);
    }

    @Test
    @DisplayName("Проверка Launch modal и нажатие на кнопку 'Save changes'")
    @Order(7)
    void launchModalChooseSaveChangeTest() {
        dialogBoxesPage.clickToLaunchModal();
        dialogBoxesPage.clickToSaveChanges();

        assertThat(dialogBoxesPage.getLaunchModalText()).isEqualTo(MODAL_ACCEPT_TEXT);
    }

    @Test
    @DisplayName("Проверка Launch modal и нажатие на кнопку 'Close'")
    @Order(8)
    void launchModalChooseCloseTest() {
        dialogBoxesPage.clickToLaunchModal();
        dialogBoxesPage.clickToClose();

        assertThat(dialogBoxesPage.getLaunchModalText()).isEqualTo(MODAL_CANCEL_TEXT);
    }
}
