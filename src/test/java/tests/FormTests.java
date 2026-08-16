package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testData.TestData;

import static testData.TestData.*;

public class FormTests extends TestBase {

    @BeforeEach
    void prepareRandomData() {
        testUser = new TestData().getTestUser();
        System.out.println(testUser);
    }

    @Test
    void successfulFillAllFieldsFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeFirstName(testUser.studentFirstName)
                .typeLastName(testUser.studentLastName)
                .typeEmail(testUser.studentEmail)
                .setGender(testUser.gender)
                .typeNumber(testUser.phoneNumber)
                .setDateOfBirth(
                        testUser.dayOfBirth,
                        testUser.monthOfBirth,
                        testUser.yearOfBirth)
                .typeSubjects(testUser.subjects)
                .setHobbies(testUser.hobbies)
                .uploadPicture(testUser.picture)
                .typeCurrentAddress(testUser.address)
                .setStateAndCity(testUser.state, testUser.city)
                .pressSubmitButton();

        registrationPage
                .checkResult("Student Name", String.format("%s %s", testUser.studentFirstName, testUser.studentLastName))
                .checkResult("Student Email", testUser.studentEmail)
                .checkResult("Gender", testUser.gender)
                .checkResult("Mobile", testUser.phoneNumber)
                .checkResult(
                        "Date of Birth",
                        String.format(
                                "%d %s,%s", testUser.dayOfBirth, testUser.monthOfBirth, testUser.yearOfBirth
                        ))
                .checkResult("Subjects", testUser.subjects)
                .checkResult("Hobbies", testUser.hobbies)
                .checkResult("Picture", testUser.picture)
                .checkResult("Address", testUser.address)
                .checkResult("State and City", String.format("%s %s", testUser.state, testUser.city));
    }

    @Test
    void successfulFillRequiredFieldsCFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeFirstName(testUser.studentFirstName)
                .typeLastName(testUser.studentLastName)
                .typeEmail(testUser.studentEmail)
                .setGender(testUser.gender)
                .typeNumber(testUser.phoneNumber)
                .setDateOfBirth(
                        testUser.dayOfBirth,
                        testUser.monthOfBirth,
                        testUser.yearOfBirth)
                .pressSubmitButton();

        registrationPage
                .checkResult("Student Name", String.format("%s %s", testUser.studentFirstName, testUser.studentLastName))
                .checkResult("Student Email", testUser.studentEmail)
                .checkResult("Gender", testUser.gender)
                .checkResult("Mobile", testUser.phoneNumber)
                .checkResult(
                        "Date of Birth",
                        String.format(
                                "%d %s,%s", testUser.dayOfBirth, testUser.monthOfBirth, testUser.yearOfBirth
                        ));
    }

    @Test
    void failureFillNoFieldsFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .pressSubmitButton();

        registrationPage
                .borderOfElemShouldBeColor(registrationPage.getFirstNameInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST)
                .borderOfElemShouldBeColor(registrationPage.getLastNameInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST)
                .borderOfElemShouldBeColor(registrationPage.getUserNumberInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST)
                .borderOfElemShouldBeColor(registrationPage.getGenderInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST);

    }

    @Test
    void failureIncorrectEmailFormattingFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeEmail(WRONG_FORMATTED_EMAIL)
                .pressSubmitButton();

        registrationPage
                .borderOfElemShouldBeColor(registrationPage.getUserEmailInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST);
    }

    @Test
    void failureTooShortPhoneNumberFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeNumber(TOO_SHORT_PHONE_NUMBER)
                .pressSubmitButton();

        registrationPage
                .borderOfElemShouldBeColor(registrationPage.getUserNumberInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST);
    }

    @Test
    void failureUsingNoDigitsInPhoneNumberFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeNumber(PHONE_NUMBER_WITH_NOT_ALLOWED_SYMBOL)
                .pressSubmitButton();

        registrationPage
                .borderOfElemShouldBeColor(registrationPage.getUserNumberInput(), INCORRECT_INPUT_TEXT_COLOR_FORM_TEST);
    }
}
