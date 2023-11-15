package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validators;

import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validation.DataRequired;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DataRequiredValidator implements ConstraintValidator<DataRequired, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.isEmpty();
    }
}
