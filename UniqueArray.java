package problem36;
import java.util.*;

public class UniqueArray {
	static int[] uniqueElements(int array1[], int array2[]) {
		int size1 = array1.length;
		int size2 = array2.length;
		int array3[] = new int[size1 + size2];
		int result = 0;
		for (int i = 0; i < size1; i++) {
			int count = 0;
			for (int j = 0; j < size2; j++) {
				if (array1[i] != array2[j]) {
					count++;
				}
			}
			if (count == size2) {
				array3[result] = array1[i];
				result++;
			}
		}
		int array4[] = new int[size2];

		for (int j = 0; j < size2; j++) { 
			int count1 = 0;
			for (int i = 0; i < size1; i++) {
				if (array2[j] != array1[i]) {
					count1++;
				}
			}
			if (count1 == size1) {
				array3[result] = array2[j];
				result++;
			}
		}
		return array3;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = sc.nextInt();
		int arr1[] = new int[size];
		int arr2[] = new int[size];
		System.out.println("Enter elements of array1:");
		for (int i = 0; i < size; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("Enter elements of array2:");
		for (int i = 0; i < size; i++) {
			arr2[i] = sc.nextInt();
		}
		int arr[] = uniqueElements(arr1, arr2);
		System.out.println("The final array of unique elements is:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				System.out.print(arr[i] + " ");
		}
		sc.close();
	}
}