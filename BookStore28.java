package problem28;

import java.util.Scanner;


class BookStore {
	String bookName, authorName;
	double price;
	int year;

	BookStore() {
	} 

	public BookStore(String bookName, String authorName, double price, int year) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.year = year;
	}
	
	public String getBookName() {
		return bookName;
	}

	public boolean setBookName(String bookName) {
		
		
//		for(int i = 0; i < bookName.length(); i++) {
//			if(!(bookName.charAt(i)>='A' && bookName.charAt(i) <='z' || bookName.charAt(i))) {
//				System.out.println("Enter correct Book name !");
//				return false;
//			}
//		}
		this.bookName = bookName;
		return true;
	}

	public String getAuthorName() {
		return authorName;
	}

	public boolean setAuthorName(String authorName) {
		for(int i = 0; i < authorName.length(); i++) {
			if(!(authorName.charAt(i)>='A' && authorName.charAt(i) <='z' || authorName.charAt(i) == 32)) {
				System.out.println("Enter correct author name !");
				return false;
			}
		}
		this.authorName = authorName;
		return true;
	}

	public double getPrice() {
		return price;
	}

	public boolean setPrice(double price) {
		this.price = price;
		return true;
	}

	public int getYear() {
		return year;
	}

	public boolean setYear(int year) {
		if(year >= 1700 && year <= 2020) {
			this.year = year;
			return true;
		}
		System.out.println("Enter correct year!");
		return false;
	}

	void display() {
		System.out.println("-----------------------------------------------");
		System.out.println("Book details ");
		System.out.println("Book Name : " + bookName);
		System.out.println("Author Name : " + authorName);
		System.out.println("Year of Publication : " + year);
		System.out.println("Price : $" + String.format("%.2f", price));
		System.out.println("-----------------------------------------------");
	}

}

public class BookStore28 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		BookStore b1 = new BookStore("Daniel Defoe", "Robinson Crusoe", 15.50, 1719);
//		BookStore b2 = new BookStore("Joseph Conrad", "Heart of Darkness", 12.80, 1902);
//		BookStore b3 = new BookStore("Pat Conroy", "Beach Music", 9.50, 1996);
//		b1.display();
//		b2.display();
//		b3.display();
		System.out.println("How many books details you want to enter?");
		int totalNumber;
		while(!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		totalNumber = sc.nextInt();
		BookStore[] book = new BookStore[totalNumber];

		System.out.println("-----------------------------------------");
		System.out.println("Enter book details..");
		
		for (int i = 0; i < totalNumber; i++) {
			boolean isValidDetail = false;
			book[i] = new BookStore();
			sc.nextLine();
			while (isValidDetail == false) {
				System.out.print("Author Name :");
				String name = sc.nextLine();
				isValidDetail = book[i].setAuthorName(name);

			}

			isValidDetail = false;
			
			while (isValidDetail == false) {
				
				System.out.print("Book title :");
				String bookName = sc.nextLine();
				isValidDetail = book[i].setBookName(bookName);
			}
			
			isValidDetail = false;
			
			while (isValidDetail == false) {
				
				System.out.print("Year of publication :");
				while(!sc.hasNextInt()) {
					System.out.println("Not a valid input! Try again");
					sc.next();
				}
				int year = sc.nextInt();
				isValidDetail = book[i].setYear(year);

			}
		
			isValidDetail = false;

			while (isValidDetail == false) {

				System.out.print("Book price :");
				while(!sc.hasNextDouble()) {
					System.out.println("Not a valid input! Try again");
					sc.next();
				}
				double price = sc.nextDouble();
				isValidDetail = book[i].setPrice(price);

			}
		}
		sc.close();
		for (int i = 0; i < totalNumber; i++) {
			System.out.println("-----------------------------------------");
			System.out.println("\nEntered details : ");
			System.out.println("Book name : " + book[i].getBookName());
			System.out.println("Author Name : " + book[i].getAuthorName());
			System.out.println("Year of publicaation : " + book[i].getYear());
			System.out.println("Price : " + book[i].getPrice());
			System.out.println("-----------------------------------------");
		}
		
	}
}
