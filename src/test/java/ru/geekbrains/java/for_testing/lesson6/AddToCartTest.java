//package ru.geekbrains.java.for_testing.lesson6;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import ru.geekbrains.java.for_testing.lesson5.BaseUITest;
//import ru.geekbrains.java.for_testing.lesson5.Header;
//import ru.geekbrains.java.for_testing.lesson5.RegistrationPage;
//
//import static java.lang.Thread.sleep;
//
//public class AddToCartTest extends BaseUITest {
//
//    @Test
//    public void regAuthBuying() throws InterruptedException {
//        mainPage.home();
//        header.goToSignIn();
//        String email = signInPage.generateNewRandomEmailAccountAndGoToRegistration(5);
//        registrationPage.fillingFieldsAndCreateAcc(
//                RegistrationPage.getNameFromArr(),
//                RegistrationPage.getLastNameFromArr(),
//                email,
//                "пароль",
//                "Grove Isle Dr",
//                "3-2",
//                "Miami",
//                Integer.toString(9),
//                "33122",
//                Integer.toString(21),
//                "305-777-6995",
//                "305-509-7777"
//        );
////        accountPage.checkAccountPage();
//        Assert.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
//        // логаут
//        header.signOut();
//        // логин
//        header.goToSignIn();
//        signInPage.authentication(email, "пароль");
////        accountPage.checkAccountPage();
//        Assert.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
//        header.clickButtonTopMenu(Header.СheckButton.dresses);
//        catalogPage.clickRandomElement();
//        itemPage.addToCard(2);
//        sleep(1000);
//    }
//
//    @Test
//    public void authBuyDress() throws InterruptedException {
//        mainPage.home();
////        signInPage.signIn();
//        header.clickButtonTopMenu(Header.СheckButton.dresses);
//        sleep(1000);
//        catalogPage.clickRandomElement();
//        itemPage.addToCard(2);
//        sleep(1000);
//        popUpAfterAddToCart.checkPopUp();
//        sleep(1000);
//        popUpAfterAddToCart.closePopUp();
//        header.goToCart();
//        sleep(3000);
//    }
//
//    @Test
//    public void authBuyWomen() throws InterruptedException {
//        mainPage.home();
////        signInPage.signIn();
//        header.clickButtonTopMenu(Header.СheckButton.women);
//        sleep(1000);
//        catalogPage.clickRandomElement();
//        itemPage.addToCard(1);
//        sleep(1000);
//        popUpAfterAddToCart.checkPopUp();
//        sleep(1000);
//        popUpAfterAddToCart.closePopUp();
//        header.goToCart();
//        sleep(3000);
//    }
//
//}