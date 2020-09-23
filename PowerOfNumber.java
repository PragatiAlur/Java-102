package additionalPrograms;
import java.util.*;

public class PowerOfNumber {
	
	static int recursivePower(int num,int power)
	{
		if(power==0)
			return 1;
		int res = num*recursivePower(num,power-1);
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the number and power");
		int num = sc.nextInt();
		int power = sc.nextInt();
		System.out.println(num +" to the power "+ power +" is "+recursivePower(num,power));
		sc.close();
	}
	

}
