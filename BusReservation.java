package problem46;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class BusReserve {
	int id;
	String name;
	String mobileNo;
	String dob;
	int age;
	String address;
	LocalDate date;
	Double time;
	String source;
	String destination;
	static int objectCount = 0;

	public BusReserve() {
		this.id = 0;
		this.name = " ";
		this.mobileNo = " ";
		this.dob = " ";
		this.age = 0;
		this.address = " ";
		this.date = null;
		this.time = 0.0;
		this.source = " ";
		this.destination = " ";
	}

	public BusReserve(int id, String name, String mobileNo, String dob, int age, String address) {

		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.dob = dob;
		this.age = age;
		this.address = address;
		objectCount++;
	}

	public BusReserve(int id, String mobileNo, String source, String destination, LocalDate date, Double time) {

		this.id = id;
		this.mobileNo = mobileNo;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		objectCount++;

	}

	public static void cityDisplay(BusReserve[] b, BusReserve[] ticket, String city) {

		int size1 = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] != null) {
				size1++;
			}
		}
		int size2 = 0;
		for (int i = 0; i < ticket.length; i++) {
			if (ticket[i] != null) {
				size2++;
			}
		}

		for (int i = 0; i < size1; i++) {
			for (int m = 0; m < size2; m++)
				if (b[i].id == ticket[m].id) {
					if (!b[i].equals(ticket[m]))
						b[i].source = ticket[m].source;
					b[i].destination = ticket[m].destination;
					b[i].date = ticket[m].date;
					b[i].time = ticket[m].time;
				}
		}

		BusReserve displayCity[];
		displayCity = new BusReserve[size1];
		int j = 0;
		for (int i = 0; i < size1; i++) {
			displayCity[j] = b[i];
			j++;
		}

		int flag = 1;
		if (displayCity.length > 0) {
			for (int i = 0; i < displayCity.length; i++) {
				if (displayCity[i].source == null || displayCity[i].destination == null) {
					if (displayCity[i].address.equalsIgnoreCase(city)) {
						System.out.println("Customers in city " + city);
						System.out.println("customer id: " + displayCity[i].id + "\nName: " + displayCity[i].name
								+ "\nmobileNumber: " + displayCity[i].mobileNo + "\ndate of birth: "
								+ displayCity[i].dob + "\nage: " + displayCity[i].age + "\naddress: "
								+ displayCity[i].address + "\n");
						flag = 1;

					} else
						flag = 0;
				} else {
					if (displayCity[i].address.equalsIgnoreCase(city) || displayCity[i].source.equalsIgnoreCase(city)
							|| displayCity[i].destination.equalsIgnoreCase(city)) {
						System.out.println("Customers in city " + city);
						System.out.println("customer id: " + displayCity[i].id + "\nName: " + displayCity[i].name
								+ "\nmobileNumber: " + displayCity[i].mobileNo + "\ndate of birth: "
								+ displayCity[i].dob + "\nage: " + displayCity[i].age + "\naddress: "
								+ displayCity[i].address + "\nsource: " + displayCity[i].source + "\ndestination: "
								+ displayCity[i].destination + "\ntime: " + displayCity[i].time + "\ndate: "
								+ displayCity[i].date + "\n");
						flag = 1;

					} else
						flag = 0;
				}
			}
			if (flag != 1) {
				System.out.println("Invalid City");
			}
		} else {
			System.out.println("Customer list is empty");
		}

	}

	public static void idDisplay(BusReserve b[], BusReserve ticket[], int id) {

		int size1 = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] != null) {
				size1++;
			}
		}
		int size2 = 0;
		for (int i = 0; i < ticket.length; i++) {
			if (ticket[i] != null) {
				size2++;
			}
		}

		for (int i = 0; i < size1; i++) {
			for (int m = 0; m < size2; m++)
				if (b[i].id == ticket[m].id) {
					if (!b[i].equals(ticket[m]))
						b[i].source = ticket[m].source;
					b[i].destination = ticket[m].destination;
					b[i].date = ticket[m].date;
					b[i].time = ticket[m].time;
				}
		}

		BusReserve displayId[];
		displayId = new BusReserve[size1];
		int j = 0;
		for (int i = 0; i < size1; i++) {
			displayId[j] = b[i];
			j++;
		}
		int flag = 0;
		if (displayId.length > 0) {
			for (int i = 0; i < displayId.length; i++) {
				if (displayId[i].source == null) {
					if (displayId[i].id == id) {
						System.out.println("Customer with id " + id);
						System.out.println("customer id: " + displayId[i].id + "\nName: " + displayId[i].name
								+ "\nmobileNumber: " + displayId[i].mobileNo + "\ndate of birth: " + displayId[i].dob
								+ "\nage: " + displayId[i].age + "\naddress: " + displayId[i].address + "\n");
						flag = 1;
					}
				} else {
					if (displayId[i].id == id) {
						System.out.println("Customer with id " + id);
						System.out.println("customer id: " + displayId[i].id + "\nName: " + displayId[i].name
								+ "\nmobileNumber: " + displayId[i].mobileNo + "\ndate of birth: " + displayId[i].dob
								+ "\nage: " + displayId[i].age + "\naddress: " + displayId[i].address + "\nsource: "
								+ displayId[i].source + "\ndestination: " + displayId[i].destination + "\ntime: "
								+ displayId[i].time + "\ndate: " + displayId[i].date + "\n");
						flag = 1;

					}
				}
			}
			if (flag == 0) {
				System.out.println("Invalid Id");
			}

		} else {
			System.out.println("There are 0 customers");
		}
	}

	static void sortName(BusReserve b[]) {
		int size = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] != null) {
				size++;
			}
		}

		BusReserve display[];
		display = new BusReserve[size];
		int j = 0;
		for (int i = 0; i < size; i++) {
			display[j] = b[i];
			j++;
		}

		if (display.length > 0) {
			BusReserve tempname;
			for (int i = 0; i < size - 1; i++) {
				for (int k = 0; k < size - i - 1; k++) {
					if (display[k].name.compareTo(display[k + 1].name) > 0) {
						tempname = display[k];
						display[k] = display[k + 1];
						display[k + 1] = tempname;
					}
				}
			}

			for (int i = 0; i < size; i++) {

				System.out.println("customer id: " + display[i].id + "\nName: " + display[i].name + "\nmobile number: "
						+ display[i].mobileNo + "\ndate of birth: " + display[i].dob + "\nage: " + display[i].age
						+ "\n");
				System.out.println(" ");

			}
		} else {
			System.out.println("customers list is empty");
		}
	}
}

