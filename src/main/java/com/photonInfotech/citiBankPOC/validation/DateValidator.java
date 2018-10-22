package com.photonInfotech.citiBankPOC.validation;

import com.photonInfotech.citiBankPOC.validation.annotation.DateAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateAnnotation, String> {

    @Override
    public void initialize(DateAnnotation paramA) {
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext ctx) {
        if (date == null) {
            return false;
        }
        // validate date Full Date Validation (YYYY-MM-DD)
        if (date.matches(
                "^(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))$")) {
            return true;

        }
        // validate date Full Date Validation (MM/DD/YYYY)
        else if (date.matches(
                "^(?:(?:0[1-9]|1[0-2])[\\/\\\\-. ]?(?:0[1-9]|[12][0-9])|(?:(?:0[13-9]|1[0-2])[\\/\\\\-. ]?30)|(?:(?:0[13578]|1[02])[\\/\\\\-. ]?31))[\\/\\\\-. ]?(?:19|20)[0-9]{2}$")) {
            return true;

        }

        // return false if nothing matches the input
        else
            return false;

    }

}
