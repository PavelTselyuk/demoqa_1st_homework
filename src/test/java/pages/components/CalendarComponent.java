package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement chooseMonth = $(".react-datepicker__month-select");
    private final SelenideElement chooseYear = $(".react-datepicker__year-select");

    private final String chooseDayString = ".react-datepicker__day--%03d:not(.react-datepicker__day--outside-month)";

    public void setDate(int day, String month, String year) {
        chooseMonth.selectOption(month);
        chooseYear.selectOption(year);
        $(String.format(chooseDayString, day)).click();
//        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
