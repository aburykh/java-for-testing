package ru.geekbrains.java.for_testing.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrationPage extends BaseActions {

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //YOUR PERSONAL INFORMATION
    private static final By MR_RADIO_BTN = By.cssSelector("#id_gender1");
    private static final By MRS_RADIO_BTN = By.cssSelector("#id_gender2");
    private static final By CUSTOMER_FIRST_NAME = By.cssSelector("#customer_firstname");
    private static final By CUSTOMER_LAST_NAME = By.cssSelector("#customer_lastname");
    private static final By EMAIL = By.cssSelector("#email");
    private static final By PASSWD = By.cssSelector("#passwd");

    private static final By DAY_OF_BIRTH_SELECT = By.cssSelector("#days");
    private static final By MONTH_OF_BIRTH_SELECT = By.cssSelector("#months");
    private static final By YEAR_OF_BIRTH_SELECT = By.cssSelector("#years");
    private static final By NEWSLETTER_CHECKBOX = By.cssSelector("#newsletter");
    private static final By SPECIAL_OFFERS_CHECKBOX = By.cssSelector("#optin");

    //YOUR ADDRESS
    private static final By NAME = By.cssSelector("#firstname");
    private static final By LAST_NAME = By.cssSelector("#lastname");
    private static final By COMPANY = By.cssSelector("#company");
    private static final By ADDRESS = By.cssSelector("#address1");
    private static final By ADDRESS_LINE2 = By.cssSelector("#address2");
    private static final By CITY = By.cssSelector("#city");
    private static final By STATE_SELECT = By.cssSelector("#id_state");
    private static final By POSTAL_CODE = By.cssSelector("#postcode");
    private static final By COUNTRY_SELECT = By.cssSelector("#id_state");
    private static final By ADD_INFO = By.cssSelector("#other");
    private static final By HOME_PHONE = By.cssSelector("#phone");
    private static final By MOBILE_PHONE = By.cssSelector("#phone_mobile");
    private static final By ADDRESS_ALIAS = By.cssSelector("#alias");

    private static final By REGISTER_BTN = By.cssSelector("#submitAccount");

    private static final By ALERT_INFO = By.cssSelector("#center_column > div");
    private static final By ALERT_INFO_FIELDS = By.cssSelector("#account-creation_form > div.submit.clearfix > p");

    public void fillingFieldsAndCreateAcc(
            String customerFirstName,
            String customerLastName,
            String email,
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
    ) {
        type(customerFirstName, CUSTOMER_FIRST_NAME);
        type(customerLastName, CUSTOMER_LAST_NAME);
        //generateNewRandomEmail(5);
        type(email, EMAIL);
        type(passwd, PASSWD);
//        type(name, NAME);
//        type(lastName, LAST_NAME);
        type(address, ADDRESS);
        type(addressLine2, ADDRESS_LINE2);
        type(city, CITY);
        select(stateSelect, STATE_SELECT);
        type(postalCode, POSTAL_CODE);
        select(countrySelect, COUNTRY_SELECT);
//        type(addInfo, ADD_INFO);
        type(homePhone, HOME_PHONE);
        type(mobilePhone, MOBILE_PHONE);
//        type(addressAlias, ADDRESS_ALIAS);
        waitABit(5);
        click(REGISTER_BTN);

    }


//    public void checkAlertInfo(String text) {
//        Assertions.assertTrue(driver.findElement(ALERT_INFO).getText().contains(text));
//    }

//    public void checkAlertInfo(String text) {
//        Assertions.assertAll(
//                () -> assertTrue(driver.findElement(ALERT_INFO).getText().contains(text)),
//                () -> assertTrue(driver.findElement(ALERT_INFO_FIELDS).getText().contains("Required field"))
//        );
//    }

    public String checkAlertInfo(String text) {
        driver.findElement(ALERT_INFO).getText().contains(text);
        return text;
    }

    public String checkAlertInfoFields(String text) {
        driver.findElement(ALERT_INFO_FIELDS).getText().contains("Required field");
        return text;
    }

    public static String getNameFromArr() {
        List<String> names = new ArrayList<>(Arrays.asList("Bill",
                "Paul",
                "Steven",
                "Stephen",
                "Elon",
                "Albert")
        );

        String name = names.get((int) (Math.random() * names.size()));
        return name;
    }

    public static String getLastNameFromArr() {
        List<String> lastNames = new ArrayList(Arrays.asList("Gates",
                "Allen",
                "Jobs",
                "Wozniak",
                "Musk",
                "Einstein")
        );

        String lastName = lastNames.get((int) (Math.random() * lastNames.size()));
        return lastName;
    }

}