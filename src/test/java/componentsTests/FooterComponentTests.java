package componentsTests;

import Ilya_S.components.FooterComponent;
import Ilya_S.pageFactory.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageFactoryTests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FooterComponentTests extends BaseTest {
    HomePage homePage;
    private static final String TEXT_MUTED = "Copyright © 2021-2025 Boni García";
    private static final String INFORMATION_PAGE_URL = "https://bonigarcia.dev/";

    @BeforeEach
    void setupPage() {
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Проверка копирайта страницы")
    void checkMutedText() {
        assertEquals(TEXT_MUTED, homePage.getFooter().getText());
    }

    @Test
    @DisplayName("Проверка ссылки на странице")
    void checkLogoIcon() {
        FooterComponent footer = homePage.getFooter();
        footer.clickLink();
        assertEquals(INFORMATION_PAGE_URL, footer.getCurrentUrlInformationPage());
    }
}
