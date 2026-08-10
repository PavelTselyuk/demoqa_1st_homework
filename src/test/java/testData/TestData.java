package testData;

import entities.User;

public class TestData {

    public static User testUserAlex = new User.UserBuilder()
            .studentFirstName("Alex")
            .studentLastName("Black")
            .studentEmail("alex@black.com")
            .gender("Male")
            .phoneNumber("5468484684")
            .dayOfBirth(15)
            .monthOfBirth("March")
            .yearOfBirth("2000")
            .subjects("Hindi")
            .hobbies("Sports")
            .picture("toad.webp")
            .address("John Doe 123 Elm Street, Apt 4BNew York, NY 10001")
            .state("NCR")
            .city("Delhi")
            .build();

    public static User testUserRyan = new User.UserBuilder()
            .studentFirstName("Ryan")
            .studentLastName("Gosling")
            .studentEmail("rgosl@gmail.com")
            .gender("Male")
            .phoneNumber("1122334455")
            .dayOfBirth(12)
            .monthOfBirth("November")
            .yearOfBirth("1980")
            .build();

    public static final String INCORRECT_INPUT_TEXT_COLOR_FORM_TEST = "rgb(220, 53, 69)";
    public static final String INCORRECT_INPUT_TEXT_COLOR_TEXT_BOX_TEST = "rgb(255, 0, 0)";
    public static final String WRONG_FORMATTED_EMAIL = "wrong_formatting";
    public static final String TOO_SHORT_PHONE_NUMBER = "123";
    public static final String PHONE_NUMBER_WITH_NOT_ALLOWED_SYMBOL = "546848468$";
}
