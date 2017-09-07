import java.util.Scanner;

public class Day4_1Paper {

	static int[] paper = new int[]{1, 1, 2};
	static long[] memo = new long[100];	
	static long solve_recur(int len)
	{
		if(len == 1) return 2;
		if(len == 2) return 5;
		if(memo[len] != 0) return memo[len];
		
		return memo[len] = solve_recur(len - 1)*2 + solve_recur(len - 2);
	}
	static long solve_iter(int len){
		long[] dp = new long[len + 1];
		
		dp[1] = 2; dp[2] = 5;
		for(int i = 3; i <= len; i++)
			dp[i] = dp[i - 1]*2 + dp[i - 2];
		
		return dp[len];
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			int N = sc.nextInt();
			
			System.out.println(solve_recur(N));
			System.out.println(solve_iter(N));
		}
		
		sc.close();
	}
}
