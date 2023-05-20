package utils;

import static utils.ValidationRules.validateManufactureDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;

public class ShowroomUtils {
// Add a static method to return populated list(sample hard coded data) of vehicles
	public static List<Vehicle> populateShowroomList() throws InvalidInputException {
		List<Vehicle> vehicles = new ArrayList<>();
		// String chasisNo, Color vehicleColor, double basePrice, LocalDate
		// manufactureDate, String company
		vehicles.add(new Vehicle("abc-12347", Color.BLACK, 466789, validateManufactureDate("2023-01-10"), "Honda"));
		vehicles.add(new Vehicle("abc-12340", Color.WHITE, 496789, validateManufactureDate("2023-03-10"), "Maruti"));

		vehicles.add(new Vehicle("abc-12342", Color.WHITE, 666789, validateManufactureDate("2023-03-20"), "Honda"));

		vehicles.add(new Vehicle("abc-12345", Color.SILVER, 446789, validateManufactureDate("2023-01-10"), "Ford"));

		vehicles.add(new Vehicle("abc-12344", Color.WHITE, 496789, validateManufactureDate("2023-02-21"), "Honda"));

		vehicles.add(new Vehicle("abc-12349", Color.RED, 526789, validateManufactureDate("2023-01-10"), "Maruti"));
		return vehicles;
	}

	// add a static method to ret populated map of vehicles(sample data)
	public static Map<String, Vehicle> populateVehicleMap(List<Vehicle> vehicles) {
		//create empty HM
		HashMap<String, Vehicle> map=new HashMap<>();
		for(Vehicle v : vehicles)
			map.put(v.getChasisNo(), v);
		return map;
	}
}
