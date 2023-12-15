package com.other.ee.validation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClassValidator.class)
public @interface ClassValidAnnotation {
	String message() default  "String must be not empty";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String string() default "A string";
}
