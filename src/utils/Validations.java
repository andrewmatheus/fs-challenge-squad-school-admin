package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    /**
     * Method validateEmail - mail validation, using regex.
     * */
    public static boolean validateEmail(String email) {
        // Sets the regular expression pattern to validate emails
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compiles the pattern into a Pattern object
        Pattern pattern = Pattern.compile(regex);

        //Creates a Matcher object that will compare the email with the pattern
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /**
     * Method validateEmail - mail validation, using regex and return throw error.
     * */
    public static void validateMail(String mail){
        if (!mail.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@.+\\..+$")) {
            throw new IllegalArgumentException("O email informado não é valido!");
        }
    }
    //Method to validate if the Phone is correct
    /**
     * Method validatePhoneNumber - phone validation, using regex and return throw error.
     * */
    public static void validatePhoneNumber(String phoneNumber){
        if (!phoneNumber.matches("\\d{11}")){
            throw new IllegalArgumentException("Número de telefone não é válido, permitido 11 números! Exemplo: 48999999999 ");
        }
    }
}
