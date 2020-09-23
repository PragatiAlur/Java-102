package problem47;

import java.util.Scanner;

class Customers {
	int accNo;
	String name;
	String acType;
	String dob;
	double balance;
	String address;
	static int objectCount = 0;

	public Customers() {
		this.accNo = 0;
		this.name = " ";
		this.acType = " ";
		this.dob = " ";
		this.balance = 0.0;
		this.address = " ";
	}

	public Customers(int acNo, String name, String acType, String dob, double balance, String address) {

		this.accNo = acNo;
		this.name = name;
		this.acType = acType;
		this.dob = dob;
		this.balance = balance;
		this.address = address;
		objectCount++;

	}

	static void updateName(Customers c[], int ac, String nameUpdate) {
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null && ac == c[i].accNo) {
				c[i].name = nameUpdate;
				System.out.println("Name updated\n");
			}
		}
	}

	static void updateAddress(Customers c[], int ac, String addressUpdate) {
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null && ac == c[i].accNo) {
				c[i].address = addressUpdate;
				System.out.println("Address updated\n");
			}
		}
	}

	static void deleteDetails(Customers c[], int ac) {
		int flag = 1;
		for (int i = 0; i < c.length; i++) {
			if (c[i] != null && c[i].accNo == ac) {
				c[i] = null;
				flag = 0;
				break;
			} else
				flag = 1;
		}
		if (flag == 0) {
			System.out.println("Deletion Succesfull\n");

		} else
			System.out.println("Invalid accNo\n");
	}

	public static void idDisplay(Customers c[], int id) {
		int size = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {

				size++;
			}
		}

		Customers displayId[];
		displayId = new Customers[size];
		int j = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {
				displayId[j] = c[i];
				j++;
			}
		}
		int flag = 0;
		if (displayId.length > 0) {
			for (int i = 0; i < displayId.length; i++) {
				if (displayId[i].accNo == id) {
					System.out.println("Customer with acNo " + id);
					System.out.println("acNo: " + displayId[i].accNo + "\nName: " + displayId[i].name + "\nacType: "
							+ displayId[i].acType + "\ndate of birth: " + displayId[i].dob + "\nbalance: "
							+ displayId[i].balance + "\naddress: " + displayId[i].address + "\n");
					flag = 1;
				} else
					flag = 0;
			}
			if (flag == 0) {
				System.out.println("Invalid Id");
			}
		} else {
			System.out.println("There are 0 customers");
		}
	}

	static void nameDisplay(Customers c[], String name) {
		int size = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {

				size++;
			}
		}

		Customers displayName[];
		displayName = new Customers[size];
		int j = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {
				displayName[j] = c[i];
				j++;
			}
		}
		int flag = 0;
		if (displayName.length > 0) {
			for (int i = 0; i < displayName.length; i++) {
				if (displayName[i].name.equalsIgnoreCase(name)) {
					System.out.println("Customer with Name " + name);
					System.out.println("acNo: " + displayName[i].accNo + "\nName: " + displayName[i].name + "\nacType: "
							+ displayName[i].acType + "\ndate of birth: " + displayName[i].dob + "\nbalance: "
							+ displayName[i].balance + "\naddress: " + displayName[i].address + "\n");
					flag = 1;
				} 
			}
			if (flag == 0) {
				System.out.println("Invalid Name");
			}
		} else {
			System.out.println("Customer list is empty");
		}
	}

	static void nonZeroBalance(Customers c[]) {
		int size = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {

				size++;
			}
		}

		Customers display[];
		display = new Customers[size];
		int j = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {
				display[j] = c[i];
				j++;
			}
		}
		if (display.length > 0) {
			for (int i = 0; i < display.length; i++) {
				if (display[i].balance > 0) {

					System.out.println("acNo: " + display[i].accNo + "\nName: " + display[i].name + "\nacType: "
							+ display[i].acType + "\ndate of birth: " + display[i].dob + "\nbalance: "
							+ display[i].balance + "\naddress: " + display[i].address + "\n");
					System.out.println(" ");
				} else {
					System.out.println("There are 0 customers with non zero balance");
				}
			}
		} else {
			System.out.println("Customer list is empty");
		}
	}

	static void sortAddress(Customers c[]) {
		int size = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {

				size++;
			}
		}

		Customers display[];
		display = new Customers[size];
		int j = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {
				display[j] = c[i];
				j++;
			}
		}
		if (display.length > 0) {
			Customers tempAddress;
			for (int i = 0; i < size - 1; i++) {
				for (int k = 0; k < size - i - 1; k++) {
					if (display[k].address.compareTo(display[k + 1].address) > 0) {
						tempAddress = display[k];
						display[k] = display[k + 1];
						display[k + 1] = tempAddress;
					}
				}
			}
			for (int i = 0; i < size; i++) {
				System.out.println("acNo: " + display[i].accNo + "\nName: " + display[i].name + "\nacType: "
						+ display[i].acType + "\ndate of birth: " + display[i].dob + "\nbalance: " + display[i].balance
						+ "\naddress: " + display[i].address + "\n");
				System.out.println(" ");

			}
		} else {
			System.out.println("customers list is empty");
		}
	}

	static void sortId(Customers c[]) {
		int size = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {

				size++;
			}
		}

		Customers display[];
		display = new Customers[size];
		int j = 0;
		for (int i = 0; i < objectCount; i++) {
			if (c[i] != null) {
				display[j] = c[i];
				j++;
			}
		}
		if (size > 0) {
			Customers tempId;
			for (int i = 0; i < size - 1; i++) {
				for (int k = 0; k < size - i - 1; k++) {
					if (display[k].accNo > display[k + 1].accNo) {
						tempId = display[k];
						display[k] = display[k + 1];
						display[k + 1] = tempId;
					}
				}
			}
			for (int i = 0; i < size; i++) {
				System.out.println("acNo: " + display[i].accNo + "\nName: " + display[i].name + "\nacType: "
						+ display[i].acType + "\ndate of birth: " + display[i].dob + "\nbalance: " + display[i].balance
						+ "\naddress: " + display[i].address);
				System.out.println(" ");

			}
		} else {
			System.out.println("There are 0 customers to display");
		}
	}
}

