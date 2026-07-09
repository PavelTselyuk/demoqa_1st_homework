package tests;

import com.codeborne.selenide.ScrollIntoViewOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormTests extends TestBase {

    @Test
    void successfulFillAllFieldsFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("alex@black.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("5468484684");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys("15 Mar 2000");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#currentAddress").setValue("John Doe123 Elm Street, Apt 4BNew York, NY 10001");
        $("#state svg").scrollIntoView(ScrollIntoViewOptions.instant()).click();
        $("#react-select-3-option-0").click();
        $("#city svg").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $x("//div[@class='table-responsive']//tbody//tr[1]/td[2]").shouldHave(text("Alex Black"));
        $x("//div[@class='table-responsive']//tbody//tr[2]/td[2]").shouldHave(text("alex@black.com"));
        $x("//div[@class='table-responsive']//tbody//tr[3]/td[2]").shouldHave(text("Male"));
        $x("//div[@class='table-responsive']//tbody//tr[4]/td[2]").shouldHave(text("5468484684"));
        $x("//div[@class='table-responsive']//tbody//tr[5]/td[2]").shouldHave(text("15 March,2000"));
        $x("//div[@class='table-responsive']//tbody//tr[6]/td[2]").shouldHave(text("Hindi"));
        $x("//div[@class='table-responsive']//tbody//tr[7]/td[2]").shouldHave(text("Sports"));
        $x("//div[@class='table-responsive']//tbody//tr[9]/td[2]").shouldHave(text("John Doe123 Elm Street, Apt 4BNew York, NY 10001"));
        $x("//div[@class='table-responsive']//tbody//tr[10]/td[2]").shouldHave(text("NCR Delhi"));
    }

    @Test
    void successfulFillRequiredFieldsCFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ryan");
        $("#lastName").setValue("Gosling");
        $("#userEmail").setValue("rgosl@gmail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("1122334455");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys("12 Nov 1980");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $x("//div[@class='table-responsive']//tbody//tr[1]/td[2]").shouldHave(text("Ryan Gosling"));
        $x("//div[@class='table-responsive']//tbody//tr[2]/td[2]").shouldHave(text("rgosl@gmail.com"));
        $x("//div[@class='table-responsive']//tbody//tr[3]/td[2]").shouldHave(text("Male"));
        $x("//div[@class='table-responsive']//tbody//tr[4]/td[2]").shouldHave(text("1122334455"));
        $x("//div[@class='table-responsive']//tbody//tr[5]/td[2]").shouldHave(text("12 November,1980"));
    }

    @Test
    void failureFillNoFieldsFormTest() {
        open("/automation-practice-form");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#gender-radio-1").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void failureIncorrectEmailFormattingFormTest() {
        open("/automation-practice-form");
        $("#userEmail").setValue("wrong_formatting");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void failureTooShortPhoneNumberFormTest() {
        open("/automation-practice-form");
        $("#userNumber").setValue("123");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void failureUsingNoDigitsInPhoneNumberFormTest() {
        open("/automation-practice-form");
        $("#userNumber").setValue("546848468$");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
