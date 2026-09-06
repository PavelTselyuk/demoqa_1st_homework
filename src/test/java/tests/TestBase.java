package tests;

import com.codeborne.selenide.Configuration;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.TextBoxPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();


    @BeforeAll
    static void beforeAll() {
//        Properties props = new Properties();
//        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
//            if (input == null) {
//                System.out.println("Файл не найден");
//                return;
//            }
//            props.load(input);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        String url = String.format(
//                "https://%s:%s@selenoid.autotests.cloud/wd/hub",
//                props.getProperty("login"),
//                props.getProperty("password")
//        );

        Configuration.browser = "chrome";
//        Configuration.browserVersion = "144.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000; // default 4000
//        Configuration.remote = url;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

}
