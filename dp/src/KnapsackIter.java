public class KnapsackIter {
	static int W = 10;
	static int N = 4;
	static int max = 0;
	static int[] w = new int[]{0, 5, 4, 6, 3};
	static int[] v = new int[]{0, 10, 40, 30, 50};
	static int[][] memo = new int[N + 1][W + 1];
	
	// 반복 
	public static int knapsack(int k, int W)
	{
		for(int i = 1; i <= k; i++)
		{
			for(int j = 1; j <= W; j++)
			{
				int case1 = 0, case2 = 0;
		
				if( j >= w[i]) 
					case1 = memo[i - 1][j - w[i]] + v[i];
				case2 = memo[i - 1][j];
				
				int max = case1 > case2? case1: case2;
				
				memo[i][j] = max;
			}
		}
		return memo[k][W];
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
