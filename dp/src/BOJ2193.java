// 이친수
import java.util.Scanner;

public class Main {
	static long[] memo;
	static long solve(int n)
	{
		if(memo[n] != 0) return memo[n];
		if(n <= 2) return memo[n] = 1;
		return memo[n] = solve(n - 2) + solve(n - 1);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new long[n + 1];
		System.out.println(solve(n));
		
		sc.close();
	}
}
