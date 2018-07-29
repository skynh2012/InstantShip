package com.anhtd.instantship.utils;

/**
 * Created by DuyAnh on 07/08/2017.
 */

public class StringUtil {

    /**
     * Check format of email
     *
     * @param target is a email need checking
     */
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    /**
     * Check field not empty and 6 word
     *
     * @param input text input
     */
    public static boolean isGoodField(String input) {
        if (input == null || input.isEmpty() || input.length() < 6)
            return false;
        return true;
    }

    public static boolean isGoodPasswordField(String input) {
        if (input == null || input.isEmpty() || input.length() < 6 || input.length() > 32)
            return false;
        return true;
    }

    /**
     * Check field not empty
     *
     * @param input text input
     */
    public static boolean isEmpty(String input) {
        if (input == null || input.isEmpty())
            return true;
        return false;
    }

    /**
     * Check field not empty and 9 to 11 word
     *
     * @param input number input
     */

    public static boolean phoneSuscess(String input) {
        if (input == null || input.isEmpty() || input.length() > 11 || input.length() < 9)
            return false;
        return true;
    }

    /**
     * get action of url request
     *
     * @param url
     */
    public static String getAction(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.length());
    }
}