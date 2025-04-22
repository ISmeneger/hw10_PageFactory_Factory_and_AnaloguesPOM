package fluentTests;

import Ilya_S.configs.TestPropertiesConfig;
import Ilya_S.fluentPages.FluentLoginFormPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageFactoryTests.BaseTest;

class FluentLoginFormPageTests extends BaseTest {
    TestPropertiesConfig config = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    FluentLoginFormPage loginFormPage;

    @BeforeEach
    void initPages() {
        loginFormPage = new FluentLoginFormPage(driver);
    }

    @Test
    void testLoginSuccess() {
        loginFormPage
                .login(config.getUsername(), config.getPassword())
                .checkSuccessBoxPresent()
                .checkInvalidCredentialsBoxIsNotPresent();
    }

    @Test
    void testLoginFailure() {
        loginFormPage
                .login(config.getInvalidUsername(), config.getInvalidPassword())
                .checkInvalidCredentialsBoxPresent()
                .checkSuccessBoxIsNotPresent();
    }
}

