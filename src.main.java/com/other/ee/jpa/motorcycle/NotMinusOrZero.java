package com.other.ee.jpa.motorcycle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotMinusOrZeroValidator.class)
public @interface NotMinusOrZero {
	String message() default  "{com.other.ee.jpa.motorcycle.not_minus_value}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
