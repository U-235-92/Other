package com.other.ee.validation.example;

import java.util.Set;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Main {

	public static void main(String[] args) {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		ValidatorFactory factory = Validation.byDefaultProvider().configure().
				messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator( "/Other/src/com/other/ee/validation/example/MyValidationMessages" ))).buildValidatorFactory();
		Validator validator = factory.getValidator();
		ValidObject validObject = getValidObject();
		Set<ConstraintViolation<ValidObject>> violations = validator.validate(validObject);
		violations.forEach(violation -> System.out.println(violation));
	}

	private static ValidObject getValidObject() {
		int[] emptyArr = {};
		int[] size5Arr = { 1, 2, 3, 4, 5 };
		String one = "One";
		String two = "Two";
		String three = "Three";
		String emptyStr = "";
		String nullStr = null;
		int intVal = 99;
		double doubleVal = 100;
		return new ValidObject(emptyArr, doubleVal, nullStr, one, two, three);
	}

}
