package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends ru.geekbrains.java.for_testing.lesson5.BaseActions {

    private static final String HOMEPAGE_URL = "http://automationpractice.com/";

    private static final By SIGN_IN_BTN = By.cssSelector(".login");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(HOMEPAGE_URL);
    }

    public void goToSignIn() {
        click(SIGN_IN_BTN);
    }
}