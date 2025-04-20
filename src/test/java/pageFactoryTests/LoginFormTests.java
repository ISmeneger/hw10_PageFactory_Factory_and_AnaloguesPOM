package pageFactoryTests;

import Ilya_S.pageFactory.HomePage;
import Ilya_S.pageFactory.LoginFormPage;
import configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Ilya_S.pageFactory.HomePage.BASE_URL;
import static Ilya_S.pageFactory.LoginFormPage.LOGIN_FORM_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginFormTests extends BaseTest {
    HomePage homePage;
    LoginFormPage loginFormPage;
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    private static final String SUCCESSFUL_LOGIN_TEXT = "Login successful";
    private static final String INVALID_LOGIN_TEXT = "Invalid credentials";

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
        loginFormPage = homePage.openLoginFormPage();
    }

    @Test
    @DisplayName("Проверка Login form")
    void openLoginFormTest() {
        String currentUrl = loginFormPage.getCurrentUrl();
        String title = loginFormPage.getTitle();
        String loginFormPageFormUrl = loginFormPage.getUrl();

        assertEquals(BASE_URL + loginFormPageFormUrl, currentUrl);
        assertEquals(LOGIN_FORM_TITLE, title);
    }

    @Test
    @DisplayName("Проверка успешной авторизации с валидными данными")
    void signInTest() {
        loginFormPage.inputLogin(config.getUsername());
        loginFormPage.inputPassword(config.getPassword());
        loginFormPage.submitButton();

        assertEquals(SUCCESSFUL_LOGIN_TEXT, loginFormPage.getSuccessfulMessage());
    }

    @Test
    @DisplayName("Проверка ввода не корректных имени и пароля")
    void invalidCredentialsTest() {

        loginFormPage.inputLogin(config.getInvalidUsername());
        loginFormPage.inputPassword(config.getInvalidPassword());
        loginFormPage.submitButton();

        assertEquals(INVALID_LOGIN_TEXT, loginFormPage.getInvalidMessage());
    }






}
