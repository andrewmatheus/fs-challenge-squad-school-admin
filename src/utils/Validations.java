package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static boolean validateEmail(String email) {
        // Sets the regular expression pattern to validate emails
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compiles the pattern into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        //Creates a Matcher object that will compare the email with the pattern
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
