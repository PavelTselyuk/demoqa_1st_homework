package tests;

import com.codeborne.selenide.Configuration;
import entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
//        Configuration.browserVersion = "144.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000; // default 4000
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    User testUserAlex = new User.UserBuilder()
            .studentFirstName("Alex")
            .studentLastName("Black")
            .studentEmail("alex@black.com")
            .gender("Male")
            .phoneNumber("5468484684")
            .dayOfBirth(15)
            .monthOfBirth("March")
            .yearOfBirth("2000")
            .subjects("Hindi")
            .hobbies("Sports")
            .picture("toad.webp")
            .address("John Doe 123 Elm Street, Apt 4BNew York, NY 10001")
            .state("NCR")
            .city("Delhi")
            .build();

    User testUserRyan = new User.UserBuilder()
            .studentFirstName("Ryan")
            .studentLastName("Gosling")
            .studentEmail("rgosl@gmail.com")
            .gender("Male")
            .phoneNumber("1122334455")
            .dayOfBirth(12)
            .monthOfBirth("November")
            .yearOfBirth("1980")
            .build();

    String incorrectInputTextColorFormTest = "rgb(220, 53, 69)";
    String incorrectInputTextColorTextBoxTest = "rgb(255, 0, 0)";
    String wrongFormattedEmail = "wrong_formatting";
    String tooShortPhoneNumber = "123";
    String phoneNumberWithNotAllowedSymbol = "546848468$";
}
