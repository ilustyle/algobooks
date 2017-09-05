import java.util.Scanner;

class Main{
	
	static int MAXN = 16;
	static int[][] memo = new int[MAXN][1 << MAXN];
	static int[][] G = new int[MAXN][MAXN];
	static int N;
	// curr: 방문한 정점 집합(visit)에서 마지막으로 방문한 정점
	static int tsp(int curr, int visit) 
	{
		if (visit == ((1 << N) - 1))
		{
			return G[curr][0];
		}
		if (memo[curr][visit] != 0) return memo[curr][visit];
		int min = 0xfffffff;
		for (int next = 0; next < N; next++)    // next: 다음 방문할 정점
		{
			if ((visit & (1 << next)) != 0) continue;
			if (G[curr][next] == 0) continue;
			int ret = tsp(next, visit | (1 << next)) + G[curr][next];
			if (min > ret) min = ret;
		}
		return memo[curr][visit] = min;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
			
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				G[i][j] = sc.nextInt();
		}
		System.out.println(tsp(0, 1));  // 0번(시작점)만 방문하 상태
		sc.close();
	}
}