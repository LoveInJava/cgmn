package com.abha.prep.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoWhiteSpaceValidator implements ConstraintValidator<NoWhiteSpace, String> {
    //private String requiredPrefix;
    @Override
    public void initialize(NoWhiteSpace constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        //this.requiredPrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("Coming Value : "+input);
        if(input.contains(" ")){
            return false;
        }
        return true;
    }
}
