package problem48;

import java.util.*;

public class NumberGuessing {
	static Scanner sc = new Scanner(System.in);

	int randomNumberGeneration(int input) {

		input = input * 2 - 2;
		if (input < 0) {
			input = 0;
			input += 24;
		}
		if (input > 100) {
			input = 100;
			input -= 24;
		}
		return input;
	}

	void randomGuessingGame(int randomNumber) {

		int count = 0;
		System.out.println("  Guess a number between 0 and 100");
		while (true) {
			int guess = sc.nextInt();
			count++;
			if (guess == randomNumber) {

				System.out.println("  Congraulations!! You guessed it correct.");
				System.out.println(" You guessed correct number in " + count + " chances");
				System.out.println("Random number is " + randomNumber);
				break;
			} else if (guess > randomNumber) {
				System.out.println("  Your guess is too high. Try again");
			} else
				System.out.println("  Your guess is too small. Try again");
		}
	}

	public static void main(String[] args) {
		NumberGuessing numberObject = new NumberGuessing();

		System.out.println("**Welcome to RANDOM NUMBER GUESSING game!!**");
		System.out.println("  Random number is generated ");
		System.out.println(" Enter a number to generate random number");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		int input = sc.nextInt();

		int randomNumber = numberObject.randomNumberGeneration(input);
		numberObject.randomGuessingGame(randomNumber);

		sc.close();

	}
}
