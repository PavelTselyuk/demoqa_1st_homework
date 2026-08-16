package testData;

import entities.User;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class TestData {

    //    private static final Faker faker = new Faker();
    private final Faker faker = new Faker();


    private String[] randomDayMonthYear;

    private String[] getRandomDayMonthYear() {
        LocalDate birthday = faker.timeAndDate().birthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        randomDayMonthYear = birthday.format(formatter).split(" ");
        return randomDayMonthYear;
    }

    private static final Map<String, String[]> statesAndCities = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    private String state;

    private String getState() {
        state = faker.options().option(statesAndCities.keySet().toArray(new String[0]));
        return state;
    }

    private String getCity() {
        return faker.options().option(statesAndCities.get(state));
    }

    public User getTestUser() {
        return new User.UserBuilder()
                .studentFirstName(faker.name().firstName())
                .studentLastName(faker.name().lastName())
                .studentEmail(faker.internet().emailAddress())
                .gender(faker.options().option("Male", "Female", "Other"))
                .phoneNumber(faker.expression("#{numerify '##########'}"))
                .dayOfBirth(Integer.parseInt(getRandomDayMonthYear()[0]))
                .monthOfBirth(randomDayMonthYear[1])
                .yearOfBirth(randomDayMonthYear[2])
                .subjects(faker.options().option("Physics", "Chemistry", "Hindi", "English", "Biology", "Maths", "Computer Science"))
                .hobbies(faker.options().option("Sports", "Reading", "Music"))
                .picture("toad.webp")
                .address(faker.address().fullAddress())
                .state(getState())
                .city(getCity())
                .build();
    }

    public static final String INCORRECT_INPUT_TEXT_COLOR_FORM_TEST = "rgb(220, 53, 69)";
    public static final String INCORRECT_INPUT_TEXT_COLOR_TEXT_BOX_TEST = "rgb(255, 0, 0)";
    public static final String WRONG_FORMATTED_EMAIL = "wrong_formatting";
    public static final String TOO_SHORT_PHONE_NUMBER = "123";
    public static final String PHONE_NUMBER_WITH_NOT_ALLOWED_SYMBOL = "546848468$";
}
