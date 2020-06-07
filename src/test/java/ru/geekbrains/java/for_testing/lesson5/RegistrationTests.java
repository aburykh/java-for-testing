package ru.geekbrains.java.for_testing.lesson5;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

//@DisplayName("Registration tests for http://automationpractice.com")
public class RegistrationTests extends BaseUITest {

    @Test
    public void createNewAccountTest() throws InterruptedException {
        mainPage.home();
        mainPage.goToSignIn();
        signInPage.goToRegistration("123@123.ru");
        sleep(3000);
    }


    //    @DisplayName("Positive test of creation new account with random email and valid user data")
//    @Parameters(name = "{index} ==> {0} {1} from {5}. Ph.: {10}")
    @Test(testName = "Positive test of creation new account with random email and valid user data... " +
            "{index} ==> {0} {1} from {5}. Ph.: {10}",
            dataProvider = "userData")
    public void createNewAccountParamsTest(
            String customerFirstName,
            String customerLastName,
            //String email,
            String passwd,
//            String name,
//            String lastName,
            String address,
            String addressLine2,
            String city,
            String stateSelect,
            String postalCode,
            String countrySelect,
//            String addInfo,
            String homePhone,
            String mobilePhone
//            String addressAlias
    )
            throws InterruptedException {
        mainPage.home();
        mainPage.goToSignIn();
        String randomEmail = signInPage.generateNewRandomEmailAccountAndGoToRegistration(5);
        //signInPage.generateNewRandomEmailAccountAndGoToRegistration(5);
        registrationPage.fillingFieldsAndCreateAcc(
                customerFirstName,
                customerLastName,
                randomEmail,
                passwd,
//                name,
//                lastName,
                address,
                addressLine2,
                city,
                stateSelect,
                postalCode,
                countrySelect,
//                addInfo,
                homePhone,
                mobilePhone
//                addressAlias
        );
        sleep(3000);
//        accountPage.checkAccountPage();
        Assert.assertTrue(accountPage.checkAccountPage(), "Найдена ошибка в отображении элементов на AccountPage");
    }


//    public static Stream<Arguments> userData() {
//        return Stream.of(
//                Arguments.of("Bob", "Dylan", "пароль", "Grove Isle Dr", "3-2", "Miami", Integer.toString(9), "33122", Integer.toString(21), "305-509-6995", "305-509-9999"),
//                Arguments.of("Pete", "Dylan", "пароль", "Washington st", "1455-15-3", "Miami", Integer.toString(9), "33145", Integer.toString(21), "305-111-6995", "305-111-9999"),
//                Arguments.of("Maggy", "Lincoln", "пароль", "Grove Isle Dr", "56-17", "Miami", Integer.toString(9), "33123", Integer.toString(21), "305-666-6995", "305-666-9999"),
//                Arguments.of("John", "Duran", "пароль", "Lincoln st", "155", "Miami", Integer.toString(9), "33129", Integer.toString(21), "305-777-6995", "305-777-9999")
//        );
//    }

    @DataProvider(name = "userData")
    public static Object[][] userDataArr() {
        return new Object[][]{
                {"Bob", "Dylan", "пароль", "Grove Isle Dr", "3-2", "Miami", Integer.toString(9), "33122", Integer.toString(21), "305-509-6995", "305-509-9999"},
                {"Pete", "Dylan", "пароль", "Washington st", "1455-15-3", "Miami", Integer.toString(9), "33145", Integer.toString(21), "305-111-6995", "305-111-9999"},
                {"Maggy", "Lincoln", "пароль", "Grove Isle Dr", "56-17", "Miami", Integer.toString(9), "33123", Integer.toString(21), "305-666-6995", "305-666-9999"},
                {"John", "Duran", "пароль", "Lincoln st", "155", "Miami", Integer.toString(9), "33129", Integer.toString(21), "305-777-6995", "305-777-9999"}
        };
    }

}