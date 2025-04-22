package componentsTests;

import Ilya_S.components.HeaderComponent;
import Ilya_S.pageFactory.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageFactoryTests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderComponentTests extends BaseTest {
    HomePage homePage;
    private static final String TITLE_TEXT = "Hands-On Selenium WebDriver with Java";
    private static final String SUB_TITLE_TEXT = "Practice site";
    private static final String GIT_PAGE_URL = "https://github.com/bonigarcia/selenium-webdriver-java";

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Проверка заголовка страницы")
    void checkTitleText() {
        assertEquals(TITLE_TEXT, homePage.getHeader().getTitleText());
    }

    @Test
    @DisplayName("Проверка подзаголовка страницы")
    void checkSubTitleText() {
        assertEquals(SUB_TITLE_TEXT, homePage.getHeader().getSubTitleText());
    }

    @Test
    @DisplayName("Проверка иконки с логотипом на странице")
    void checkLogoIcon() {
        HeaderComponent header = homePage.getHeader();
        header.clickLogo();
        assertEquals(GIT_PAGE_URL, header.getCurrentUrlGitPage());
    }
}
