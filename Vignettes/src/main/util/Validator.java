package main.util;

public class Validator {
    //Validating string input
    public static boolean isValidName(String name) {
        return name != null && name.length() > 0;
    }
}
