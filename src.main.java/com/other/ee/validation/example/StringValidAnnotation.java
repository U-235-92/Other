package com.other.ee.validation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@NotNull
@Size(min = 5, max = 10)
@ReportAsSingleViolation
@Constraint(validatedBy = {})
public @interface StringValidAnnotation {
	String message() default  "{com.other.ee.validation.string_validation_error_msg}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
