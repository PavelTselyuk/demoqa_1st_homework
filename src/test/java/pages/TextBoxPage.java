
package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    // Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");

    public SelenideElement getUserEmailInput() {
        return userEmailInput;
    }

    // Actions
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public TextBoxPage checkFieldById(String id, String value) {
        outputResults.$(byId(id)).shouldHave(text(value));
        return this;
    }

    public TextBoxPage borderOfElemShouldBeColor(SelenideElement element, String color) {
        element.shouldHave(cssValue("border-color", color));
        return this;
    }
}
