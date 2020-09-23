package problem51;

import java.util.*;

class findDistinctDuplicate {
	void findDuplicate(int[] arr) {
		int size = arr.length;
		int[] newarr = new int[size];
		int count = 0, flag = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {

				if (arr[i] == arr[j]) {
					for (int k = 0; k < count; k++) {
						if (arr[i] == newarr[k])
							flag = 1;
					}
					if (flag == 0) {
						newarr[count] = arr[i];
						count++;
						break;
					}
				}
			}
		}
		if (count == 0) {
			System.out.println("{-1}");
		} else {
			System.out.println("{");
			for (int i = 0; i < count; i++)
				System.out.println(newarr[i]);
			System.out.println("}");
		}
	}
}

public class DistinctDuplicate {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(" Please enter the size of array");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println(" Enter elements of array");
		for (int i = 0; i < size; i++) {
			while (!sc.hasNextInt()) {
				System.out.println("Not a valid input! Try again");
				sc.next();
			}
			arr[i] = sc.nextInt();
		}
		findDistinctDuplicate object = new findDistinctDuplicate();
		object.findDuplicate(arr);
		sc.close();
	}
}
