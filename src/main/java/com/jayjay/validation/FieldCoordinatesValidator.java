package com.jayjay.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCoordinatesValidator implements Validator {

    private static final Pattern PATTERN = Pattern.compile("^\\d+\\s\\d+$");

    @Override
    public boolean isValid(String str) {
        if(str != null) {
            Matcher matcher = PATTERN.matcher(str);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
