package ru.geekbrains.java.for_testing.lesson5;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPage extends BaseActions{

    private static final By MY_ACCOUNT = By.cssSelector("h1");

    private static final By ORDER_HISTORY_BTN = By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(1) > a > span");
    private static final By ORDER_HISTORY_ICON = By.cssSelector(".icon-list-ol");

    private static final By MY_CREDIT_SLIPS_BTN = By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(2) > a > span");
    private static final By MY_CREDIT_SLIPS_ICON = By.cssSelector(".icon-ban-circle");

    private static final By MY_ADDRESSES_BTN = By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a > span");
    private static final By MY_ADDRESSES_ICON = By.cssSelector(".icon-building");

    private static final By MY_PERS_INFO_BTN = By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a > span");
    private static final By MY_PERS_INFO_ICON = By.cssSelector(".icon-user");

    private static final By MY_WISHLISTS_BTN = By.cssSelector("#center_column > div > div:nth-child(2) > ul > li > a > span");
    private static final By MY_WISHLISTS_ICON = By.cssSelector(".icon-heart");


    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void checkAccountPage() {
        Assertions.assertAll(
                ()-> assertTrue(isElementPresent(MY_ACCOUNT), "Не отобразился заголовок \"My Account\""),
                ()-> assertTrue(isElementPresent(ORDER_HISTORY_BTN), "Не отобразился текст кнопки \"Order history and details\""),
                ()-> assertTrue(isElementPresent(ORDER_HISTORY_ICON), "Не отобразилась иконка \"Order history and details\""),
                ()-> assertTrue(isElementPresent(MY_CREDIT_SLIPS_BTN),"Не отобразился текст кнопки \"My Credit Slips\""),
                ()-> assertTrue(isElementPresent(MY_CREDIT_SLIPS_ICON), "Не отобразилась иконка \"My Credit Slips\""),
                ()-> assertTrue(isElementPresent(MY_ADDRESSES_BTN), "Не отобразился текст кнопки \"My Addresses\""),
                ()-> assertTrue(isElementPresent(MY_ADDRESSES_ICON), "Не отобразилась иконка \"My Addresses\""),
                ()-> assertTrue(isElementPresent(MY_PERS_INFO_BTN), "Не отобразился текст кнопки \"My Personal Information\""),
                ()-> assertTrue(isElementPresent(MY_PERS_INFO_ICON), "Не отобразилась иконка \"My Personal Information\""),
                ()-> assertTrue(isElementPresent(MY_WISHLISTS_BTN), "Не отобразился текст кнопки \"My wishLists\""),
                ()-> assertTrue(isElementPresent(MY_WISHLISTS_ICON), "Не отобразилась иконка \"My wishLists\"")
        );
    }

}