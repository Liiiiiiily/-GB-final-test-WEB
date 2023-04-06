package UiTests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthPageTest extends AbstractTest {

    @Test
    @DisplayName("Valid: authorization with your valid username and password")
    public void authValidTest() throws InterruptedException, IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginValid();
        Thread.sleep(1000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
        assertEquals("+79277371622", authPage.getLogin());
    }

    @Test
    @DisplayName("Valid: authorization with a username of minimum length (3)")
    public void authMinCharTest() throws InterruptedException, IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginMinChar();
        Thread.sleep(1000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
        assertEquals("ww", authPage.getLogin());
    }

    @Test
    @DisplayName("Valid: authorization with username of maximum length (20)")

    public void authMaxCharTest() throws InterruptedException, IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginMaxChar();
        Thread.sleep(1000);
        assertEquals("https://test-stand.gb.ru/", getDriver().getCurrentUrl());
        assertEquals("maximumlenghtsymbols", authPage.getLogin());
    }

    @Test
    @DisplayName("Invalid: username contains Cyrillic signs")
    public void authRusTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginRus();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }

    @Test
    @DisplayName("Invalid: username contains invalid signs")
    public void authSpecCharTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginSpecChar();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }

    @Test
    @DisplayName("Invalid: authorization with username less than 3 signs")
    public void authLessThanMinCharTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginLessThanMinChar();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }

    @Test
    @DisplayName("Invalid: authorization with a username of more than 20 signs")
    public void authMoreThanMaxCharTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginMoreThanMaxChar();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }

    @Test
    @DisplayName("Invalid: valid username, invalid password")
    public void authIncorrectPasswordTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginIncorrectPassword();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }

    @Test
    @DisplayName("Invalid: authorization with empty values")
    public void authorizationWithoutLoginAndPasswordTest() throws IOException {
        AuthPage authPage = new AuthPage(getDriver());
        authPage.loginWithoutLoginAndPassword();
        assertEquals("Invalid credentials.", authPage.getError_message().getText());
        assertEquals("401", authPage.getError_code().getText());
    }
}
