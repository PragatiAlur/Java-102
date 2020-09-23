package problem39;
import java.util.*;

public class RowMagic {
	 static int m;
	 static int n;
	boolean isRowMagic(int[][] arr,int m, int n)
	{
		int sum = 0;
		int sum1 = 0;
		for(int i=0; i<1; i++)
			for(int j=0;j<n; j++)
				sum1=sum1+arr[i][j];
		System.out.println("Sum[0] : "+sum1);
		for(int i=0; i<m; i++) {
			sum=0;
			for(int j=0; j<n; j++)
			{
				sum=sum+arr[i][j];
			}
			System.out.println("sum["+i+"]"+sum);
			if(sum1!=sum)
			{
				return false;
			}
			
		}
		return true;
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr1 = new int[10][10];
		RowMagic rm = new RowMagic();
				
		System.out.println("Enter number of rows in array 1 : ");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		 m = sc.nextInt();
		System.out.println("Enter number of columns in array 2 : ");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		 n = sc.nextInt();
		System.out.println("Enter elements for array 1");
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) {
				while (!sc.hasNextInt()) {
					System.out.println("Not a valid input! Try again");
					sc.next();
				}

				arr1[i][j] = sc.nextInt();
			}
		System.out.println("Matrix is : "+rm.isRowMagic(arr1,m,n));
		
		sc.close();
		
	}

}
