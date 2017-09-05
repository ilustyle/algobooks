import java.util.Scanner;

public class BruteMatching {
	
	static String t;
	static String p;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		t = sc.nextLine(); 
		p = sc.nextLine();
		int n = t.length();
		int m = p.length();
		
		int i, j;
		
		for(i = 0; i <= n - m; i++)
		{
			for(j = 0; j < m; j++)
			{
				if(t.charAt(i + j) != p.charAt(j)) break;
			}
			if(j == m){
				System.out.println(t.substring(i));
				break;
			}
		}
		
		
		sc.close();
	}
}
