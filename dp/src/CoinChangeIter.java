public class CoinChangeIter {
	static int[] coin = new int[]{1, 4, 6};	
	static int[] memo = new int[1000];
	// 반복
	public static int coinChange(int money)
	{ 
		memo[0] = 0;
		
		for(int j = 1; j <= money; j++)
		{
			int min = 0xfff;
			for(int i = 0; i < coin.length; i++)
			{
				if(j < coin[i]) continue;
	
				int ret = memo[j - coin[i]];
				
				if(min > ret) min = ret;
			}
			memo[j] = min + 1;
		}		
		return memo[money]; 
	}
	public static void main(String[] args) {		
		
		System.out.println(coinChange(8));
		
		for(int i = 0; i <= 8; i++) 
			System.out.printf("%2d ", i);
		System.out.print("\n----------------------------------\n");
		for(int i = 0; i <= 8; i++) 
			System.out.printf("%2d ", memo[i]);
		System.out.print("\n");
	}
}
