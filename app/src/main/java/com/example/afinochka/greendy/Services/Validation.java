package com.example.afinochka.greendy.Services;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isExistEmail(String email){
        return true;
    }

    public static boolean isExistPassword(String password){
        return true;
    }

    public static boolean isValidEmail(String email){

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidName(String name){
        return !name.equals("");
    }

    public static boolean isValidPassword(String password){
        return !password.equals("") && password.length() > 6;
    }

    public static boolean isValidNumber(String number){
        return number.length() == 7 && !number.equals("");
    }
}
