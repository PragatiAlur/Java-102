package problem27;

import java.util.*;

public class Employee {
	int empID;
	String empName, empDesig, empDept;

	public Employee() {
		this.empID = 0;
		this.empName = null;
		this.empDesig = null;
		this.empDept = null;
	}

	public Employee(int empID, String empName, String empDesig, String empDept) {
		this.empID = empID;
		this.empName = empName;
		this.empDesig = empDesig;
		this.empDept = empDept;
	}

	public int getEmpID() {
		return empID;
	}

	public boolean setEmpID(int empID) {
		if (empID <= 0 || empID >= 100000) {
			System.out.println("\nEmployee ID should be in the range of 1 to 100000\n");
			return false;
		}

		this.empID = empID;
		return true;
	}

	public String getEmpName() {
		return empName;
	}

	public boolean setEmpName(String empName) {

		if (empName.length() == 0) {
			System.out.println("\nName cannot be null. Please enter a proper name.\n");
			return false;
		}

		for (int i = 0; i < empName.length(); i++) {

			if (empName.charAt(i) >= 'A' && empName.charAt(i) <= 'z' || empName.charAt(i) == ' ')
				continue;

			else {
				System.out.println("\nName should contain only alphabets! Please enter a proper name.\n");
				return false;
			}
		}

		this.empName = empName;

		return true;
	}

	public String getEmpDesig() {
		return empDesig;
	}

	public boolean setEmpDesig(String empDesig) {

		if (empDesig.equalsIgnoreCase("developer") || empDesig.equalsIgnoreCase("tester")
				|| empDesig.equalsIgnoreCase("lead") || empDesig.equalsIgnoreCase("manager")) {
			this.empDesig = empDesig;
			return true;
		}
		System.out.println("\nDesignation you entered doesn't exist.");
		System.out.println("Designation should be one among [Developer, Tester, Lead, Manager]\n");
		return false;
	}

	public String getEmpDept() {
		return empDept;
	}

	public boolean setEmpDept(String empDept) {

		if (empDept.equalsIgnoreCase("TTH") || empDept.equalsIgnoreCase("DevOps") || empDept.equalsIgnoreCase("RCM")
				|| empDept.equalsIgnoreCase("digital")) {

			this.empDept = empDept;

			return true;
		}
		System.out.println("\nDepartment you entered doesn't exist.");
		System.out.println("Department should be one among [TTH, DevOps, RCM or Digital]\n");
		return false;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many emoployees details you want to enter?");
		int totalEmployeeNumber = sc.nextInt();
		Employee[] e = new Employee[totalEmployeeNumber];

		System.out.println("-----------------------------------------");
		System.out.println("Enter details of employee..");
		
		for (int i = 0; i < totalEmployeeNumber; i++) {
			boolean isValidDetail = false;
			while (isValidDetail == false) {
				e[i] = new Employee();
				System.out.print("Employee ID :");
				int empid = sc.nextInt();
				isValidDetail = e[i].setEmpID(empid);

			}

			isValidDetail = false;
			sc.nextLine();

			while (isValidDetail == false) {
				System.out.print("Employee Name :");
				String name = sc.nextLine();
				isValidDetail = e[i].setEmpName(name);

			}

			isValidDetail = false;

			while (isValidDetail == false) {

				System.out.print("Employee Designation :");
				String desig = sc.next();
				isValidDetail = e[i].setEmpDesig(desig);

			}

			isValidDetail = false;

			while (isValidDetail == false) {

				System.out.print("Employee Department :");
				String dept = sc.next();
				isValidDetail = e[i].setEmpDept(dept);

			}
		}
		for (int i = 0; i < totalEmployeeNumber; i++) {
			System.out.println("-----------------------------------------");
			System.out.println("\nEntered details : ");
			System.out.println("Employee ID : " + e[i].getEmpID());
			System.out.println("Employee Name : " + e[i].getEmpName());
			System.out.println("Employee Designaton : " + e[i].getEmpDesig());
			System.out.println("Employee Department : " + e[i].getEmpDept());
			System.out.println("-----------------------------------------");
		}
		sc.close();

	}

}
