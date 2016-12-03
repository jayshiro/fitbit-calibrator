package com.jayjay.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraineeMovementsValidator implements Validator {

    private static final Pattern PATTERN = Pattern.compile("^[L|R|M]+$");

    @Override
    public boolean isValid(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if(matcher.find()) {
            return true;
        }
        return false;
    }
}
