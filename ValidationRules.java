package utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;

public class ValidationRules {
//add a static method to validate manu. date : must be in current  year
	// (eg : 1st Jan 2023 onwards)
	public static LocalDate validateManufactureDate(String date) throws InvalidInputException {
		// parse
		LocalDate d1 = LocalDate.parse(date);// yyyy-MM-dd
		// => parsing success!
		LocalDate yearBegin = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		if (d1.isAfter(yearBegin))
			return d1;
		// => invalid date
		throw new InvalidInputException("Manufacture date must be in curnt year!!!!!");

	}

	// add a static method to validate color
	public static Color validateVehicleColor(String clr) {
		// in case of success --rets Colore or JVM will throw the exc : IllegalArgExc
		return Color.valueOf(clr.toUpperCase());
	}

	// Add a validation rule to detect dups
	public static void checkForDup(Map<String, Vehicle> vehicles, String chasisNo) throws InvalidInputException {
		if(vehicles.containsKey(chasisNo))
			throw new InvalidInputException("Dup ch no , Vehicle can't be added!!!!!!");
		System.out.println("no dup found!!!!!!");
			
	}
}
