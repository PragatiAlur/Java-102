package problem49;
import java.util.*;

public class SubsetSum {
	
		void findsubset(int num, int size, int x[]) {
			
			for (int i = 1; i <= size; i++)
				x[i] = 0;
			for (int i = size; num != 0; i--) {
				x[i] = num % 2;
				num = num / 2;
			}
		}

		public static void main(String[] args) {

			int array[] = new int[10];
			int x[] = new int[10];
			int present = 0;

			System.out.print("Enter the number of elements of set: ");
			Scanner input = new Scanner(System.in);
			int size = input.nextInt();

			System.out.print("Enter the elements of set: ");
			for (int i = 1; i <= size; i++) {
				array[i] = input.nextInt();
			}

			System.out.print("Enter the positive integer sum: ");
			int number = input.nextInt();
			if (number > 0) {
				for (int i = 1; i <= Math.pow(2, size) - 1; i++) {
					SubsetSum subset = new SubsetSum();
					subset.findsubset(i, size, x);
					int sum = 0;
					for (int j = 1; j <= size; j++) {
						if (x[j] == 1) {
							sum = sum + array[j];
						}
					}

					if (number == sum) {
						System.out.print("Subset elements: ");
						present = 1;
						for (int j = 1; j <= size; j++) {
							if (x[j] == 1) {
								System.out.print(array[j] + " ");
							}
						}
						System.out.println();

					}

				}

			}
			
			if (present == 0) {
				System.out.println("Solution does not exists!");
			}
			input.close();
		}

	}

