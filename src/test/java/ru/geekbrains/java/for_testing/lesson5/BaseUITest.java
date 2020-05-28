package ru.geekbrains.java.for_testing.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BaseUITest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected MainPage mainPage;
    protected SignInPage signInPage;
    protected RegistrationPage registrationPage;
    protected AccountPage accountPage;

    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        mainPage = new MainPage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
        accountPage = new AccountPage(driver, wait);
    }

    @AfterEach
    public void shutdown() {
        driver.quit();
    }

}