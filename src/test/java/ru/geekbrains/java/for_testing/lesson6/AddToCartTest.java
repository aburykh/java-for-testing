package ru.geekbrains.java.for_testing.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.java.for_testing.lesson5.BaseUITest;
import ru.geekbrains.java.for_testing.lesson5.Header;
import ru.geekbrains.java.for_testing.lesson5.RegistrationPage;

import static java.lang.Thread.sleep;

@Execution(ExecutionMode.SAME_THREAD)
@DisplayName("Добавление в корзину товара")
@Feature(value = "Проверка добавление в корзину товара")
public class AddToCartTest extends BaseUITest {

    @Test
    @DisplayName("Проверка регистрации нового пользователя с последующим добавлением в корзину товара из категории \"Dresses\"")
    @Story(value = "Проверка добавления товара в корзину после регистрации")
    @Description(value = "Тест-кейс позволяет проверить добавление в корзину рандомного товара из категории \"Women\" сразу после регистрации")
    public void regAuthBuying() throws InterruptedException {
        mainPage.home();
        header.goToSignIn();
        String email = signInPage.generateNewRandomEmailAccountAndGoToRegistration(5);
        registrationPage.fillingFieldsAndCreateAcc(
                RegistrationPage.getNameFromArr(),
                RegistrationPage.getLastNameFromArr(),
                email,
                "пароль",
                "Grove Isle Dr",
                "3-2",
                "Miami",
                Integer.toString(9),
                "33122",
                Integer.toString(21),
                "305-777-6995",
                "305-509-7777"
        );
//        accountPage.checkAccountPage();
        Assertions.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
        // логаут
        header.signOut();
        // логин
        header.goToSignIn();
        signInPage.authentication(email, "пароль");
//        accountPage.checkAccountPage();
        Assertions.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        catalogPage.clickRandomElement();
        itemPage.addToCard(2);
        sleep(1000);
    }

    @Test
    @DisplayName("Проверка добавления в корзину товара из категории \"Dresses\"")
    @Story(value = "Добавление в корзину товара из категории \"Dresses\"")
    @Description(value = "Тест-кейс позволяет проверить добавление в корзину рандомного товара из категории \"Dresses\"")
    public void authBuyDress() throws InterruptedException {
        mainPage.home();
//        signInPage.signIn();
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        sleep(1000);
        catalogPage.clickRandomElement();
        itemPage.addToCard(2);
        sleep(1000);
        popUpAfterAddToCart.checkPopUp();
        sleep(1000);
        popUpAfterAddToCart.closePopUp();
        header.goToCart();
        sleep(3000);
    }

    @Test
    @DisplayName("Проверка добавления в корзину товара из категории \"Women\"")
    @Story(value = "Добавление в корзину товара из категории \"Women\"")
    @Description(value = "Тест-кейс позволяет проверить добавление в корзину рандомного товара из категории \"Women\"")
    public void authBuyWomen() throws InterruptedException {
        mainPage.home();
//        signInPage.signIn();
        header.clickButtonTopMenu(Header.СheckButton.women);
        sleep(1000);
        catalogPage.clickRandomElement();
        itemPage.addToCard(1);
        sleep(1000);
        popUpAfterAddToCart.checkPopUp();
        sleep(1000);
        popUpAfterAddToCart.closePopUp();
        header.goToCart();
        sleep(3000);
    }

}