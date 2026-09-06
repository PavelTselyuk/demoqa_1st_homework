package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static testData.TestData.*;

public class FormTestsRegistration extends TestBase {

    @Test
    void successfulFillAllFieldsFormTest() {
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Fulfill all information", () -> {
            registrationPage
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
        });
        step("Check results", () -> {
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
        });
    }
}
