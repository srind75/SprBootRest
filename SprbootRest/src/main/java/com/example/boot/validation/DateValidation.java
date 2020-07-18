package com.example.boot.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//import com.example.boot.ParseException;

public class DateValidation {

	public static boolean validateJavaDate(String dob) {
		boolean result;
		String cond = "01/01/1980";
		// Check if date is 'null'
		if (dob.trim().equals("")) {
			result = false;
		}

		/* Date is not 'null' */
		else {
			LocalDate todaysdate = LocalDate.now();
			System.out.println("todaysdate : " + todaysdate);

			// String cond = "01/01/1980";
			String input_dob = dob;
			System.out.println("dob : " + dob);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");

			try {
				LocalDate ld = LocalDate.parse(input_dob, f);
				LocalDate cons_dob = LocalDate.parse(cond, f);
				boolean b1 = ld.isBefore(todaysdate);
				boolean b2 = ld.isAfter(cons_dob);
				System.out.println("Checks if this date is after the Todays date. \n" + ": " + b1);

				System.out.println("Checks if this date is less than 1-1-1980 date. \n" + ": " + b2);

				if (b1 && b2) {
					System.out.println("dob    matches the conditions");
					result = true;
					// return result;
				} else {
					System.out.println("dob does not matches the conditions");
					result = false;
				}
			}
			/* Date format is invalid */
			catch (DateTimeParseException e) {
				System.out.println(dob + " is Invalid Date format");
				result = false;
			}
			/* Return true if date format is valid */
		}
		return result;
	}
}
