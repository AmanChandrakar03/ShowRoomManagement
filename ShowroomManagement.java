package tester;

import static utils.ShowroomUtils.populateShowroomList;
import static utils.ShowroomUtils.populateVehicleMap;
import static utils.ValidationRules.checkForDup;
import static utils.ValidationRules.validateManufactureDate;
import static utils.ValidationRules.validateVehicleColor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.InvalidInputException;

public class ShowroomManagement {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get populated map of vehicles from Showroom utils
			Map<String, Vehicle> showroom = populateVehicleMap(populateShowroomList());// size: list.size, init capa 16,
																						// l.f=.75
			boolean exit = false;

			while (!exit) {
				System.out.println("1. Add a Vehicle 2. Display all 3. Display specific vehicle details"
						+ "4. Apply discount 5. Remove specific vehicle details "
						+ "6. Sort vehicles as per ch no (asc) 7. Sort Vehicles as per desc price "
						+ "8. Sort vehicles as per date 9. Sort vehicle details , as per date n price 0. Exit");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:

						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  basePrice,  manufactureDate,  company");
						String chNo = sc.next();
						checkForDup(showroom, chNo);
						// invoke validation rule : color
						Color clr = validateVehicleColor(sc.next());
						double basePrice = sc.nextDouble() + clr.getAdditionalCost();
						LocalDate date = validateManufactureDate(sc.next());
						String company = sc.next();
						// => validation success --so create vehicle object n add it's ref in the array
						showroom.put(chNo, new Vehicle(chNo, clr, basePrice, date, company));
						System.out.println("vehicle added to the showroom!");
						break;
					case 2:
						System.out.println("Showroom details ");
						for (Vehicle v : showroom.values())
							System.out.println(v);// v.toString()
						break;

					case 3:
						// search(PK based) n then retrieve
						System.out.println("Enter ch  no(PK)");
						Vehicle v1 = showroom.get(sc.next());
						if (v1 == null)
							throw new InvalidInputException("Invalid ch no , Vehile not found!!!!");
						// => vehicle found
						System.out.println(v1);
						break;

					case 4:
						// search criteria (date) : value based !
						System.out.println("Enter date(yr-mon-day) n discount amount");
						date = validateManufactureDate(sc.next());
						double discount = sc.nextDouble();
						for (Vehicle v : showroom.values())
							if (v.getManufactureDate().isBefore(date))
								v.setBasePrice(v.getBasePrice() - discount);
						break;
					case 5:
						System.out.println("Enter ch no , to delete vehicle details");
						// remove using key
						v1 = showroom.remove(sc.next());
						if (v1 == null)
							throw new InvalidInputException(
									"Invalid ch no , Vehile not found, details can't be removed !!!!");
						System.out.println("Removed vehicle details " + v1);
						break;
					case 6:
						System.out.println("sorting the vehicle list as per asc ch no");
						// TreeMap : since it involves key based sorting
						// choose Natural ordering : asc order
						// TreeMap(Map<? extends K,? extends V> map)
						TreeMap<String, Vehicle> sortedVehicles = new TreeMap<>(showroom);// internally invokes
																							// String(key) 's compareTo
						// display the vehicle
						System.out.println("Sorted vehicle as per ch no : asc");
						for (Vehicle v : sortedVehicles.values())
							System.out.println(v);
						break;
					case 7:
						System.out.println("sorting the list : desc price : pending");
							Collection<Vehicle> coll = showroom.values();
							ArrayList<Vehicle> list = new ArrayList<>(coll);
							Collections.sort(list, (o1,o2)->((Double)o1.getBasePrice()).compareTo(o2.getBasePrice()));
							list.forEach(a->System.out.println(a));
						
						break;
					case 8:
						System.out.println("soritng the list : date : pending");
						Collection<Vehicle> colls = showroom.values();
						ArrayList<Vehicle> lists = new ArrayList<>(colls);
						Collections.sort(lists, (o1,o2)->(o1.getManufactureDate().compareTo(o2.getManufactureDate())));
						lists.forEach(a->System.out.println(a));
						break;
					case 9:
						System.out.println("soritng the list : date : pending");
						break;
					case 0:
						exit = true;
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
					// read off all pending tokens from the scanner
					sc.nextLine();
				}
			}

		} catch (Exception e) { // outer catch-all
			e.printStackTrace();
		}

	}

}
