package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
public class CartPage extends BaseActions {

    private static final By PROCEED_TO_CHECKOUT = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private static final By CONTINUE_SHOPPING = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span");
    private static final By ADD_QTY = By.cssSelector("#cart_quantity_up_1_1_0_329543");
    private static final By PROCEED_TO_CHECKOUT_IN_CART = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button");
    private static final By PROCEED_TO_CHECKOUT_IN_ADDRESSES = By.cssSelector("#center_column > form > p > button");
    private static final By PROCEED_TO_CHECKOUT_IN_SHIPPING = By.cssSelector("#form > p > button");
    private static final By POPUP_IN_SHIPPING = By.cssSelector("#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p");

    // You must agree to the terms of service before continuing.

    private static final By CHECKBOX_IN_SHIPPING = By.cssSelector("#cgv");
    private static final By PAY_BY_BANK_WIRE = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p");
    private static final By PAY_BY_CHECK = By.cssSelector("#HOOK_PAYMENT > div:nth-child(2) > div > p");
    private static final By I_CONFIRM_MY_ORDER = By.cssSelector("#cart_navigation > button");
    private static final By BACK_TO_ORDERS = By.cssSelector("#center_column > p > a");



    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



}