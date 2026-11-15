package tests;

import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void configure() {
        String env = System.getProperty("env", "local");
        System.setProperty("env", env);

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser();
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = config.getBrowserVersion();

        if ("selenoid".equals(env)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(List.of("--disable-dev-shm-usage", "--no-sandbox"));
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = String.format(
                    "https://%s:%s@%s",
                    config.getLogin(),
                    config.getPassword(),
                    config.getRemoteUrl()
            );
        }
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
