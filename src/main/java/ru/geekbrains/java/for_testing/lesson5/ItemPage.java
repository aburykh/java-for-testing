package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BaseActions {

    private static final By ADD_TO_CARD_BTN = By.cssSelector("#add_to_cart > button");
    private static final By QUANTITY = By.cssSelector("#quantity_wanted");

    public ItemPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void addToCard(int quantity) {
        type(String.valueOf(quantity), QUANTITY);
        click(ADD_TO_CARD_BTN);
    }

}