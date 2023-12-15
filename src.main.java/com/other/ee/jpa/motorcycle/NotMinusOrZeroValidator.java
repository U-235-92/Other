package com.other.ee.jpa.motorcycle;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotMinusOrZeroValidator implements ConstraintValidator<NotMinusOrZero, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value > 0;
	}
}
