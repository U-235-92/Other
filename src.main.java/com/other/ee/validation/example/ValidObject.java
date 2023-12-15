package com.other.ee.validation.example;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ClassValidAnnotation(string = "", groups = OneValidGroup.class)
public class ValidObject {

	@NotNull
	@Size(min = 2, max = 5)
	private int[] intArrayValid;
	@Max(value = 100)
	private double doubleValueValid;
	@StringValidAnnotation
	private String stringValueValid;
	@NotNull(groups = OneValidGroup.class)
	private String classValueValidOne;
	@NotNull(groups = TwoValidGroup.class)
	private String classValueValidTwo;
	@NotNull
	private String classValueValidThree;
	
	public ValidObject() { super(); }

	public ValidObject(@NotNull @Size(min = 2, max = 5) int[] intArrayValid, @Max(100) double doubleValueValid,
			String stringValueValid, @NotNull(groups = OneValidGroup.class) String classValueValidOne,
			@NotNull(groups = TwoValidGroup.class) String classValueValidTwo, @NotNull String classValueValidThree) {
		super();
		this.intArrayValid = intArrayValid;
		this.doubleValueValid = doubleValueValid;
		this.stringValueValid = stringValueValid;
		this.classValueValidOne = classValueValidOne;
		this.classValueValidTwo = classValueValidTwo;
		this.classValueValidThree = classValueValidThree;
	}

	public @AssertTrue boolean isValidBooleanMethod(@NotNull Object validParameter) {
		return validParameter.getClass() == Object.class;
	}

	public int[] getIntArrayValid() {
		return intArrayValid;
	}

	public void setIntArrayValid(int[] intArrayValid) {
		this.intArrayValid = intArrayValid;
	}

	public double getDoubleValueValid() {
		return doubleValueValid;
	}

	public void setDoubleValueValid(double doubleValueValid) {
		this.doubleValueValid = doubleValueValid;
	}

	public String getStringValueValid() {
		return stringValueValid;
	}

	public void setStringValueValid(String stringValueValid) {
		this.stringValueValid = stringValueValid;
	}

	public String getClassValueValidOne() {
		return classValueValidOne;
	}

	public void setClassValueValidOne(String classValueValidOne) {
		this.classValueValidOne = classValueValidOne;
	}

	public String getClassValueValidTwo() {
		return classValueValidTwo;
	}

	public void setClassValueValidTwo(String classValueValidTwo) {
		this.classValueValidTwo = classValueValidTwo;
	}

	public String getClassValueValidThree() {
		return classValueValidThree;
	}

	public void setClassValueValidThree(String classValueValidThree) {
		this.classValueValidThree = classValueValidThree;
	}
}
