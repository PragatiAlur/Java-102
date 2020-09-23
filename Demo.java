package problem33;

import java.util.*;

class Student {
	int studentId;
	String studentName;
	double marks;
	boolean secondChance;

	Student(int studentId, String studentName, boolean secondChance) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.secondChance = secondChance;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public boolean isSecondChance() {
		return secondChance;
	}

	public void setSecondChance(boolean secondChance) {
		this.secondChance = secondChance;
	}

	void identifyMarks(double marks) {
		if (secondChance == false) {
			this.marks = marks;
		}
	}

	void identifyMarks(double marksFirst, double marksSecond) {
		marks = (marksFirst > marksSecond) ? marksFirst : marksSecond;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", marks=" + marks
				+ ", secondChance=" + secondChance + "]";
	}

	 static void displayDetails(Student[] student) {
		int totalNumber = student.length;
		System.out.println("Displaying Student details!");
		for (int i = 0; i < totalNumber; i++) {
			System.out.print("Student Id :"+student[i].studentId);
			System.out.print("\nStudent Name :"+student[i].studentName);
			System.out.print("\nStudent Marks :"+student[i].marks);
			
		}
	}
}

public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of student details you want to enter ?");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.nextLine();
		}
		int totalNumber = sc.nextInt();
		Student student[] = new Student[totalNumber];
		for (int i = 0; i < totalNumber; i++) {
			System.out.println("Enter details of Student " + (i + 1));
			System.out.println("Student id : ");
			while (!sc.hasNextInt()) {
				System.out.println("Not a valid input! Try again");
				sc.nextLine();
			}
			int id = sc.nextInt();
			boolean isValid = false;
			while (isValid == false) {
				isValid = true;
				for (int j = 0; j < i; j++) {
					if (id == student[j].studentId) {
						System.out.println("Student ID already exists. Try with different ID");
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
						System.out.println("Name should contain only alphabets! Try again");
						name = sc.nextLine();
						isValid = false;
						break;
					}
				}
			}

			System.out.println("Has the student taken second chance : (true or false)");
			while (!sc.hasNextBoolean()) {
				System.out.println("Not a valid input! Try again");
				sc.nextLine();
			}
			boolean ch = sc.nextBoolean();

			student[i] = new Student(id, name, ch);
			if (ch == false) {
				System.out.println("Enter marks : ");
				while (!sc.hasNextDouble()) {
					System.out.println("Not a valid input! Try again");
					sc.nextLine();
				}
				double marks = sc.nextDouble();
				student[i].identifyMarks(marks);
			} else {
				System.out.println("Enter marks of two exam : ");
				while (!sc.hasNextDouble()) {
					System.out.println("Not a valid input! Try again");
					sc.nextLine();
				}
				double m1 = sc.nextDouble();
				while (!sc.hasNextDouble()) {
					System.out.println("Not a valid input! Try again");
					sc.nextLine();
				}
				double m2 = sc.nextDouble();
				student[i].identifyMarks(m1, m2);

			}
		}
		Student.displayDetails(student);
		sc.close();
	}

}
