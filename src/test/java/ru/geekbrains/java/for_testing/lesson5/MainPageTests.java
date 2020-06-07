package ru.geekbrains.java.for_testing.lesson5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends BaseUITest {

    @Test
    public void goToSignInPageTest() {
        mainPage.home();
        mainPage.goToSignIn();
        Assert.assertTrue(signInPage.isSignInPageHeaderPresent());
        Assert.assertEquals("authentication", signInPage.getSignInPageHeaderText().toLowerCase());
    }

}