package problem30;

import java.util.*;

class SavingsAccount {
	int interestRate, accountNo;
	double balance;

	SavingsAccount() {
		interestRate = 0;
		accountNo = -1;
		balance = 0.0;
	}

	SavingsAccount(double balance, int accountNo, int interestRate) {
		this.interestRate = interestRate;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	void withDraw(double amount) {
		if (amount > balance)
			System.out.println("Withdraw not possible!");
		else {
			balance = balance - amount;
			System.out.println("Successfully withdrawn : Rs" + amount);
			System.out.println("Remaining amount : Rs" + balance);
		}
	}

	void calculateInterest() {
		double interest = ((balance * 2 * interestRate) / 100);
		System.out.println("Interest Rate : Rs" + interest);

	}

}

public class BankAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many customer details you want to enter?");
		int totalNumber;
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		totalNumber = sc.nextInt();

		// Create array of objects
		SavingsAccount customer[] = new SavingsAccount[totalNumber];
		int custId, interestRate;
		double custBalance,withdraw;
		
		for (int i = 0; i < totalNumber; i++) {

			System.out.println("Enter your details : \n");
			System.out.println("Enter Customer account number : ");
			
			sc.nextLine();
			while (!sc.hasNextInt()) {
				System.out.println("Not a valid input! Try again");
				sc.nextLine();
			}
			custId = sc.nextInt();
			for (int j = 0; j < i; j++)
				if (custId == customer[j].accountNo) {
					System.out.println("Customer Id already exists. Enter a unique ID");
					while (!sc.hasNextInt()) {
						System.out.println("Not a valid input! Try again");
						sc.nextLine();
					}
					custId = sc.nextInt();
				}

			
			// Read account balance
			System.out.println("Enter account balance : ");
			while (!sc.hasNextDouble()) {
				System.out.println("Not a valid input! Try again");
				sc.next();
			}
			custBalance = sc.nextDouble();
			
			System.out.println("Interest : ");
			while(!sc.hasNextInt()) {
				System.out.println("Not a valid input! Try again");
				sc.next();
			}
			interestRate = sc.nextInt();
			
			System.out.println("Enter withdraw amount : ");
			while (!sc.hasNextDouble()) {
				System.out.println("Not a valid input! Try again");
				sc.next();
			}
			withdraw = sc.nextDouble();
			
			customer[i] = new SavingsAccount(custBalance, custId, interestRate);
			customer[i].calculateInterest();
			customer[i].withDraw(withdraw);
		}
		
		sc.close();
	}

}
