package com.youngstone.mastery.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductRequestValidator.class)
public @interface ProductRequestConstraint {
    String message() default "Invalid product request data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
