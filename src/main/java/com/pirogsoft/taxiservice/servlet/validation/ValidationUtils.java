package com.pirogsoft.taxiservice.servlet.validation;

import com.pirogsoft.taxiservice.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+\\d+$");

    public static void validatePhone(List<String> errors, String value) {
        ValidationUtils.validateMandatory(errors, value, "phone");
        if (!StringUtils.isEmptyOrNull(value)) {
            Matcher matcher = PHONE_PATTERN.matcher(value);
            if (!matcher.matches()) {
                errors.add("Phone should follow the format +xxxxxxxxxxxx");
            }
        }
    }

    public static void validateEmail(List<String> errors, String value) {
        ValidationUtils.validateMandatory(errors, value, "email");
        if (!StringUtils.isEmptyOrNull(value)) {
            Matcher matcher = EMAIL_PATTERN.matcher(value);
            if (!matcher.matches()) {
                errors.add("Email is not valid");
            }
        }
    }

    public static void validateLogin(List<String> errors, String value) {
        ValidationUtils.validateMandatory(errors, value, "login");
    }

    public static void validatePassword(List<String> errors, String value) {
        ValidationUtils.validateMandatory(errors, value, "password");
        //TODO: maybe some additional validation
    }

    public static void validateSurname(List<String> errors, String value) {
        ValidationUtils.validateMandatory(errors, value, "surname");
        //TODO: maybe some additional validation
    }

    public static void validateLastName(List<String> errors, String value) {
        ValidationUtils.validateMandatory(errors, value, "lastname");
        //TODO: maybe some additional validation
    }

    public static void validateMandatory(List<String> errors, String value, String fieldName) {
        if (StringUtils.isEmptyOrNull(value)) {
            errors.add(fieldName + "is mandatory");
        }
    }
}
