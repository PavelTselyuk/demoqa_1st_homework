package tests;

import org.junit.jupiter.api.Test;

import static testData.TestData.*;

public class FormTests extends TestBase {

    @Test
    void successfulFillAllFieldsFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeFirstName(testUserAlex.studentFirstName)
                .typeLastName(testUserAlex.studentLastName)
                .typeEmail(testUserAlex.studentEmail)
                .setGender(testUserAlex.gender)
                .typeNumber(testUserAlex.phoneNumber)
                .setDateOfBirth(
                        testUserAlex.dayOfBirth,
                        testUserAlex.monthOfBirth,
                        testUserAlex.yearOfBirth)
                .typeSubjects(testUserAlex.subjects)
                .setHobbies(testUserAlex.hobbies)
                .uploadPicture(testUserAlex.picture)
                .typeCurrentAddress(testUserAlex.address)
                .setStateAndCity(testUserAlex.state, testUserAlex.city)
                .pressSubmitButton();

        registrationPage
                .checkResult("Student Name", String.format("%s %s", testUserAlex.studentFirstName, testUserAlex.studentLastName))
                .checkResult("Student Email", testUserAlex.studentEmail)
                .checkResult("Gender", testUserAlex.gender)
                .checkResult("Mobile", testUserAlex.phoneNumber)
                .checkResult(
                        "Date of Birth",
                        String.format(
                                "%d %s,%s", testUserAlex.dayOfBirth, testUserAlex.monthOfBirth, testUserAlex.yearOfBirth
                        ))
                .checkResult("Subjects", testUserAlex.subjects)
                .checkResult("Hobbies", testUserAlex.hobbies)
                .checkResult("Picture", testUserAlex.picture)
                .checkResult("Address", testUserAlex.address)
                .checkResult("State and City", String.format("%s %s", testUserAlex.state, testUserAlex.city));
    }

    @Test
    void successfulFillRequiredFieldsCFormTest() {
        registrationPage
                .openPage()
                .removeUnnecessaryElements()
                .typeFirstName(testUserRyan.studentFirstName)
                .typeLastName(testUserRyan.studentLastName)
                .typeEmail(testUserRyan.studentEmail)
                .setGender(testUserRyan.gender)
                .typeNumber(testUserRyan.phoneNumber)
                .setDateOfBirth(
                        testUserRyan.dayOfBirth,
                        testUserRyan.monthOfBirth,
                        testUserRyan.yearOfBirth)
                .pressSubmitButton();

        registrationPage
                .checkResult("Student Name", String.format("%s %s", testUserRyan.studentFirstName, testUserRyan.studentLastName))
                .checkResult("Student Email", testUserRyan.studentEmail)
                .checkResult("Gender", testUserRyan.gender)
                .checkResult("Mobile", testUserRyan.phoneNumber)
                .checkResult(
                        "Date of Birth",
                        String.format(
                                "%d %s,%s", testUserRyan.dayOfBirth, testUserRyan.monthOfBirth, testUserRyan.yearOfBirth
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
