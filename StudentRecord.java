package problem34;

import java.util.Scanner;

public class StudentRecord {
	String name;
	String branch;
	int studentId;

	public StudentRecord(int studentId, String name, String branch) {
		this.name = name;
		this.branch = branch;
		this.studentId = studentId;
	}

	static void sortById(StudentRecord object[], int totalNumber ) {
		for (int i = 0; i < totalNumber - 1; i++) {
			for (int j = 0; j < totalNumber - i - 1; j++) {
				if (object[j].studentId > object[j + 1].studentId) {
					StudentRecord temp = object[j];
					object[j] = object[j + 1];
					object[j + 1] = temp;
				}
			}
		}
		displayDetails(object, totalNumber);
	}
	static void sortByBranch(StudentRecord object[], int totalNumber) {
		
		for (int i = 0; i < totalNumber - 1; i++) {
			for (int j = 0; j < totalNumber - i - 1; j++) {
				if (object[j].branch.equalsIgnoreCase(object[j + 1].branch) ) {
					StudentRecord temp = object[j];
					object[j] = object[j + 1];
					object[j + 1] = temp;
				}
			}
		}
		displayDetails(object, totalNumber);
	}
	
	static void displayDetails(StudentRecord object[], int totalNumber) {
		System.out.println("------------------------------------------");
		if (totalNumber == 0)
			System.out.println("No student details to display! ");
		for (int i = 0; i < totalNumber; i++) {
			System.out.println("Student Id : " + object[i].studentId);
			System.out.println("Student Name : " + object[i].name);
			System.out.println("Student Branch : " + object[i].branch);
		}
		System.out.println("------------------------------------------");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalNumber = 0;
		StudentRecord[] student = new StudentRecord[100];
		do {
			System.out.println("------------------------------------------");
			System.out.println("1. Create new student records");
			System.out.println("2. Display all the records");
			System.out.println("3. Display student name sorted based on branch");
			System.out.println("4. Display student id in ascending order");
			System.out.println("Enter 0 to exit");
			System.out.println("------------------------------------------");
			System.out.println("Enter your choice: ");
			while (!sc.hasNextInt()) {
				System.out.println("**Not a valid input! Try again**");
				sc.nextLine();
			}
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
					System.out.println("------------------------------------------");
					System.out.println("Enter details of Student " + (totalNumber + 1));
					System.out.println("------------------------------------------");
					System.out.println("Student id : ");
					while (!sc.hasNextInt()) {
						System.out.println("** Not a valid input! Try again **");
						sc.nextLine();
					}
					int id = sc.nextInt();
					boolean isValid = false;
					while (isValid == false) {
						isValid = true;
						for (int j = 0; j < totalNumber; j++) {
							if (id == student[j].studentId) {
								System.out.println("** Student ID already exists. Try with different ID **");
								id = sc.nextInt();
								isValid = false;
								break;
							} else {
								continue;
							}
						}
					}
					System.out.print("Student Name : ");
					sc.nextLine();
					String name = sc.nextLine();
					isValid = false;
					while (isValid == false) {
						isValid = true;
						for (int j = 0; j < name.length(); j++) {
							if ((name.charAt(j) >= 'A' && name.charAt(j) <= 'z') || name.charAt(j) == ' ')
								continue;
							else {
								System.out.println("** Name should contain only alphabets! Try again **");
								name = sc.nextLine();
								isValid = false;
								break;
							}
						}
					}
					System.out.print("Branch Name : ");
					String branchName = sc.nextLine();
					isValid = false;
					while (isValid == false) {
						isValid = true;
						for (int j = 0; j < branchName.length(); j++) {
							if ((branchName.charAt(j) >= 'A' && branchName.charAt(j) <= 'z') || branchName.charAt(j) == ' ')
								continue;
							else {
								System.out.println("** Branch Name should contain only alphabets! Try again **");
								branchName = sc.nextLine();
								isValid = false;
								break;
							}
						}
					}
					student[totalNumber] = new StudentRecord(id, name, branchName);
				totalNumber++;
				break;
			case 2:
				StudentRecord.displayDetails(student, totalNumber);
				break;
			case 3: 
				StudentRecord.sortByBranch(student, totalNumber);
				break;
			case 4:
				StudentRecord.sortById(student, totalNumber);
				break;
			case 0:
				System.out.println("------------------------------------------");
				System.out.println("Exiting..Byee!!");
				System.out.println("------------------------------------------");
				sc.close();
				System.exit(1);
			default:
				System.out.println("** Invalid choice! **");
				break;

			}
		} while (true);
		
	}
}
