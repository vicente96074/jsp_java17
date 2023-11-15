package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validators;

import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validation.IntegerRequired;
import jakarta.validation.ConstraintValidator;

/**
 * Validator for IntegerRequired
 *
 * @author Augusto Vicente
 */
public class IntegerRequiredValidator implements ConstraintValidator<IntegerRequired, Object> {
    @Override
    public boolean isValid(Object value, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        try{
            Integer.parseInt(value.toString());
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
