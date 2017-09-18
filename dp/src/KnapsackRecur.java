public class KnapsackRecur {
	static int W = 10;
	static int N = 4;
	static int max = 0;
	static int[] w = new int[]{0, 5, 4, 6, 3};
	static int[] v = new int[]{0, 10, 40, 30, 50};
	static int[][] memo = new int[N + 1][W + 1];
	
	// 재귀
	public static int knapsack(int k, int W)
	{
		if(k == 0 || W == 0) return 0;
		
		int case1 = 0, case2 = 0;

		if( W >= w[k]) 
			case1 = knapsack(k - 1,  W - w[k]) + v[k];
		case2 = knapsack(k - 1,  W);
		
		return case1 > case2? case1: case2;
	}
		
	public static void main(String[] args) {
		
		System.out.println("최대 이익 = " + knapsack(N, W));
		
	}

}
