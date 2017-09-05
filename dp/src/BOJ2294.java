// 동전2 - https://www.acmicpc.net/problem/2294
import java.util.Scanner;

public class BOJ2294 {
	static int N, K;
	static int[] coin;
	static int[] memo;
	public static int coinChange(int money)
	{ 
		if(memo[money] != 0) return memo[money];
		if(money == 0) return 0;
		int min = 0xffffff;
		for(int i = 0; i < coin.length; i++)
		{
			if(money < coin[i]) continue;
			int ret = coinChange(money - coin[i]);
			
			if(ret == -1) continue;			
			if(min > ret) min = ret;
		}
		if(min < 0xffffff) return memo[money] = min + 1;
		else return memo[money] = -1;
	}
	public static int coinChange_iter(int money)
	{ 
		memo[0] = 0;
		for(int j = 1; j <= money; j++)
		{
			int min = 0xffffff;
			for(int i = 0; i < coin.length; i++)
			{
				if(j < coin[i]) continue;		
				if(memo[j - coin[i]] == -1) continue;
				
				if(min > memo[j - coin[i]])
					min = memo[j - coin[i]];
			}
			if(min != 0xffffff)
				memo[j] = min + 1;
			else memo[j] = -1;
		}
		return memo[money]; 
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		coin = new int[N];
		memo = new int[K + 1];
		
		for(int i = 0; i < N; i++)
			coin[i] = sc.nextInt();
		for(int i = 0; i <= K; i++)
			memo[i] = 0;
		System.out.println(coinChange(K));
		//System.out.println(coinChange_iter(K));
		sc.close();
	}
}
