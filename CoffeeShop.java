package problem31;

import java.util.*;

class Customer {
	String name;
	String mobileNo;
	double feedbackRating;

	Customer() {
	}

	Customer(String name, String mobileNo, double feedbackRating) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.feedbackRating = feedbackRating;
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {

		for (int i = 0; i < name.length(); i++)
			if (name.charAt(i) >= 'A' && name.charAt(i) <= 'z')
				continue;
			else {
				System.out.println("Name should contain only alphabets! Please enter again");
				return false;
			}

		this.name = name;
		return true;

	}

	public String getMobileNo() {
		return mobileNo;
	}

	public boolean setMobileNo(String mobileNo) {
		int flag = 1;
		if (mobileNo.length() == 10) {
			 
			for (int i = 1; i < 10; i++) {
				if (mobileNo.charAt(i) >= '0' && mobileNo.charAt(i) <= '9')
					continue;
				else {
					flag = 0;
					break;
				}
			}
			
			
			if (flag == 1) {
				this.mobileNo = mobileNo;
				return true;
			} else {
				System.out.println("Invalid mobile number. Try again");
				return false;
			}
		} else {
			System.out.println("Invalid mobile number. Try again");
			return false;
		}
	}

	public double getFeedbackRating() {
		return feedbackRating;
	}

	public boolean setFeedbackRating(double feedbackRating) {
		if(feedbackRating >= 0.0 && feedbackRating <= 5.0) {
			this.feedbackRating = feedbackRating;
			return true;
		}
		System.out.println("feedback not in given range! Try again");
		return false;
	}

}

public class CoffeeShop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer[] custObject = new Customer[10];
		System.out.println("Enter the number of customer details you want to add..");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {

			custObject[i] = new Customer();
			
			System.out.println("Enter customer name..");
			sc.nextLine();
			while (custObject[i].setName(sc.nextLine()) == false) {
				custObject[i].setName(sc.nextLine());
			}
			
			System.out.println("Enter customer mobile number..");
			while (custObject[i].setMobileNo(sc.nextLine()) == false) {
				custObject[i].setMobileNo(sc.nextLine());
			}
			
			System.out.println("Enter feedback of customer..");
			while(!sc.hasNextDouble()) {
				System.out.println("Invalid feedback. Try again");
				sc.next();
			}
			while(custObject[i].setFeedbackRating(sc.nextDouble())==false){
				custObject[i].setFeedbackRating(sc.nextDouble());
			}
		}
		for (int i = 0; i < n; i++)
			System.out.println("Feedback of customer " + (i + 1) + " is " + custObject[i].feedbackRating);
		sc.close();
	}

}
