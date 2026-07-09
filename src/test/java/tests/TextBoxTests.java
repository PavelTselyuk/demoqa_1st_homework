package tests;

import com.codeborne.selenide.ScrollIntoViewOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase{

    @Test
    void successfulFillAllFieldsTextBoxTest() {
        open("/text-box");
        $("#userName").setValue("Alex Black");
        $("#userEmail").setValue("alex@black.com");
        $("#currentAddress").setValue("first address 1");
        $("#permanentAddress").setValue("second address 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex Black"));
        $("#output #email").shouldHave(text("alex@black.com"));
        $("#output #currentAddress").shouldHave(text("first address 1"));
        $("#output #permanentAddress").shouldHave(text("second address 2"));
    }


    @Test
    void failureIncorrectEmailFormattingFormTest() {
        open("/text-box");
        $("#userEmail").setValue("wrong_formatting");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(255, 0, 0)"));
    }
}
