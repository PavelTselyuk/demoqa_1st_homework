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

    public static String incorrectInputTextColorFormTest = "rgb(220, 53, 69)";
    public static String incorrectInputTextColorTextBoxTest = "rgb(255, 0, 0)";
    public static String wrongFormattedEmail = "wrong_formatting";
    public static String tooShortPhoneNumber = "123";
    public static String phoneNumberWithNotAllowedSymbol = "546848468$";
}
