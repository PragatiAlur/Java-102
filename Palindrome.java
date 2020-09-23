package problem50;

import java.util.*;

public class Palindrome {

	static void palindromeNumber(int num) {
		int n = 0;
		int number = num;
		while (num != 0) {
			n = n * 10;
			n = num % 10 + n;
			num = num / 10;
		}
		// System.out.println(n);
		if (n == number) {
			System.out.println(number + " is a Palindrome!");
		} else {
			System.out.println(number + " not a palindrome");
		}
	}

	static void palindromeString(String value) {
		String string = value, reverse;
		int len = value.length();

		reverse = "";
		for (int i = len - 1; i >= 0; i--)
			reverse = reverse + value.charAt(i);

		if (string.equalsIgnoreCase(reverse)) {
			System.out.println(string + "is a palindrome.");
		} else {
			System.out.println(string + " is not a palindrome.");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("1.Check if number is palindrome.");
		System.out.println("2.Check if String is palindrome.");
		System.out.println("3.Exit \n Enter your choice");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter number");
			while (!sc.hasNextInt()) {
				System.out.println("Not a valid input! Try again");
				sc.next();
			}
			int num = sc.nextInt();
			palindromeNumber(num);
			break;

		case 2:

			int flag = 0;
			while (flag == 0) {
				flag = 1;
				System.out.println("Enter string");
				String str = sc.next();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z')
						continue;
					else {
						flag = 0;
						break;
					}

				}
				if (flag == 1)
					palindromeString(str);
			}
			break;

		case 3:
			System.out.println("Okay! Byeeee");
			sc.close();
			System.exit(1);

		}
		}while(true);
		
	}

}
