package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validation;

import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validators.DataRequiredValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataRequiredValidator.class)
public @interface DataRequired {
    String message() default "The field must be an integer";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
