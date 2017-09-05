// 로또 <https://www.acmicpc.net/problem/6603>
import java.util.Scanner;

public class BOJ6603 {
	static int k;
	static int[] S = new int[13];
	static int[] choice = new int[6];
	
	static void comb(int k, int n, int r, int start)
	{
		if(k == r){
			for(int i = 0; i < r; i++)
				System.out.print(choice[i] + " ");
			System.out.println();
			return;
		}
		for(int i = start; i < n - (r - k - 1); i++)
		{
			choice[k] = S[i];
			comb(k + 1, n, r, i + 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			k = sc.nextInt();
			if(k == 0) {
				sc.close();
				return;		
			}
			
			for(int i = 0; i < k; i++)
				S[i] = sc.nextInt();
			
			comb(0, k, 6, 0);			
			System.out.println();
		}	
	}
}
