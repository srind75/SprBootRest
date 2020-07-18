package com.example.boot.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Date;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = BirthDateValidator.class)
public @interface BirthDate {
	//String message() default "{com.dolszewski.blog.UniqueLogin.message}";
	String message() default "Date should not be greater than system date and less than 01-01-1980";
	String ip1() default  "01/01/1980";
	//String ip2() default sysdate;
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
