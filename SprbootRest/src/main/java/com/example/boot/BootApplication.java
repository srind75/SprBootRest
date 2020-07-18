package com.example.boot;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.boot.validation.DateValidation;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);

		// boolean status = DateValidation.validateJavaDate("01/01/1979");
		// System.out.println("status: " + status);
	//	 boolean status1 = DateValidation.validateJavaDate("01/01/1981");
	//	 System.out.println("status1: " + status1);
		//boolean status2 = DateValidation.validateJavaDate("01/01/2021");
		//System.out.println("status2: " + status2);

	}

}
