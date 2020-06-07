package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Header extends BaseActions {

    private static final By SIGN_IN_BTN = By.cssSelector(".login");
    private static final By SIGN_OUT_BTN = By.cssSelector(".logout");
    private static final By CART_BTN = By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a");
    private static final By BLOCK_TOP_MENU = By.cssSelector("#block_top_menu > ul > li");

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToSignIn() {
        click(SIGN_IN_BTN);
    }

    public void signOut() {
        click(SIGN_OUT_BTN);
    }

    public void clickButtonTopMenu(СheckButton nameButton) {
        List<WebElement> elements = findElements(BLOCK_TOP_MENU);
        switch (nameButton) {
            case women: {
                elements.get(0).click();
                break;
            }
            case dresses: {
                elements.get(1).click();
                break;
            }
            case tshirts: {
                elements.get(2).click();
                break;
            }
        }
    }

    public void goToCart() {
        WebElement element = driver.findElement(CART_BTN);
        pointToElement(element);
        click(CART_BTN);
    }

    public enum СheckButton {
        women("WOMEN"),
        dresses("DRESSES"),
        tshirts("T-SHIRTS");

        private String nameButton;

        СheckButton(String nameButton) {
            this.nameButton = nameButton;
        }

        public String getText() {
            return nameButton;
        }
    }

}