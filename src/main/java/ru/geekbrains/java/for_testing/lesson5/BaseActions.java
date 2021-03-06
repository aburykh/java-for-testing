package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseActions {

    WebDriver driver;
    WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void type(String text, By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public void select(String text, By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public void click(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).click();
    }

    public void waitABit(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void select(int index, By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void pointToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
    }

}