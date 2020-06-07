package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BaseActions {

    private Header header;
    private SignInPage signInPage;
    private AccountPage accountPage;

    private static final By SIGN_IN_PAGE_HEADER = By.cssSelector(".page-heading");
    private static final By EMAIL_REGISTRATION = By.cssSelector("#email_create");
    private static final By GO_TO_REGISTRATION_BTN = By.cssSelector("#SubmitCreate");
    private static final By EMAIL_ALREADY_REGISTERED = By.cssSelector("#email");
    private static final By PASSWD_ALREADY_REGISTERED = By.cssSelector("#passwd");
    private static final By SIGN_IN_BTN = By.cssSelector("#SubmitLogin");
    private static final By ALERT_INFO = By.cssSelector("#center_column > div");

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isSignInPageHeaderPresent() {
        return isElementPresent(SIGN_IN_PAGE_HEADER);
    }

    public String getSignInPageHeaderText() {
        return driver.findElement(SIGN_IN_PAGE_HEADER).getText();
    }

    public String generateNewRandomEmailAccountAndGoToRegistration(int emailNameLength) {
        StringBuilder emailBuilder = new StringBuilder();
        for (int i = 0; i < emailNameLength; i++) {
            emailBuilder.append((char) (97 + (int) (Math.random() * 26)));
        }
        emailBuilder.append("@gmail.com");
        type(emailBuilder.toString(), EMAIL_REGISTRATION);
        click(GO_TO_REGISTRATION_BTN);
        return emailBuilder.toString();
    }

    public void goToRegistration(String email) {
        type(email, EMAIL_REGISTRATION);
        waitABit(2);
        click(GO_TO_REGISTRATION_BTN);
    }

    public void authentication(String email, String password) {
        type(email, EMAIL_ALREADY_REGISTERED);
        type(password, PASSWD_ALREADY_REGISTERED);
        click(SIGN_IN_BTN);
    }

    public void signIn() {
        header.goToSignIn();
        signInPage.authentication("12345@123.ru", "пароль");
        accountPage.checkAccountPage();
    }

    // assert вынести в тест
//    public void checkAlertIfAuthFailed(String text) {
//        Assertions.assertTrue(driver.findElement(ALERT_INFO).getText().contains(text));
//    }

    public String checkAlertIfAuthFailed() {
        return driver.findElement(ALERT_INFO).getText().toLowerCase();
    }

}