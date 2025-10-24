package com.abha.prep.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = NoWhiteSpaceValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoWhiteSpace {

    String message() default "No whitespace allowed";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
