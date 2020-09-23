package additionalPrograms;
import java.util.*;

public class CompleteString {
	
	static boolean findAtoZ(String input)
	{
		if(input.length()<26)
			return false;
		int index = 0;
        boolean[] visited = new boolean[26];
 
        for (int id = 0; id < input.length(); id++) {
            if ('a' <= input.charAt(id) && input.charAt(id) <= 'z') {
                index = input.charAt(id) - 'a';
            } else if ('A' <= input.charAt(id) && input.charAt(id) <= 'Z') {
                index = input.charAt(id) - 'A';
            }
            visited[index] = true;
        }
 
        for (int id = 0; id < 26; id++) {
            if (!visited[id]) {
                return false;
            }
        }
        return true;
		}
		
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Please enter a line");
		String str = sc.nextLine();
		System.out.println(findAtoZ(str));
		sc.close();
	}
	
}
