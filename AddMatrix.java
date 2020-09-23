package problem38;
import java.util.*;
public class AddMatrix {
	
	int[][] addMatrix ( int[][] m1 , int[][] m2)
	{
		int[][] add = new int[m1.length][m1.length];
		for(int i=0; i<m1.length; i++)
		{
			for(int j=0; j<m1.length; j++)
			{
				add[i][j]=m1[i][j]+m2[i][j];
			}
			
		}
		return add;
	}
	public static void main(String[] args) {
		AddMatrix ad = new AddMatrix();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of n : ");
		while (!sc.hasNextInt()) {
			System.out.println("Not a valid input! Try again");
			sc.next();
		}
		int n=sc.nextInt();
		int[][] m1 = new int[n][n];
		int[][] m2 = new int[n][n];
		System.out.println("Enter matrix 1 element");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				while (!sc.hasNextInt()) {
					System.out.println("Not a valid input! Try again");
					sc.next();
				}

				m1[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter matrix 2 element");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				while (!sc.hasNextInt()) {
					System.out.println("Not a valid input! Try again");
					sc.next();
				}

				m2[i][j] = sc.nextInt();
			}
		}
		int[][] a = ad.addMatrix(m1, m2);
		for(int i=0; i<n; i++)
		{
			System.out.print("[");
			for(int j=0; j<n; j++)
			{
				System.out.print(" "+a[i][j]);
			}
			System.out.println("]");
		}
		sc.close();
	}
}
