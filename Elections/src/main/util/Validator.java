package main.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Validator {
    public static boolean isValidString(String text) {
        return text != null && text.length() > 0;
    }

    public static boolean isValidDateRange(LocalDate startDate,
                                           LocalDate endDate) {
        return Period.between(startDate, endDate).getDays() > 0;
    }
}
