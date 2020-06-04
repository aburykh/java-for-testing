package ru.geekbrains.java.for_testing.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java.for_testing.lesson5.BaseUITest;

public class AuthTest extends BaseUITest {

    @Test
    public void authTest() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
        accountPage.checkAccountPage();
    }

    @Test
    public void authFailedTest(String text) {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("incorrect@email.com", "incorrect_password");
        //signInPage.checkAlertIfAuthFailed("Authentication failed");
        Assertions.assertTrue(signInPage.checkAlertIfAuthFailed().contains(text.toLowerCase()), "Текст ошибки \"" + text + "\" не совпадает");
    }

}