public class BusReservation {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		String phoneNo[] = new String[100];
		BusReserve b[] = new BusReserve[100];
		BusReserve ticket[] = new BusReserve[100];
		LocalDate currentDate = LocalDate.now();

		String mobileNo = null;
		int i = 0;
		int count = 0, count1 = 0;
		do {

			System.out.println("Enter 1 to add customer details:");
			System.out.println("Enter 2 to Book a ticket");
			System.out.println("Enter 3 to display customer details");
			System.out.println("Enter 4 to exit");
			System.out.println("Enter your choice: ");
			int choice = 1;
			while (!input.hasNextInt()) {
				System.out.println("Incorrect Choice! Please enter valid number:");
				input.next();
			}
			choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter customer id:");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect id! Please enter valid customer id:");
					input.next();
				}
				int id = input.nextInt();
				if (count > 0) {
					for (int j = 0; j < count; j++) {
						while (b[j].id == id) {
							System.out.println(
									"This customer id is already associated with customer.\nPlease enter a different id");
							while (!input.hasNextInt()) {
								System.out.println("Incorrect id! Please enter valid customer id:");
								input.next();
							}
							id = input.nextInt();
						}
					}
				}
				input.nextLine();

				System.out.println("Enter customer name: ");
				String name = input.nextLine();
				while (!name.matches("[a-zA-Z ]+")) {
					System.out.println("Invalid name! please re-enter again ");
					name = input.nextLine();
				}
				System.out.println("Enter customer mobile number:");
				// String mobileNo = input.next();
				String regex = ("(0/91)?[7-9][0-9]{9}");

				for (; i < phoneNo.length - 1;) {
					phoneNo[i] = input.next();
					while ((!phoneNo[i].matches(regex))) {
						System.out.println("invalid mobile number ! please Re-enter");
						phoneNo[i] = input.next();
					}
					mobileNo = phoneNo[i];
					// System.out.println("The phone number is:" + mobileNo);
					break;
				}

				System.out.println("Enter date of birth:");
				String dob = input.next();
				while (!dob.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$")) {
					System.out.println("Enter a valid date in dd-mm-yy fromat");
					dob = input.next();
				}
				System.out.println("Enter age:");
				while (!input.hasNextInt()) {
					System.out.println("Incorrect age! Please enter valid age:");
					input.next();
				}
				int age = input.nextInt();
				input.nextLine();

				System.out.println("Enter customer address:");
				String address = input.nextLine();
				while (!address.matches("[a-zA-Z ]+")) {
					System.out.println("Invalid name! please re-enter again ");
					address = input.nextLine();
				}

				b[count] = new BusReserve(id, name, mobileNo, dob, age, address);
				count++;
				break;

			case 2:
				if (count > 0) {
					System.out.print("Enter customer id:");
					input.nextLine();
					while (!input.hasNextInt()) {
						System.out.println("Incorrect id! Please enter valid customer id:");
						input.next();
					}
					int id1 = input.nextInt();
					for (int j = 0; j < count ;  j++) {
						if (b[j].id != id1 ) {
							System.out.println(
									"Customer ID is not associated with any customer. \nEnter a valid customer ID: ");
							while (!input.hasNextInt()) {
								System.out.println("Incorrect ID! Please enter valid customer ID:");
								input.next();
							}
							id1 = input.nextInt();
						}
					}
					input.nextLine();

					System.out.println("Enter customer mobile number:");
					// String mobileNo = input.next();
					regex = ("(0/91)?[7-9][0-9]{9}");

					for (; i < phoneNo.length - 1;) {
						phoneNo[i] = input.next();
						while ((!phoneNo[i].matches(regex))) {
							System.out.println("Invalid mobile number ! Please Re-enter");
							phoneNo[i] = input.next();
						}
						mobileNo = phoneNo[i];
						// System.out.println("The phone number is:" + mobileNo);
						break;
					}

					System.out.println("Enter the source:");
					String source = input.next();
					while (!source.matches("[a-zA-Z ]+")) {
						System.out.println("Invalid source! please re-enter again ");
						source = input.next();
					}
					System.out.println("Enter destination:");
					String destination = input.next();
					while (!destination.matches("[a-zA-Z ]+")) {
						System.out.println("Invalid destination! please re-enter again ");
						destination = input.nextLine();
					}
					if (destination.equalsIgnoreCase(source)) {
						System.out.println(
								"destination and source cannot be the same places\nplease re-enter a different destination:");
						destination = input.next();
						while (!destination.matches("[a-zA-Z ]+")) {
							System.out.println("Invalid destination! please re-enter again ");
							destination = input.nextLine();
						}
					}
					System.out.println("Enter date you want to travel: ");
					String date = input.next();
					while (!date.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$")) {
						System.out.println("Enter a valid date in dd-mm-yy fromat");
						date = input.next();

					}
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate travelDate = LocalDate.parse(date, format);
					LocalDate newDate = currentDate.plusDays(30);
					int flag = 0;
					while (flag != 2) {

						if (travelDate.equals(currentDate)) {
							System.out.println("Travel date cannot be same as current date\n!Please re-enter again:");
							System.out.println("Enter the date you want to travel:");
							date = input.next();
							while (!date.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$")) {
								System.out.println("Enter a valid date in dd-mm-yy fromat");
								date = input.next();

							}
							travelDate = LocalDate.parse(date, format);
							flag = 1;
						} else if (travelDate.isBefore(currentDate)) {
							System.out.println("Travel date cannot be less than current date!\nPlease re-enter again:");
							System.out.println("Enter the date you want to travel:");
							date = input.next();
							while (!date.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$")) {
								System.out.println("Enter a valid date in dd-mm-yy fromat");
								date = input.next();

							}
							flag = 1;
							travelDate = LocalDate.parse(date, format);
						} else if (travelDate.isBefore(newDate)) {
							flag = 2;
						} else {
							System.out.println(
									"travel Date cannot be more than a month from current date!\nPlease re-enter again");
							date = input.next();
							while (!date.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$")) {
								System.out.println("Enter a valid date in dd-mm-yy fromat");
								date = input.next();

							}
							flag = 1;
							travelDate = LocalDate.parse(date, format);
						}
					}

					System.out.println("Enter time:");
					while (!input.hasNextDouble()) {
						System.out.println("Invalid time! please re-enter again");
					}
					Double time = input.nextDouble();
					while (time > 23.60) {
						System.out.println("Time cannont be greater than 24hours!please re-enter again");
						while (!input.hasNextDouble()) {
							System.out.println("Invalid time! please re-enter again");
						}
						time = input.nextDouble();
					}

					ticket[count1] = new BusReserve(id1, mobileNo, source, destination, travelDate, time);
					count1++;
					System.out.println("TICKET CONFIRMED");
				} else {
					System.out.println("Create a Customer and continue");
				}
				break;

			case 3:
				if (count > 0) {
					System.out.println("**DISPLAY CUSTOMER DETAILS*");
					System.out.println("1.Display customer based on city names:");
					System.out.println("2.Display customer based on id:");
					System.out.println("3.Display customer names in sorted order");
					int choice2 = input.nextInt();
					switch (choice2) {
					case 1:
						System.out.println("*DISPLAYING DETAILS BASED ON CITY NAME*");
						System.out.println("Enter city name: ");
						String city = input.next();
						BusReserve.cityDisplay(b, ticket, city);

						break;

					case 2:
						System.out.println("*DISPLAYING DETAILS BASED ON ID**");
						System.out.println("Enter customer id of the user:");
						id = input.nextInt();
						input.nextLine();
						BusReserve.idDisplay(b, ticket, id);
						break;

					case 3:
						System.out.println("*DISPLAYING NAMES IN SORTED ORDER*");
						BusReserve.sortName(b);
						break;
					}
				} else {
					System.out.println("Create a customer and continue");
				}
				break;

			case 4:
				System.out.println("Exiting....");
				input.close();
				System.exit(0);

			default:
				System.out.println("Invalid entry");

			}

		} while (true);

	}
}
