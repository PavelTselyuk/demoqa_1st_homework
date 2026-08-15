package pages;

import com.codeborne.selenide.ScrollIntoViewOptions;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FinalTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    FinalTableComponent finalTableComponent = new FinalTableComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");


    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $x("//div[@id='hobbiesWrapper']");
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement submitButton = $("#submit");

    public SelenideElement getFirstNameInput() {
        return firstNameInput;
    }

    public SelenideElement getLastNameInput() {
        return lastNameInput;
    }

    public SelenideElement getGenderInput() {
        return genderContainer.$("input");
    }

    public SelenideElement getUserEmailInput() {
        return userEmailInput;
    }

    public SelenideElement getUserNumberInput() {
        return userNumberInput;
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("document.getElementById('fixedban')?.remove();");
        executeJavaScript("document.getElementById('footer')?.remove();");
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(int day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        String[] hobbies = value.split(" ");
        for (String hobby : hobbies) {
            hobbiesContainer.$x(String.format(".//label[.='%s']", hobby)).click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(String.format("images/%s", value));
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    private RegistrationPage setState(String value) {
        stateSelect.scrollIntoView(ScrollIntoViewOptions.instant());
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    private RegistrationPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public void pressSubmitButton() {
        submitButton.scrollIntoView(ScrollIntoViewOptions.instant());
        submitButton.click();
    }

    public RegistrationPage checkResult(String key, String value) {
        finalTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrationPage borderOfElemShouldBeColor(SelenideElement element, String color) {
        element.shouldHave(cssValue("border-color", color));
        return this;
    }
}
