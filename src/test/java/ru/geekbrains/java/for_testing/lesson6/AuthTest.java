package ru.geekbrains.java.for_testing.lesson6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.java.for_testing.lesson5.BaseUITest;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка авторизации")
@Feature(value = "Проверка авторизации")
public class AuthTest extends BaseUITest {

    @Story(value = "Авторизация с валидными данными")
    @DisplayName("Авторизация с валидными логин/пароль")
    @Test
    @Issue(value = "https://google.com")
    @TmsLink(value = "https://ya.ru")
    @Description(value = "Тест-кейс позволяет проверить авторизацию на портале с валидными данными с последующей проверкой загрузки страницы после авторизации")
    public void authTest() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
        Assertions.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
    }

    @Story(value = "Авторизация с невалидными данными")
    @DisplayName("Авторизация с невалидными логин/пароль")
    @Description(value = "Тест-кейс позволяет проверить вывод ошибки при попытке авторизоваться с невалидными учётными данными")
    @ParameterizedTest(name = "{index} ==> Проверка авторизации с невалидными данными: \"{0}\"...")
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