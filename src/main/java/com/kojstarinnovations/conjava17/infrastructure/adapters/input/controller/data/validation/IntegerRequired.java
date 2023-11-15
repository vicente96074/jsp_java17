package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validation;

import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validators.IntegerRequiredValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntegerRequiredValidator.class)
public @interface IntegerRequired {
    String message() default "The field must be an integer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
