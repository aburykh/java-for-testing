package ru.geekbrains.java.for_testing.lesson7;

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

import static java.lang.Thread.sleep;

@Execution(ExecutionMode.SAME_THREAD)
@DisplayName("Оформление заказа")
@Feature(value = "Проверка оформления заказа")
public class CheckoutTest extends BaseUITest {

    @Test
    @DisplayName("Тест оформления заказа")
    @Story(value = "Проверка оформления заказа с оплатой \"By bank wire\"")
    @Description(value = "Тест-кейс позволяет проверить полный цикл оформления заказа с выбором вида оплаты \"By bank wire\"")
    public void proceedToPaymentByBankTest() throws InterruptedException {
        mainPage.home();
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
//        accountPage.checkAccountPage();
        Assertions.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        sleep(1000);
        catalogPage.clickRandomElement();
        sleep(1000);
        itemPage.addToCard(1);
        sleep(1000);
        popUpAfterAddToCart.checkPopUp();
        sleep(1000);
        popUpAfterAddToCart.closePopUp();
        header.goToCart();
        sleep(3000);
//        cartPage.proceedToCheckoutAllTheWay(1);
//        sleep(3000);
        cartPage.checkoutInCart();
        cartPage.checkoutInAddress();
        cartPage.checkboxInShipping();
        cartPage.checkoutInShipping();
        cartPage.typeOfPayment(1);
        cartPage.confirmOder();
        cartPage.backToOrders();
        sleep(3000);
    }

    @Test
    @DisplayName("Тест оформления заказа")
    @Story(value = "Проверка оформления заказа с оплатой \"By check\"")
    @Description(value = "Тест-кейс позволяет проверить полный цикл оформления заказа с выбором вида оплаты \"By check\"")
    public void proceedToPaymentByCheckTest() throws InterruptedException {
        mainPage.home();
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
//        accountPage.checkAccountPage();
        Assertions.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
        header.clickButtonTopMenu(Header.СheckButton.dresses);
        sleep(1000);
        catalogPage.clickRandomElement();
        sleep(1000);
        itemPage.addToCard(1);
        sleep(1000);
        popUpAfterAddToCart.checkPopUp();
        sleep(1000);
        popUpAfterAddToCart.closePopUp();
        header.goToCart();
        sleep(3000);
//        cartPage.proceedToCheckoutAllTheWay(2);
//        sleep(3000);
        cartPage.checkoutInCart();
        cartPage.checkoutInAddress();
        cartPage.checkboxInShipping();
        cartPage.checkoutInShipping();
        cartPage.typeOfPayment(2);
        cartPage.confirmOder();
        cartPage.backToOrders();
        sleep(3000);
    }

}