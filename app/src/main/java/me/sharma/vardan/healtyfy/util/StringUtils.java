package me.sharma.vardan.healtyfy.util;

import android.text.TextUtils;


/**
 * TODO use a standardised string utils class give proper name and documentation to the methods
 * Created by vardaan sharma on 11/1/16.
 */
public class StringUtils {

    private StringUtils() {

    }

    public static String capitalizeFirstChar(String input) {
        if (input == null || input.length() == 0) return "";
        if (input.length() <= 1) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String serializeNull(String input) {
        return (input == null) ? "" : input;
    }

    public static String capitalizeEachWord(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String anArr : arr) {
            sb.append(Character.toUpperCase(anArr.charAt(0)))
                    .append(anArr.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static String replaceSpaceWithNull(String input) {
        return (TextUtils.isEmpty(input)) ? null : input;
    }

    /**
     * replaces null string with empty string
     *
     * @param input input string which can be null
     * @return returns a string empty string incase the input is null and input otherwise
     */
    public static String replaceNullWithEmptyString(String input) {
        return (TextUtils.isEmpty(input)) ? "" : input;
    }
}
