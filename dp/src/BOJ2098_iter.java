/*
	* 외판원순회(3).cpp
	*
	https://www.acmicpc.net/problem/2098
	*/
import java.util.*;

public class BOJ2098 {
	
	
	static int[][] G = new int[16][16];
	static int[][] dp = new int[1 << 16][16];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++)	// 0번 정점 부터 저장
			for (int j = 0; j < n; j++)
				G[i][j] = sc.nextInt();
		
		for (int i = 0; i < (1 << n); i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = 0xfffffff;
		
		dp[1][0] = 0;
		
		for (int visit = 1; visit < (1 << n); visit++) // visit: 방문한 정점들의 집합
		{
			for (int last = 0; last < n; last++)		// last: 마지막 방문 정점
			{
				if ((visit & (1 << last)) == 0) continue; // 1번 방문하지 않은 경우 제외
				
				int prev = visit - (1 << last); 		 // 마지막 방문 정점을 제외
				
				for (int v = 0; v < n; v++)				 // prev 집합의 마지막 방문 정점들에 대해
				{
					if (G[v][last]==0 || (prev & (1 << v)) == 0) // 간선이 없거나, 비방문 정점 제외 
						continue;
					
					dp[visit][last] = Math.min(dp[visit][last], dp[prev][v] + G[v][last]);
				}
			}
		}
		int ans = 0xfffffff;
		for (int i = 1; i < n; i++)
			ans = Math.min(ans, dp[(1 << n) - 1][i] + G[i][0]);
		System.out.println(ans);
		sc.close();
	}
}
