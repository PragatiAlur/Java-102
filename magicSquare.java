package problem40;
import java.util.*;

public class magicSquare {
	static int n;
	public boolean isMagic(int arr[][])
	{
		int n = arr.length;
		int sumrow=0,sumdia=0,sum=0;
		//diagonal sum
		for(int i=0; i<n; i++)
			sum = sum + arr[i][i];
		for(int i=0; i<n; i++)
			sumdia = sumdia + arr[i][n-1-i];
		if(sumdia != sum)
			return false;
		//column sum
		for(int i=0; i<n; i++)
		{
				int colSum = 0; 
	            for (int j = 0; j < n; j++) 
	                colSum += arr[j][i]; 
	            if (sum != colSum) 
	                return false; 
		}
		
		//row sum
		for(int i=0; i<n; i++) {
			sumrow=0;
			for(int j=0; j<n; j++)
			{
				sumrow=sumrow+arr[i][j];
			}
			if(sumrow!=sum)
			{
				return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter number of columns : ");
			while (!sc.hasNextInt()) {
				System.out.println("Not a valid input! Try again");
				sc.next();
			}
			int size = sc.nextInt();
			int[][] arr = new int[size][size];
			System.out.println("Enter elements");
			for(int i=0; i<size; i++)
				for(int j=0; j<size; j++) {
					while (!sc.hasNextInt()) {
						System.out.println("Not a valid input! Try again");
						sc.next();
					}
					arr[i][j] = sc.nextInt();
				}
			sc.close();
			magicSquare magic = new magicSquare();
			System.out.println("Array is magic square : "+magic.isMagic(arr));
		}
	}

}
