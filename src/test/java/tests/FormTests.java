package tests;

import com.codeborne.selenide.ScrollIntoViewOptions;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testData.TestData.*;

public class FormTests extends TestBase {

    @Test
    void successfulFillAllFieldsFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(testUserAlex.studentFirstName);
        $("#lastName").setValue(testUserAlex.studentLastName);
        $("#userEmail").setValue(testUserAlex.studentEmail);
        $("#genterWrapper").$(byText(testUserAlex.gender)).click();
        $("#userNumber").setValue(testUserAlex.phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(testUserAlex.monthOfBirth)).click();
        $(".react-datepicker__year-select").$(byText(testUserAlex.yearOfBirth)).click();
        $(String.format(".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)", testUserAlex.dayOfBirth)).click();
        $("#subjectsInput").setValue(testUserAlex.subjects).pressEnter();
        $x(String.format("//div[@id='hobbiesWrapper']//label[.='%s']", testUserAlex.hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(String.format("images/%s", testUserAlex.picture));
        $("#currentAddress").setValue(testUserAlex.address);
        $("#state").scrollIntoView(ScrollIntoViewOptions.instant()).click();
        $("#state").$(byText(testUserAlex.state)).click();
        $("#city").click();
        $("#city").$(byText(testUserAlex.city)).click();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).sibling(0)
                .shouldHave(text(String.format("%s %s", testUserAlex.studentFirstName, testUserAlex.studentLastName)));
        $(".table-responsive").$(byText("Student Email")).sibling(0)
                .shouldHave(text(testUserAlex.studentEmail));
        $(".table-responsive").$(byText("Gender")).sibling(0)
                .shouldHave(text(testUserAlex.gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0)
                .shouldHave(text(testUserAlex.phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0)
                .shouldHave(text(String.format(
                        "%d %s,%s", testUserAlex.dayOfBirth, testUserAlex.monthOfBirth, testUserAlex.yearOfBirth
                )));
        $(".table-responsive").$(byText("Subjects")).sibling(0)
                .shouldHave(text(testUserAlex.subjects));
        $(".table-responsive").$(byText("Hobbies")).sibling(0)
                .shouldHave(text(testUserAlex.hobbies));
        $(".table-responsive").$(byText("Picture")).sibling(0)
                .shouldHave(text(testUserAlex.picture));
        $(".table-responsive").$(byText("Address")).sibling(0)
                .shouldHave(text(testUserAlex.address));
        $(".table-responsive").$(byText("State and City")).sibling(0)
                .shouldHave(text(String.format("%s %s", testUserAlex.state, testUserAlex.city)));
    }

    @Test
    void successfulFillRequiredFieldsCFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(testUserRyan.studentFirstName);
        $("#lastName").setValue(testUserRyan.studentLastName);
        $("#userEmail").setValue(testUserRyan.studentEmail);
        $("#genterWrapper").$(byText(testUserRyan.gender)).click();
        $("#userNumber").setValue(testUserRyan.phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(testUserRyan.monthOfBirth)).click();
        $(".react-datepicker__year-select").$(byText(testUserRyan.yearOfBirth)).click();
        $(String.format(".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)", testUserRyan.dayOfBirth)).click();
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).sibling(0)
                .shouldHave(text(String.format("%s %s", testUserRyan.studentFirstName, testUserRyan.studentLastName)));
        $(".table-responsive").$(byText("Student Email")).sibling(0)
                .shouldHave(text(testUserRyan.studentEmail));
        $(".table-responsive").$(byText("Gender")).sibling(0)
                .shouldHave(text(testUserRyan.gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0)
                .shouldHave(text(testUserRyan.phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0)
                .shouldHave(text(String.format(
                        "%d %s,%s", testUserRyan.dayOfBirth, testUserRyan.monthOfBirth, testUserRyan.yearOfBirth
                )));
    }

    @Test
    void failureFillNoFieldsFormTest() {
        open("/automation-practice-form");
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
        $("#lastName").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
        $("#userNumber").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
        $("#genterWrapper input").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
    }

    @Test
    void failureIncorrectEmailFormattingFormTest() {
        open("/automation-practice-form");
        $("#userEmail").setValue(wrongFormattedEmail);
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
    }

    @Test
    void failureTooShortPhoneNumberFormTest() {
        open("/automation-practice-form");
        $("#userNumber").setValue(tooShortPhoneNumber);
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
    }

    @Test
    void failureUsingNoDigitsInPhoneNumberFormTest() {
        open("/automation-practice-form");
        $("#userNumber").setValue(phoneNumberWithNotAllowedSymbol);
        $("#submit").scrollIntoView(ScrollIntoViewOptions.instant());
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", incorrectInputTextColorFormTest));
    }
}
