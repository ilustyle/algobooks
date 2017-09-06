import java.util.Scanner;

public class Day3_1Subset {
	static int[] cost;		// 병원 건설 비용
	static int[][] G;		// 인접 행렬
	static int[] bits;
	static int N;			// 마을 수
	static int min;			// 최소 비용
	
	static int processSolution() {
		int sum = 0;
		boolean[] town = new boolean[N];
		for(int i = 0; i < N; i++)
		{
			if(bits[i] == 0) continue;
			sum += cost[i];
			town[i] = true;
			for(int j = 0; j < N; j++)
				if(G[i][j] == 1) town[j] = true;
		}
		int cnt = 0;
		for(int j = 0; j < N; j++)
			if(town[j]) cnt++;
		if(cnt == N) return sum;
		else return 0xffffff;
	}
	static void solve(int k)
	{
		if (k == N)	{	
			int sum = processSolution();
			System.out.printf("비용 = %d\n", sum);
			if (sum < min)	min = sum;
			return;
		}		
		bits[k] = 0; solve(k + 1);
		bits[k] = 1; solve(k + 1);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cost = new int[N];
		G = new int[N][N];
		bits = new int[N];
		
		for(int i = 0; i < N; i++)
			cost[i] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				G[i][j] = sc.nextInt();
		}
		min = 0xffffff;
		solve(0);
		
		System.out.println(min);
		sc.close();
	}
}
