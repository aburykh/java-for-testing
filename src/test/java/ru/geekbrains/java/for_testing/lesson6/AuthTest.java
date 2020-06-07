package ru.geekbrains.java.for_testing.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.java.for_testing.lesson5.BaseUITest;

import java.util.stream.Stream;

public class AuthTest extends BaseUITest {

    @Test
    public void authTest() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
        Assertions.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
    }

    @ParameterizedTest
    @MethodSource("dataForAuthFailed")
    public void authFailedTest(String email, String password, String text) {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication(email, password);
        Assertions.assertTrue(
                signInPage.checkAlertIfAuthFailed()
                        .contains(text.toLowerCase()), "Текст ошибки \"" + text + "\" не совпадает");
    }

    public static Stream<Arguments> dataForAuthFailed() {
        return Stream.of(
                Arguments.of("incorrect@email.com", "пароль", "Authentication failed"),
                Arguments.of("12345@123.ru", "incorrect_password", "Authentication failed")
        );
    }

}