package ru.geekbrains.java.for_testing.lesson5;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PopUpAfterAddToCart extends BaseActions {

    private static final By POPUP_AFTER_ADD_TO_CART = By.cssSelector("#layer_cart > div.clearfix");
    private static final By INFO_AFTER_SUCCESS_ADD_TO_CART = By.cssSelector("div.layer_cart_product.col-xs-12.col-md-6 > h2");
    private static final By CLOSE_BTN = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > span");

    public PopUpAfterAddToCart(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void checkPopUp() {
        waitABit(3000);
        Assertions.assertAll(
                () -> assertTrue(isElementPresent(POPUP_AFTER_ADD_TO_CART), "Не отобразился Поп-Ап после добавления в корзину"),
                () -> assertEquals(driver.findElement(POPUP_AFTER_ADD_TO_CART)
                                .findElement(INFO_AFTER_SUCCESS_ADD_TO_CART)
                                .getText(), "Product successfully added to your shopping cart",
                        "Текст уведомления не совпадает")
        );
    }

    public void closePopUp() {
        click(CLOSE_BTN);
    }

}