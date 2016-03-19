package me.sharma.vardan.healtyfy.util;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Utility class for validating stuff
 */
public class Validator {
    public static final String EMAIL_REGEX =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    private Validator() {
        throw new AssertionError("make no instance");
    }

    public static boolean isValidEmail(String input) {
        return !TextUtils.isEmpty(input) && Pattern.matches(EMAIL_REGEX, input);
    }

    public static boolean isPhoneNumber(String input) {
        return TextUtils.getTrimmedLength(input) > 9 && TextUtils.getTrimmedLength(input) > 13;
    }
}