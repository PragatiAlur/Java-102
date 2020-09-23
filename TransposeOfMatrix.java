package additionalPrograms;
import java.util.*;
public class TransposeOfMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Please enter rows and columns of matrix 1");
		int row = sc.nextInt();
		int column = sc.nextInt();
		int[][] matrix = new int[row][column];
		System.out.println(" Enter values of matrix 1");
		for(int i=0; i<row; i++)
			for(int j=0; j<column; j++)
				matrix[i][j] = sc.nextInt();
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<column; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
		
		int[][] transposeMatrix = new int[column][row];
		
		for(int i=0; i<column; i++)
			for(int j=0; j<row; j++)
				transposeMatrix[i][j] = matrix[j][i];
		for(int i=0; i<column; i++) {
			for(int j=0; j<row; j++)
				System.out.print(transposeMatrix[i][j]+"  ");
			System.out.println();
		}
		sc.close();
	}

}
