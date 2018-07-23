package com.logicbig.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

public class RegularAmountValidator implements ConstraintValidator<RegularAmountConstraint, Customer> {

	private static boolean generateErrorMessage(ConstraintValidatorContext context, String errorMessage) {
		context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
		context.disableDefaultConstraintViolation();
		return false;
	}

	private String notDivisable;

	@Override
	public void initialize(RegularAmountConstraint constraint) {
		this.notDivisable = constraint.notDivisable();
	}

	@Override
	public boolean isValid(Customer data, ConstraintValidatorContext cxt) {
		
		String amount = data.getAmount();
		String frequency = data.getFrequency().getText();
		String numberOfWeeks = data.getFrequency().getWeeklyInterval();
		String freqInterval = String.valueOf(Double.valueOf(amount) / Double.valueOf(numberOfWeeks));
		Boolean isDiviable = freqInterval.matches("^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$");

		if (StringUtils.isBlank(frequency) || StringUtils.isBlank(amount) || StringUtils.equals("Monthly" , frequency) || BooleanUtils.isFalse(isDiviable) ) {
			return generateErrorMessage(cxt, this.notDivisable);
		}
		return true;
	}

}
