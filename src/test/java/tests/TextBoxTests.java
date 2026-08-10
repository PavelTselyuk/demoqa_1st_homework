package tests;

import com.codeborne.selenide.ScrollIntoViewOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testData.TestData.*;

public class TextBoxTests extends TestBase {


    @Test
    void successfulFillAllFieldsTextBoxTest() {
        open("/text-box");
        $("#userName").setValue(String.format("%s %s", testUserAlex.studentFirstName, testUserAlex.studentLastName));
        $("#userEmail").setValue(testUserAlex.studentEmail);
        $("#currentAddress").setValue(String.format("Curr: %s", testUserAlex.address));
        $("#permanentAddress").setValue(String.format("Perm: %s", testUserAlex.address));
        $("#submit").click();

        $("#output #name")
                .shouldHave(text(String.format("%s %s", testUserAlex.studentFirstName, testUserAlex.studentLastName)));
        $("#output #email").shouldHave(text(testUserAlex.studentEmail));
        $("#output #currentAddress").shouldHave(text(String.format("Curr: %s", testUserAlex.address)));
        $("#output #permanentAddress").shouldHave(text(String.format("Perm: %s", testUserAlex.address)));
    }


    @Test
    void failureIncorrectEmailFormattingFormTest() {
        open("/text-box");
        $("#userEmail").setValue(WRONG_FORMATTED_EMAIL);
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", INCORRECT_INPUT_TEXT_COLOR_TEXT_BOX_TEST));
    }
}
