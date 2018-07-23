package com.logicbig.example;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Constraint(validatedBy = RegularAmountValidator.class)
@ReportAsSingleViolation
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface RegularAmountConstraint {

	Class<?>[] groups() default {};

	String message() default "{generic.default}";

	Class<? extends Payload>[] payload() default {};

	String notDivisable() default "{not.weeklyDiviasble}";

}
