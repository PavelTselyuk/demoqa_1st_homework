package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static testData.TestData.*;

public class TextBoxTests extends TestBase {


    @BeforeEach
    void prepareRandomData() {
        testUser = getTestUser();
    }

    @Test
    void successfulFillAllFieldsTextBoxTest() {
        textBoxPage
                .openPage()
                .typeUserName(String.format("%s %s", testUser.studentFirstName, testUser.studentLastName))
                .typeUserEmail(testUser.studentEmail)
                .typeCurrentAddress(String.format("Current: %s", testUser.address))
                .typePermanentAddress(String.format("Permanent: %s", testUser.address))
                .submitForm();

        textBoxPage
                .checkFieldById("name", String.format("%s %s", testUser.studentFirstName, testUser.studentLastName))
                .checkFieldById("email", testUser.studentEmail)
                .checkFieldById("currentAddress", String.format("Current: %s", testUser.address))
                .checkFieldById("permanentAddress", String.format("Permanent: %s", testUser.address));
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
