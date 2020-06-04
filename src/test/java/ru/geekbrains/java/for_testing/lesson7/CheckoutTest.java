package ru.geekbrains.java.for_testing.lesson7;

import org.junit.jupiter.api.Test;
import ru.geekbrains.java.for_testing.lesson5.BaseUITest;
import ru.geekbrains.java.for_testing.lesson5.Header;

import static java.lang.Thread.sleep;

public class CheckoutTest extends BaseUITest {

    @Test
    public void proceedToPaymentTest() throws InterruptedException {
        mainPage.home();
        mainPage.home();
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
        accountPage.checkAccountPage();
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
        cartPage.proceedToCheckout();
        sleep(3000);

    }

}
