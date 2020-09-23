package problem35;

import java.util.*;


public class StudentHighestMarks {
	String name, branch;
	int studentId;
	float score;

	StudentHighestMarks(int studentId, String name, String branch, float score) {
		this.name = name;
		this.branch = branch;
		this.studentId = studentId;
		this.score = score;
	}

	static StudentHighestMarks marks(StudentHighestMarks students[], int totalNumber) {
		if(totalNumber == 0) {
			System.out.println("NO records found");
			return null;
		}
		if(totalNumber == 1)
			return students[0];
		StudentHighestMarks temp = null;
		float max = students[0].score;
		for (int i = 0; i < totalNumber; i++) {
			if (max < students[i].score) {
				temp = students[i];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentHighestMarks[] student = new StudentHighestMarks[100];
		int totalNumber = 0;
		do {
			System.out.println("------------------------------------------");
			System.out.println("1. Create new student records");
			System.out.println("2. Display highest marks");
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
							if ((branchName.charAt(j) >= 'A' && branchName.charAt(j) <= 'z')
									|| branchName.charAt(j) == ' ')
								continue;
							else {
								System.out.println("** Branch Name should contain only alphabets! Try again **");
								branchName = sc.nextLine();
								isValid = false;
								break;
							}
						}
					}
					System.out.println("Student Marks : ");
					while (!sc.hasNextFloat()) {
						System.out.println("** Not a valid input! Try again **");
						sc.nextLine();
					}
					float marks = sc.nextFloat();
					student[totalNumber] = new StudentHighestMarks(id, name, branchName, marks);
				
				totalNumber++;
				break;
			case 2:
				StudentHighestMarks result = StudentHighestMarks.marks(student, totalNumber);
				System.out.println("Student with highest marks details is as follows!! ");
				{
					System.out.println("Student ID : " + result.studentId);
					System.out.println("Student name : " + result.name);
					System.out.println("Student branch : " + result.branch);
					System.out.println("Student marks : " + result.score);
				}
				break;
			case 0:
				System.out.println("Exiting..BYEE!!");
				sc.close();
				System.exit(1);

			default:
				System.out.println("Invalid choice! ");
			}
		} while (true);

	}

}
