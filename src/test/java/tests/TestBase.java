package tests;

import com.codeborne.selenide.Configuration;
import entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public RegistrationPage registrationPage = new RegistrationPage();
    public TextBoxPage textBoxPage = new TextBoxPage();
    public User testUser;


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

}
