package tests;

import com.codeborne.selenide.ScrollIntoViewOptions;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests extends TestBase {

    @Test
    void successfulFillAllFieldsFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("alex@black.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("5468484684");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $x("//div[@id='hobbiesWrapper']//label[.='Sports']").click();
        $("#uploadPicture").uploadFromClasspath("images/toad.webp");
        $("#currentAddress").setValue("John Doe 123 Elm Street, Apt 4BNew York, NY 10001");
        $("#state").scrollIntoView(ScrollIntoViewOptions.instant()).click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Alex Black"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("alex@black.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("5468484684"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("15 March,2000"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Hindi"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("toad.webp"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("John Doe 123 Elm Street, Apt 4BNew York, NY 10001"));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
    }

    @Test
    void successfulFillRequiredFieldsCFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ryan");
        $("#lastName").setValue("Gosling");
        $("#userEmail").setValue("rgosl@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1122334455");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("November")).click();
        $(".react-datepicker__year-select").$(byText("1980")).click();
        $(".react-datepicker__day--012:not(.react-datepicker__day--outside-month)").click();
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Ryan Gosling"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("rgosl@gmail.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("1122334455"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("12 November,1980"));
    }

    @Test
    void failureFillNoFieldsFormTest() {
        open("/automation-practice-form");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#genterWrapper input").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
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
