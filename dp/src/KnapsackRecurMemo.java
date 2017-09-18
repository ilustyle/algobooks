public class KnapsackRecurMemo {
	static int W = 10;
	static int N = 4;
	static int max = 0;
	static int[] w = new int[]{0, 5, 4, 6, 3};
	static int[] v = new int[]{0, 10, 40, 30, 50};
	static int[][] memo = new int[N + 1][W + 1];
	
	// 재귀 + 메모
	public static int knapsack(int k, int W)
	{
		if(memo[k][W] != -1) return memo[k][W];
		if(k == 0 || W == 0) return memo[k][W] = 0;
		
		int case1 = 0, case2 = 0;

		if( W >= w[k]) 
			case1 = knapsack(k - 1,  W - w[k]) + v[k];
		case2 = knapsack(k - 1,  W);
		
		int max = case1 > case2? case1: case2;
		
		return memo[k][W] = max;
	}
	public static void print_memo()
	{
		for(int i = 1; i <= N; i++)		
		{
			for(int j = 1; j <= W; j++)
					System.out.printf("%2d ", memo[i][j]);
			System.out.println();
		}
		System.out.println("-----------------------------------");
	}
	public static void init_memo()
	{
		for(int i = 1; i <= N; i++)		
			for(int j = 1; j <= W; j++)
					memo[i][j] = -1;
	}
	
	public static void main(String[] args) {
		init_memo();
		
		System.out.println("최대 이익 = " + knapsack(N, W));
		
		print_memo();
	}

}
