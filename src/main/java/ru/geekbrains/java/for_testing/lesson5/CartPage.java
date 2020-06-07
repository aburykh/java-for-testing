package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class CartPage extends BaseActions {

    private static final By PAGE_HEADER = By.cssSelector(".page-heading");
    private static final By CART_ITEMS_LIST = By.cssSelector("#order-detail-content > table > tbody > tr ");
    private static final By CART_ITEM_NAME = By.cssSelector(".product-name");
    private static final By CART_ITEM_QTY = By.cssSelector("[class=\"cart_quantity_input form-control grey\"]");
    private static final By PROCEED_TO_CHECKOUT = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private static final By CONTINUE_SHOPPING = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span");
    private static final By ADD_QTY = By.cssSelector("#cart_quantity_up_1_1_0_329543");
    private static final By PROCEED_TO_CHECKOUT_IN_CART = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button");
    private static final By PROCEED_TO_CHECKOUT_IN_ADDRESSES = By.cssSelector("#center_column > form > p > button");
    private static final By PROCEED_TO_CHECKOUT_IN_SHIPPING = By.cssSelector("#form > p > button");
    private static final By POPUP_IN_SHIPPING = By.cssSelector("#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div > div > div > p");

    // You must agree to the terms of service before continuing.
    private static final By CHECKBOX_IN_SHIPPING = By.cssSelector("#cgv");
    private static final By PAY_BY_BANK_WIRE = By.cssSelector(".bankwire");
    private static final By PAY_BY_CHECK = By.cssSelector(".cheque");
    private static final By I_CONFIRM_MY_ORDER = By.cssSelector("#cart_navigation > button");
    private static final By BACK_TO_ORDERS = By.cssSelector("#center_column > p > a");
    private static final By ALERT_SUCCESS = By.cssSelector("[class=\"alert alert-success\"]");


    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

/**    public void proceedToCheckoutAllTheWay() throws InterruptedException {
        click(PROCEED_TO_CHECKOUT_IN_CART);
        click(PROCEED_TO_CHECKOUT_IN_ADDRESSES);
        click(CHECKBOX_IN_SHIPPING);
        click(PROCEED_TO_CHECKOUT_IN_SHIPPING);
        click(PAY_BY_BANK_WIRE);
        click(I_CONFIRM_MY_ORDER);
        click(BACK_TO_ORDERS);
        sleep(5000);
    }*/

    public void proceedToCheckoutAllTheWay(int type) throws InterruptedException {
        checkoutInCart();
        checkoutInAddress();
        checkboxInShipping();
        checkoutInShipping();
        typeOfPayment(type);
        confirmOder();
        backToOrders();
        sleep(5000);
    }

    public void checkoutInCart() {
        click(PROCEED_TO_CHECKOUT_IN_CART);
    }

    public void checkoutInAddress() {
        click(PROCEED_TO_CHECKOUT_IN_ADDRESSES);
    }

    public void checkoutInShipping() {
        click(PROCEED_TO_CHECKOUT_IN_SHIPPING);
    }

    public void checkboxInShipping() {
        click(CHECKBOX_IN_SHIPPING);
    }

    public void typeOfPayment(int type) {
        if (type == 1) {
            click(PAY_BY_BANK_WIRE);
        } else {
            click(PAY_BY_CHECK);
        }
    }

    public void confirmOder() {
        click(I_CONFIRM_MY_ORDER);
    }

    public void backToOrders() {
        click(BACK_TO_ORDERS);
    }

}