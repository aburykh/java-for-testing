package ru.geekbrains.java.for_testing.lesson6;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.geekbrains.java.for_testing.lesson5.BaseUITest;

public class AuthTest extends BaseUITest {

//    @Test
//    public void authTest() {
//        mainPage.home();
//        header.goToSignIn();
//        signInPage.authentication("12345@123.ru", "пароль");
//        Assert.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
//    }

//    @Parameters
//    @MethodSource("dataForAuthFailed")
//    public void authFailedTest(String email, String password, String text) {
//        mainPage.home();
//        header.goToSignIn();
//        signInPage.authentication(email, password);
//        Assert.assertTrue(
//                signInPage.checkAlertIfAuthFailed()
//                        .contains(text.toLowerCase()), "Текст ошибки \"" + text + "\" не совпадает");
//    }


//    public static Stream<Arguments> dataForAuthFailed() {
//        return Stream.of(
//                Arguments.of("incorrect@email.com", "пароль", "Authentication failed"),
//                Arguments.of("12345@123.ru", "incorrect_password", "Authentication failed")
//        );
//    }

    @Test(testName = "Авторизация с валидными данными")
    public void authTest() {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
        Assert.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
    }

    @DataProvider(name = "dataForAuthFailed")
    public static Object[][] dataForAuthFailedArr() {
        return new Object[][]{
                {"incorrect@email.com", "пароль", "Authentication failed"},
                {"12345@123.ru", "incorrect_password", "Authentication failed"}
        };
    }


    @Test(testName = "Авторизация с невалидными данными", dataProvider = "dataForAuthFailed")
    public void authFailedTest(Object email, Object password, Object text) {
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication(email.toString(), password.toString());
        Assert.assertTrue(
                signInPage.checkAlertIfAuthFailed()
                        .contains(text.toString().toLowerCase()), "Текст ошибки \"" + text + "\" не совпадает");
    }

}