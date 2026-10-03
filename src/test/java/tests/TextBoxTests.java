package tests;

import org.junit.jupiter.api.Test;

import static testData.TestData.*;

public class TextBoxTests extends TestBase {


    @Test
    void successfulFillAllFieldsTextBoxTest() {
        textBoxPage
                .openPage()
                .typeUserName(String.format("%s %s", testUserAlex.studentFirstName, testUserAlex.studentLastName))
                .typeUserEmail(testUserAlex.studentEmail)
                .typeCurrentAddress(String.format("Current: %s", testUserAlex.address))
                .typePermanentAddress(String.format("Permanent: %s", testUserAlex.address))
                .submitForm();

        textBoxPage
                .checkFieldById("name", String.format("%s %s", testUserAlex.studentFirstName, testUserAlex.studentLastName))
                .checkFieldById("email", testUserAlex.studentEmail)
                .checkFieldById("currentAddress", String.format("Current: %s", testUserAlex.address))
                .checkFieldById("permanentAddress", String.format("Permanent: %s", testUserAlex.address));
    }


    @Test
    void failureIncorrectEmailFormattingFormTest() {
        textBoxPage
                .openPage()
                .typeUserEmail(WRONG_FORMATTED_EMAIL)
                .submitForm();

        textBoxPage
                .borderOfElemShouldBeColor(textBoxPage.getUserEmailInput(), INCORRECT_INPUT_TEXT_COLOR_TEXT_BOX_TEST);

    }
}
