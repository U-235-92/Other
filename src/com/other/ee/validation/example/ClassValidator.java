package com.other.ee.validation.example;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClassValidator implements ConstraintValidator<ClassValidAnnotation, ValidObject>{

	private String validString;
	
	@Override
	public void initialize(ClassValidAnnotation constraintAnnotation) {
		validString = constraintAnnotation.string();
	}
	
	@Override
	public boolean isValid(ValidObject value, ConstraintValidatorContext context) {
		if(validString.equals("")) {
			return false;
		} 
		if(value.getClassValueValidOne().equals("One") || 
				value.getClassValueValidTwo().equals("Two") ||
				value.getClassValueValidThree().equals("Three")) {
			return true;
		}
		return false;
	}

}
