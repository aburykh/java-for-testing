package ru.geekbrains.java.for_testing.lesson5;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
@DisplayName("Проверка загрузки страницы авторизации")
@Feature(value = "Проверка страниц")
@Story(value = "Проверка загрузки страницы авторизации")
public class MainPageTests extends BaseUITest {

    @Test
    @DisplayName("Тест отображения элементов на странице авторизации")
    @Description(value = "Тест-кейс позволяет проверить загрузку и отображение элементов на странице авторизации")
    public void goToSignInPageTest() {
        mainPage.home();
        mainPage.goToSignIn();
        Assertions.assertTrue(signInPage.isSignInPageHeaderPresent());
        Assertions.assertEquals("authentication", signInPage.getSignInPageHeaderText().toLowerCase());
    }

}