public class BankManagementSystem {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		Customers c[];
		c = new Customers[5];

		String name, acType, dob, address;
		int acNo;
		double balance;

		int choice = 1;
		int numCust = 0;

		do {
			System.out.println("");
			System.out.println("------------------------");
			System.out.println("Enter 1 to create bank user");
			System.out.println("Enter 2 to update user details");
			System.out.println("Enter 3 to delete user details");
			System.out.println("Enter 4 to display user details");
			System.out.println("Enter 5 to exit");
			System.out.println("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Enter Account Number:");
				while (!input.hasNextInt()) {
					System.out.println("Enter a valid account number");
					input.next();
				}
				
				acNo = input.nextInt();
				if (numCust > 0) {
					for (int i = 0; i < numCust; i++) {
						System.out.println("numCust "+numCust + "c[i].accNo"+c[i].accNo);
						if (c[i].accNo == acNo) {
							System.out
									.println("This account number already exists\n Enter different account number");
							while (!input.hasNextInt()) {
								System.out.println("Enter a valid account number:");
								input.next();
								acNo = input.nextInt();
							}
							
							break;
						}
					}
				}
				input.nextLine();
				System.out.println("Enter customer name:");
				name = input.nextLine();
				while (!name.matches("^[a-zA-Z ]+$")) {
					System.out.println("Enter a valid name");
					name = input.nextLine();
				}
				System.out.println("Enter account type(savings/loan/current):");
				acType = input.next();
				while (!acType.contains("savings") && !acType.contains("loan") && !acType.contains("current")) {
					System.out.println("Enter a valid account type");
					acType = input.next();
				}
				System.out.println("Enter date of birth(dd-mm-yy):");
				dob = input.next();
				while (!dob.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$")) {
					System.out.println("Enter a valid datein dd-mm-yy fromat");
					dob = input.next();
				}
				System.out.println("Enter balance:");
				while (!input.hasNextDouble()) {
					System.out.println("Enter a valid balance");
					input.next();
				}
				balance = input.nextDouble();
				input.nextLine();
				System.out.println("Enter customer address:");
				address = input.nextLine();
				while (!address.matches("^[a-zA-Z ]+$")) {
					System.out.println("Enter a valid valid address");
					address = input.nextLine();
				}

				c[numCust] = new Customers(acNo, name, acType, dob, balance, address);
				System.out.println("User details accepted");
				numCust++;
				break;

			case 2:
				if (numCust > 0) {
					{
						System.out.println("Enter 1 to update name");
						System.out.println("Enter 2 to update address");
						System.out.println("Enter your choice: ");
						int choice1 = input.nextInt();
						int ac;
						switch (choice1) {
						case 1:
							System.out.println("Enter ac no:");
							ac = input.nextInt();
							input.nextLine();
							System.out.println("Enter name to be updated:");
							String nameUpdate = input.nextLine();

							Customers.updateName(c, ac, nameUpdate);
							break;

						case 2:
							System.out.println("Enter ac no:");
							ac = input.nextInt();
							input.nextLine();
							System.out.println("Enter address to be updated:");
							String addressUpdate = input.nextLine();

							Customers.updateAddress(c, ac, addressUpdate);
							break;

						default:
							System.out.println("invalid entry\n");
						}
					}
				} else {
					System.out.println("There are 0 bank users.\nCreate a bank user and continue...");
					System.out.println("");
				}
				break;

			case 3:
				if (numCust > 0) {
					System.out.println("Enter acNo of the customer to delete details:");
					int ac = input.nextInt();

					Customers.deleteDetails(c, ac);
				} else {
					System.out.println("There are 0 bank users.\nCreate a bank user and continue...");
					System.out.println("");
				}
				break;

			case 4:
				if (numCust > 0) {
					{

						System.out.println("Enter 1 to display user details based on id");
						System.out.println("Enter 2 to display user details based on name");
						System.out.println("Enter 3 to display all users with non zero balance");
						System.out.println("Enter 4 to display user sorted based on address");
						System.out.println("Enter 5 to display user sorted based on id");
						System.out.println("Enter your choice:");
						int choice2 = input.nextInt();
						input.nextLine();
						switch (choice2) {

						case 1:
							System.out.println("Enter Ac No of the user details to be displayed:");
							int id = input.nextInt();
							input.nextLine();
							Customers.idDisplay(c, id);
							break;

						case 2:
							System.out.println("Enter Name of the user details to be displayed:");
							String nameUpdate = input.nextLine();
							Customers.nameDisplay(c, nameUpdate);
							break;
						case 3:
							System.out.println("Displaying User with non zero balance");
							Customers.nonZeroBalance(c);
							break;

						case 4:
							System.out.println("Displaying User details Sorted based on Address");
							Customers.sortAddress(c);
							break;
						case 5:
							System.out.println("Displaying User details Sorted based on Id");
							Customers.sortId(c);
							break;
						default:
							System.out.println("Invalid Entry");

						}

					}
				} else {
					System.out.println("There are 0 bank users.\nCreate a bank user and continue...");
					System.out.println("");
				}
				break;

			case 5:
				System.out.println("Exiting....");
				input.close();
				System.exit(0);

			default:
				System.out.println("Invalid entry");

			}
		} while (true);

	}
}